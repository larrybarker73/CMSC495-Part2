package videoRentalClasses;

/*
 * Customer
 * Representation of a single customer in the Video Rental Management System.
 */

public class Customer 
{
    //--------------------------------------------------------------------------
    // Data Members
    //--------------------------------------------------------------------------
    public int m_id = 0;
    public String m_firstName;
    public String m_lastName;
    public String m_streetAddress;
    public String m_city;
    public String m_state;
    public String m_zipCode;
    public String m_phoneNumber;
    public boolean m_holdOnAccount;
    
    // List of rental transactions on this customer's account
    //TODO ArrayList<Rental> m_rentals = new ArrayList();
    
    //--------------------------------------------------------------------------
    // Constructor (Lifecycle)
    //--------------------------------------------------------------------------
    public Customer(int id,
            String firstName,
            String lastName,
            String streetAddress,
            String city,
            String state,
            String zipCode,
            String phoneNumber,
            boolean holdOnAccount)
    {
        m_id = id;
        m_firstName = firstName;
        m_lastName = lastName;
        m_streetAddress = streetAddress;
        m_city = city;
        m_state = state;
        m_zipCode = zipCode;
        m_phoneNumber = phoneNumber;
        m_holdOnAccount = holdOnAccount;
    }
        
    //--------------------------------------------------------------------------
    // Copy Constructor (Shallow Copy, otherwise it will copy the deep
    // reference in Java and overwrite original data!)
    //--------------------------------------------------------------------------
    public Customer(Customer customer)
    {
        m_id = customer.m_id;
        m_firstName = customer.m_firstName;
        m_lastName = customer.m_lastName;
        m_streetAddress = customer.m_streetAddress;
        m_city = customer.m_city;
        m_state = customer.m_state;
        m_zipCode = customer.m_zipCode;
        m_phoneNumber = customer.m_phoneNumber;
        m_holdOnAccount = customer.m_holdOnAccount;        
    }
}
