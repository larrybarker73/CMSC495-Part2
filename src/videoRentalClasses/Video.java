package videoRentalClasses;

/*
 * Video
 * Representation of a single video in the Video Rental Management System.
 */

public class Video 
{
    //--------------------------------------------------------------------------
    // Data Members
    //--------------------------------------------------------------------------
    public int m_id = 0;
    public String m_title = "";
    public String m_type = "";
    public String m_rating = "";
    public String m_length = "";
    public String m_year = "";
    public String m_director = "";
    public int m_totalNumberOfMovies = 0;
    
    //--------------------------------------------------------------------------
    // Constructor (Lifecycle)
    //--------------------------------------------------------------------------
    public Video(int id,
            String title,
            String type,
            String rating,
            String length,
            String year,
            String director,
            int totalNumberOfMovies)
    {
        m_id = id;
        m_title = title;
        m_type = type;
        m_rating = rating;
        m_length = length;
        m_year = year;
        m_director = director;
        m_totalNumberOfMovies = totalNumberOfMovies;
    }
    
    //--------------------------------------------------------------------------
    // Copy Constructor (Shallow Copy, otherwise it will copy the deep
    // reference in Java and overwrite original data!)
    //--------------------------------------------------------------------------
    public Video(Video video)
    {
        m_id = video.m_id;
        m_title = video.m_title;
        m_type = video.m_type;
        m_rating = video.m_rating;
        m_length = video.m_length;
        m_year = video.m_year;
        m_director = video.m_director;
        m_totalNumberOfMovies = video.m_totalNumberOfMovies;
    }
}
