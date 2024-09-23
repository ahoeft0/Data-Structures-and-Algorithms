/**
 *
 * @author Ashton Hoeft
 * @version January 14, 2023
 * 
 * This program tests the Employee class and its subclasses.
 * 
 */
public class Client {
    public static void main(String[] args) {
        //Create an array of Employees
        Employee [] employeeList = new Employee[10];
        
        //Create Employee subclass objects
        Salaried employee0 = new Salaried(0, "Al", "Manager", 60000);
        Hourly employee1 = new Hourly(1, "Kelly", "Hostess", 25.75);
        Salaried employee2 = new Salaried(2, "Peggy", "CEO", 120000);
        Hourly employee3 = new Hourly(3, "Bud", "Busboy", 15.00);
        Hourly employee4 = new Hourly(4, "Marcy", "Server", 10.00);
        Hourly employee5 = new Hourly(5, "Jefferson", "Cook", 35.00);
        
        //Add Employee objects to the array
        employeeList[0] = employee0;
        employeeList[1] = employee1;
        employeeList[2] = employee2;
        employeeList[3] = employee3;
        employeeList[4] = employee4;
        employeeList[5] = employee5;
        
        //Print the information from each Employee in the array
        for(int i = 0; i < employeeList.length; i++) {
            System.out.println(employeeList[i]);
        }
        System.out.println("");
        
        //Give each Employee a 25% raise
        for(int i = 0; i < employeeList.length - 1; i++) {
            if(employeeList[i] instanceof Hourly) {
                Hourly temp = (Hourly) employeeList[i];
                double newHourlyRate = temp.getHourlyRate() * 1.25;
                temp.setHourlyRate(newHourlyRate);
                employeeList[i] = temp;
            }
            else if(employeeList[i] instanceof Salaried){
                Salaried temp = (Salaried) employeeList[i];
                double newSalary = (temp.getSalary() * 1.25);
                temp.setSalary(newSalary);
                employeeList[i] = temp;
            }
            else {
                
            }
        }
        
        //Print the updated information of each Employee
        for(int i = 0; i < employeeList.length; i++) {
            if(employeeList[i] != null)
                System.out.println(employeeList[i].toString());
        }
        System.out.println("");
        
        //Declare objects to use for equals tests
        Hourly h = new Hourly(1, "Kelly", "Hostess", 32.1875);
        Salaried s = new Salaried(0, "Al", "Manager", 75000.0);
        
        //Test the equals function for Hourly class
        System.out.println("Hourly equals test:");
        System.out.println(employeeList[1].equals(h));
        System.out.println(employeeList[1].equals(employeeList[4]) + "\n");
        
        //Test the equals function for Salaried class
        System.out.println("Salaried equals test:");
        System.out.println(employeeList[0].equals(s));
        System.out.println(employeeList[0].equals(employeeList[2]));
    }   
}
