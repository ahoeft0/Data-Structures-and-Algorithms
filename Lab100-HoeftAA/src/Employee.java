/**
 *
 * @author Ashton Hoeft
 * @version January 12, 2023
 * 
 * The Employee class contains the information about an employee.
 * 
 */

public class Employee {
    private int id;
    private String name;
    private int salary;
    private double hourlyRate;
    public Employee( )
    {
        id = 0;
        name = null;
        salary = 0;
        hourlyRate = 0.0;
    }
    public Employee( int id, String name, int salary, double hourlyRate )
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
        setHourlyRate( hourlyRate );
    }
    public int getId( ) {
        return id;
    }
    public String getName( )
    {
        return name;
    }
    public int getSalary( )
    {
        return salary;
    }
    public double getHourlyRate( )
    {
        return hourlyRate;
    }
    public void setId( int newId )
    {
        id = newId;
    }
    public void setName( String newName )
    {
        name = newName;
    }
    public void setSalary( int newSalary )
    {
        salary = newSalary;
    }  
    public void setHourlyRate( double newHourlyRate )
    {
        if ( newHourlyRate < 0.00 )
            hourlyRate = 0;
        else
            hourlyRate = newHourlyRate;
    }
    public String toString( )
    {
        return getClass().getName() + ":" + id + ":" + name + ":" + salary + ":" + hourlyRate;
    }
    public boolean equals( Object o )
    {
        if ( !( o instanceof Employee ) )
            return false;   
        Employee e = ( Employee ) o;
        return id == e.id
                && name.equals( e.name )
                && salary == e.salary
                && Math.abs( hourlyRate - e.hourlyRate ) < .01;        
    }
}