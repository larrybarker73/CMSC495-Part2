package videoRentalClasses;


import videoRentalClasses.Rental;
import videoRentalClasses.Video;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * DatabaseManager
 * The database subsystem that communicates directly with the MySQL Back-End
 * subsystem so that the GUI remains independent of it.
 *
 * An excellent tutorial on MySQL in Java:
 *              http://zetcode.com/db/mysqljava/
 */

public class DatabaseManager 
{
    //--------------------------------------------------------------------------
    // Data Members
    //--------------------------------------------------------------------------
    
    // Database Server and Login Information
    private String m_address;
    private String m_user;
    private String m_databasePassword;
    private String m_databaseName;
    private int m_port;
    
    //--------------------------------------------------------------------------
    // Inner Enumeration of possible database results referenced by the GUI
    // to determine what errors happened and how to present them to the user.
    //--------------------------------------------------------------------------
    public enum DbResult
    {
        DB_OK,
        DB_ERR_QUERY,
        DB_ERR_BAD_INPUT,
        DB_ERR_NO_CONNECTION,
        DB_ERR_NO_RECORD,
        DB_ERR_RECORD_EXISTS,
        DB_ERR_HAS_RENTALS,
        DB_ERR_NOT_AVAILABLE,
        DB_ERR_AT_RENTAL_LIMIT,
        DB_ERR_HAS_LATE_FEES,
        DB_ERR_ALREADY_RENTED
    }
    
    //--------------------------------------------------------------------------
    // Constructor (Lifecycle)
    //--------------------------------------------------------------------------
    public DatabaseManager(String address, String user, String password, 
            String databaseName, int port)
    {
        m_address = address;
        m_user = user;
        m_databasePassword = password;
        m_databaseName = databaseName;
        m_port = port;
    }
    
    //--------------------------------------------------------------------------
    // Searching Videos
    // Provide the details to the function on which one wishes to search. An
    // id of 0 indicates that you are disregarding id numbers as a search
    // parameter. For the Strings, passing in null will indicate that they
    // do not have search requirements. If you want the title to be treated as
    // an exact match and not a wildcard/partial match, set exactMatch = true.
    //--------------------------------------------------------------------------
    public ArrayList<Video> searchVideos(boolean exactMatch,
            int id,
            String title,
            String type,
            String rating,
            String length,
            String year,
            String director)
    {
        // Create our list of returned objects
        ArrayList<Video> videos = new ArrayList();
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        ResultSet results = null;
        
        try 
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "SELECT * FROM movie WHERE ";
            if(id != 0)
            {
                queryString += "movie_id = ? ";
            }
            else
            {
                queryString += "movie_id >= ? ";
            }
            
            if(title != null || type != null || rating != null || length != null || year != null || director != null)
            {
                queryString += "AND ";
                
                boolean needsAnd = false;
                if(title != null)
                {
                    if(exactMatch)
                    {
                        queryString += "title=\"" + title + "\"";
                    }
                    else
                    {
                        queryString += "title LIKE \"%" + title + "%\" ";
                    }
                    
                    needsAnd = true;
                }
                
                if(type != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "type = " + type + " ";
                    needsAnd = true;
                }
                
                if(rating != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "rating = " + rating + " ";
                    needsAnd = true;
                }
                
                if(length != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "length = " + length + " ";
                    needsAnd = true;
                }
                
                if(year != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "year_released = " + year + " ";
                    needsAnd = true;
                }
                
                if(director != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "director = " + director + " ";
                }
                
                queryString += "ORDER BY title ASC";
            }
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setInt(1, id);
            
            // Execute the query and iterate the results
            results = query.executeQuery();            
            while(results.next())
            {
                // Create a new object from the result and add it to the list
                Video video = new Video(results.getInt("movie_id"),
                    results.getString("title"),
                    results.getString("type"),
                    results.getString("rating"),
                    results.getString("length"),
                    results.getString("year_released"),
                    results.getString("director"),
                    results.getInt("total_number_of_movies"));
                
                videos.add(video);
            }
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        
        // Return results in the appropriate system format
        return videos;
    }
    
