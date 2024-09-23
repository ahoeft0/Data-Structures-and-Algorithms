/**
 *
 * @author Ashton Hoeft
 * @version January 14, 2023
 * 
 * This program declares the methods and variables for the Hourly class.
 * 
 */
public class Hourly extends Employee {
    private String position;
    private double hourlyRate;
    private static int hourlyCount;
    
    /**
     * Constructor for Hourly class
     * @param id
     * @param name
     * @param position
     * @param hourlyRate 
     */
    public Hourly(int id, String name, String position, double hourlyRate) {
        super(id, name);
        this.position = position;
        this.hourlyRate = hourlyRate;
        hourlyCount++;    
    }
    
    /**
     * 
     * @return position of employee 
     */
    public String getPosition() {return position;}
    
    /**
     * 
     * @param position updates position instance variable
     */
    public void setPosition(String position) {this.position = position;}
    
    /**
     * 
     * @return hourly rate
     */
    public double getHourlyRate() {return hourlyRate;}
    
    /**
     * 
     * @param hourlyRate sets hourlyRate instance variable
     */
    public void setHourlyRate(double hourlyRate) {this.hourlyRate = hourlyRate;}
    
    /**
     * 
     * @return number of Hourly objects created by user
     */
    public int getHourlyEmployeeCount() {return hourlyCount;}
    
    /**
     * 
     * @return contents of Hourly instance
     */
    public String toString()
    {
        return super.toString() + ":" + getClass().getName() + "@" + position + ":" + hourlyRate;
    }
    
    /**
     * 
     * @param o
     * @return true if equal, false otherwise
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Hourly ) )
            return false;
        
        Hourly h = ( Hourly ) o;
        
        return super.equals( h )
                && position.equals( h.position )
                && hourlyRate == h.hourlyRate;
    }   
}
