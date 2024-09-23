/**
 *
 * @author Ashton Hoeft
 * @version January 14, 2023
 * 
 * This declares the variables and methods for Salaried class.
 * 
 */
public class Salaried extends Employee {
    
    private String title;
    private double salary;
    private static int salariedCount;
    
    /**
     * 
     * @param id
     * @param name
     * @param title
     * @param salary 
     */
    public Salaried( int id, String name, String title, double salary )
    {
        super( id, name );
        this.title = title;
        this.salary = salary;
        salariedCount++;
    }
    
    /**
     * 
     * @return title
     */
    public String getTitle( ) { return title; }
    
    /**
     * 
     * @param title updates title
     */
    public void setTitle( String title ) { this.title = title; }
    
    /**
     * 
     * @return salary
     */
    public double getSalary( ) { return salary; }
    
    /**
     * 
     * @param salary updates salary
     */
    public void setSalary( double salary ) { this.salary = salary; }
    
    /**
     * 
     * @return number of times Salaried constructor has been called
     */
    public int getSalariedEmployeeCount() {return salariedCount;}
    
    /**
     * 
     * @return contents of instance
     */
    public String toString()
    {
        return super.toString() + ":" + getClass().getName() + "@" + title + ":" + salary;
    }
    
    /**
     * 
     * @param o
     * @return true if equal, false otherwise
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Salaried ) )
            return false;
        
        Salaried s = ( Salaried ) o;
        
        return super.equals( s )
                && title.equals( s.title )
                && salary == s.salary;
    }    
}