    //--------------------------------------------------------------------------
    // Searching Customers
    // Provide the details to the function on which one wishes to search. An
    // id of 0 indicates that you are disregarding id numbers as a search
    // parameter. For the Strings, passing in null will indicate that they
    // do not have search requirements. If you want the first and last names to 
    // be treated as an exact match and not a wildcard/partial match, 
    // set exactMatch = true.
    //--------------------------------------------------------------------------
    public ArrayList<Customer> searchCustomers(boolean exactMatch,
            int id,
            String firstName,
            String lastName,
            String phoneNumber)
    {
        // Create our list of returned objects
        ArrayList<Customer> customers = new ArrayList();
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        ResultSet results = null;
        
        try 
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "SELECT * FROM customer WHERE ";
            if(id != 0)
            {
                queryString += "cust_id = ? ";
            }
            else
            {
                queryString += "cust_id >= ? ";
            }
            
            if(firstName != null || lastName != null || phoneNumber != null)
            {
                queryString += "AND ";
                
                boolean needsAnd = false;
                if(firstName != null)
                {
                    if(exactMatch)
                    {
                        queryString += "first_name = \"" + firstName + "\"";
                    }
                    else
                    {
                        queryString += "first_name LIKE \"%" + firstName + "%\" ";
                    }
                    
                    needsAnd = true;
                }
                
                if(lastName != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    if(exactMatch)
                    {
                        queryString += "last_name = \"" + lastName + "\"";
                    }
                    else
                    {
                        queryString += "last_name LIKE \"" + lastName + "%\" ";
                    }
                    
                    needsAnd = true;
                }
                
                if(phoneNumber != null)
                {
                    if(needsAnd)
                    {
                        queryString += "AND ";
                    }
                    
                    queryString += "phone = \"" + phoneNumber + "\" ";
                }
                
                queryString += "ORDER BY last_name ASC";
            }
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setInt(1, id);
            
            // Execute the query and iterate the results
            results = query.executeQuery();            
            while(results.next())
            {
                int holdValue = results.getInt("hold_on_account");
                boolean holdOnAccount = false;
                if(holdValue != 0)
                {
                    holdOnAccount = true;
                }
                
                // Create a new object from the result and add it to the list
                Customer customer = new Customer(results.getInt("cust_id"),
                    results.getString("first_name"),
                    results.getString("last_name"),
                    results.getString("street_address"),
                    results.getString("city"),
                    results.getString("state"),
                    results.getString("zip_code"),
                    results.getString("phone"),
                    holdOnAccount);
                
                customers.add(customer);
            }
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);                
            }
        }
        
        // Return results in the appropriate system format
        return customers;
    }
    
    //--------------------------------------------------------------------------
    // Adding Videos to the system
    // All fields are required. Any null values will result in
    // incorrect data errors being thrown.
    //--------------------------------------------------------------------------
    public DbResult addVideo(String title,
            String type,
            String rating,
            String length,
            String year,
            String director,
            int totalNumberOfMovies)
    {        
        // Verify input as being valid
        if(title == null || type == null || rating == null || length == null || 
                year == null || director == null || totalNumberOfMovies < 1)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        // First see if this video already exists in the system. It's ok if
        // the movie is the same title, but different year. If they are the
        // same; however, they cannot be added!
        ArrayList<Video> existanceCheck = searchVideos(true, 0, title, null, null, null, year, null);
        if(!existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_RECORD_EXISTS;
        }
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "INSERT INTO movie (title, type, rating, length, year_released, director, total_number_of_movies) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setString(1, title);
            query.setString(2, type);
            query.setString(3, rating);
            query.setString(4, length);
            query.setString(5, year);
            query.setString(6, director);
            query.setInt(7, totalNumberOfMovies);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }
    
    //--------------------------------------------------------------------------
    // Adding Customers to the system
    // All fields are required. Any null values will result in
    // incorrect data errors being thrown.
    //--------------------------------------------------------------------------
    public DbResult addCustomer(String firstName,
            String lastName,
            String streetAddress,
            String city,
            String state,
            String zipCode,
            String phoneNumber)
    {        
        // Verify input parameters as valid
        if(firstName == null || lastName == null || streetAddress == null || 
                city == null || state == null || zipCode == null || 
                phoneNumber == null)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        // First see if this customer already exists in the system. It's ok if
        // the customer has the same first and last name as another, but the
        // phone numbers must differ.
        ArrayList<Customer> existanceCheck = searchCustomers(true, 0, firstName, lastName, phoneNumber);
        if(!existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_RECORD_EXISTS;
        }
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "INSERT INTO customer (first_name, last_name, street_address, city, state, zip_code, phone) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setString(1, firstName);
            query.setString(2, lastName);
            query.setString(3, streetAddress);
            query.setString(4, city);
            query.setString(5, state);
            query.setString(6, zipCode);
            query.setString(7, phoneNumber);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }
    
    //--------------------------------------------------------------------------
    // Editing Existing Videos in the System
    // Pass in the Video object of the one that was edited.
    //--------------------------------------------------------------------------
    public DbResult updateVideo(Video video)
    {        
        // Verify input as being valid
        if(video == null)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        // First make sure this video actually exists! You can't edit a video
        // that doesn't exist and MySQL has no means of doing an "upsert" operation
        // like some of the newer database models.
        ArrayList<Video> existanceCheck = searchVideos(true, video.m_id, null, null, null, null, null, null);
        if(existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_NO_RECORD;
        }
        
        // The existence check passed, so now make sure this movie doesn't exist
        // within the same year, thus making multiple entries of the same
        // inventory item.
        ArrayList<Video> duplicateCheck = searchVideos(true, 0, video.m_title, null, null, null, video.m_year, null);
        if(duplicateCheck.size() > 0)
        {
            return DbResult.DB_ERR_RECORD_EXISTS;
        }
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "UPDATE movie SET title=?, type=?, rating=?, length=?, year_released=?, director=? WHERE movie_id=?";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setString(1, video.m_title);
            query.setString(2, video.m_type);
            query.setString(3, video.m_rating);
            query.setString(4, video.m_length);
            query.setString(5, video.m_year);
            query.setString(6, video.m_director);
            query.setInt(7, video.m_id);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }
    
    //--------------------------------------------------------------------------
    // Editing Existing Customers in the System
    // Provide the updated Customer object as input.
    //--------------------------------------------------------------------------
    public DbResult updateCustomer(Customer customer)
    {           
        // Verify input as being valid
        if(customer == null)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        // First make sure this customer actually exists! You can't edit a customer
        // that doesn't exist and MySQL has no means of doing an "upsert" operation
        // like some of the newer database models.
        ArrayList<Customer> existanceCheck = searchCustomers(true, customer.m_id, null, null, null);
        if(existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_NO_RECORD;
        }
        
        // The existence check passed, so now make sure this customer doesn't exist
        // within the same year, thus making multiple entries of the same
        // inventory item.
        ArrayList<Customer> duplicateCheck = searchCustomers(true, 0, customer.m_firstName, customer.m_lastName, customer.m_phoneNumber);
        if(duplicateCheck.size() > 0)
        {
            return DbResult.DB_ERR_RECORD_EXISTS;
        }
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "UPDATE customer SET first_name=?, last_name=?, street_address=?, city=?, state=?, zip_code=?, phone=?, hold_on_account=? WHERE cust_id=?";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setString(1, customer.m_firstName);
            query.setString(2, customer.m_lastName);
            query.setString(3, customer.m_streetAddress);
            query.setString(4, customer.m_city);
            query.setString(5, customer.m_state);
            query.setString(6, customer.m_zipCode);
            query.setString(7, customer.m_phoneNumber);
            
            if(customer.m_holdOnAccount)
            {
                query.setInt(8, 1);
            }
            else
            {
                query.setInt(8, 0);
            }
            
            query.setInt(9, customer.m_id);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }    
    
    //--------------------------------------------------------------------------
    // Removing a Video
    // Simply provide the ID # (field: movie_id) of the video being removed.
    //--------------------------------------------------------------------------
    public DbResult removeVideo(int id)
    {
        // Make sure this video actually exists first.
        ArrayList<Video> existanceCheck = searchVideos(true, id, null, null, null, null, null, null);
        if(existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_NO_RECORD;
        }
        
        /*
        //TODO: Now check that there are no outstanding rentals on this video.
        //Sprint 2 Functionality (gnelson)
        */
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "DELETE FROM movie WHERE movie_id=?";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setInt(1, id);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }
    
    //--------------------------------------------------------------------------
    // Removing a Customer
    // Simply provide the ID # (field: cust_id) of the customer being removed.
    //--------------------------------------------------------------------------
    public DbResult removeCustomer(int id)
    {
        // Make sure this customer actually exists first.
        ArrayList<Customer> existanceCheck = searchCustomers(true, id, null, null, null);
        if(existanceCheck.isEmpty())
        {
            return DbResult.DB_ERR_NO_RECORD;
        }
        
        /*
        //TODO: Now check that there are no outstanding rentals or late fees
        //      on this customer before deleting. Can check by pulling the
        //      rental transactions and seeing if any are there at all and open.
        //Sprint 2 Functionality (gnelson)
        */
        
        // Create database objects to manage connectivity and querying
        Connection conn = null;
        PreparedStatement query = null;
        
        try
        {
            // Open the database connection
            conn = DriverManager.getConnection(m_address, m_user, m_databasePassword);
            
            // Write the string and prepare the statement for querying
            String queryString = "DELETE FROM customer WHERE cust_id=?";
            
            // Create the prepared statement and plug in the data from
            // the method parameters
            query = conn.prepareStatement(queryString);
            query.setInt(1, id);
            
            // Execute the query
            query.executeUpdate();
        } 
        catch(SQLException ex) 
        {
            // Log any errors
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
            return DbResult.DB_ERR_QUERY;
        }
        finally
        {
            try
            {
                // Close out the query and the connection to the database
                if(query != null)
                {
                    query.close();
                }
                
                if(conn != null)
                {
                    conn.close();
                }
            }
            catch(SQLException ex)
            {
                // Log any errors
                Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex); 
                return DbResult.DB_ERR_QUERY;               
            }
        }
        
        // Return results in the appropriate system format
        return DbResult.DB_OK;
    }
    
    //--------------------------------------------------------------------------
    // Retrieve Rental Transactions
    // Provide the ID of the movie and ID of the customer to retrieve specific
    // transactions. Both IDs may be passed in as 0 if you want to retrieve
    // all transactions. You may also provide one ID over another.
    //--------------------------------------------------------------------------
    public ArrayList<Rental> getRentalTransactions(int videoId, int customerId)
    {
        ArrayList<Rental> rentals = new ArrayList();
        
        //TODO - Sprint 2 Functionality (gnelson)
        
        return rentals;
    }
        
    //--------------------------------------------------------------------------
    // Rent a Video to a Customer
    // Provide the ID of the video and the ID of the customer. Both must be
    // valid input in order for the rental to proceed.
    //--------------------------------------------------------------------------
    public DbResult rentVideo(int videoId, int customerId)
    {
        // Verify input parameters
        if(videoId < 1 || customerId < 1)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        //TODO - Sprint 2 Functionality (gnelson)
        return DbResult.DB_OK;
    }
        
    //--------------------------------------------------------------------------
    // Return a Video from a Customer
    // Provide the ID of the video and the ID of the customer. Both must be
    // valid input in order for the rental to to be returned.
    //--------------------------------------------------------------------------
    public DbResult returnVideo(int videoId, int customerId)
    {
        // Verify input parameters
        if(videoId < 1 || customerId < 1)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        //TODO - Sprint 2 Functionality (gnelson)
        return DbResult.DB_OK;
    }
        
    //--------------------------------------------------------------------------
    // Pay Late Fees
    // Pulls a list of transactions by the customer that have late fees
    // associated with them due to the lapse of time from the original 
    // check-out date and marks them as paid.
    //--------------------------------------------------------------------------
    public DbResult payLateFees(int customerId)
    {
        // Verify input parameters
        if(customerId < 1)
        {
            return DbResult.DB_ERR_BAD_INPUT;
        }
        
        //TODO - Sprint 2 Functionality (gnelson)
        return DbResult.DB_OK;
    }
}
