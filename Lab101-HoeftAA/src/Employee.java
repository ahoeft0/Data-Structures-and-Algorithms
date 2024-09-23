/**
 *
 * @author Ashton Hoeft
 * @version January 14, 2023
 * 
 * This program declares the methods and variables for Employee class.
 * 
 */
public class Employee {
    
    private static int employeeCount = 0;
    private int id;
    private String name;  // the employees name
    
    /**
     * Constructor for the Employee class
     * @param id
     * @param name 
     */
    public Employee( int id, String name ) {
        this.id = id;
        this.name = name;
        employeeCount++;
    }
    
    /**
     * 
     * @return id
     */
    public int getId( ) { return id; }
    
    /**
     * 
     * @param id updates id instance variable
     */
    public void setId( int id ) { this.id = id; }
    
    /**
     * 
     * @return name
     */
    public String getName() { return name; }
    
    
    /**
     * 
     * @param name updates name instance variable
     */
    public void setName( String name ) { this.name = name; }
    
    /**
     * 
     * @return number of time Employee constructor called
     */
    public int getEmployeeCount() { return employeeCount; }
    
    /**
     * 
     * @return contents of Employee instance
     */
    public String toString(){
        return getClass().getName() + "@" + id + ":" + name + ":" + employeeCount;
    }
    
    /**
     * 
     * @param o  object to be compared
     * @return  true if objects equal
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Employee ) )
            return false;
        Employee e = ( Employee ) o;
        
        return id == e.id
                && name.equals( e.name );
    }
    
}
