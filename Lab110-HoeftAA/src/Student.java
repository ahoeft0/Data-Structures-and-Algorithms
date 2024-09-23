//Import classes

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Ashton Hoeft
 * @version 4/24/2023
 *
 * The Student class defines its methods and instance variables
 */
public class Student {

    //Declare instance variables
    private int id;
    private String lname;
    private String fname;
    private String standing;
    private float gpa;

    //Declare static instance variables
    private static final ArrayList<Integer> unusedIDs = new ArrayList(10000000);
    private static boolean generated = false;
    private static int studentCount;
    private static double seniors;
    private static double juniors;
    private static double sophomores;
    private static double freshman;
    private static double gpa4;
    private static double gpa3;
    private static double gpa2;
    private static double gpa1;
    private static double gpa0;

    /**
     *
     * Default constructor for Student that randomly assigns values to the
     * instance variables using the assign methods
     */
    public Student() {
        studentCount++;
        id = assignId();
        lname = assignLastName();
        fname = assignFirstName();
        standing = assignStanding();
        gpa = assignGPA();
    }

    /**
     *
     * @return number of Student objects
     */
    public int getStudentCount() {
        return studentCount;
    }

    /**
     *
     * @return id of Student
     */
    public int getID() {
        return id;
    }

    /**
     *
     * @return last name of Student
     */
    public String getLastName() {
        return lname;
    }

    /**
     *
     * @return first name of Student
     */
    public String getFirstName() {
        return fname;
    }

    /**
     *
     * @return standing of Student
     */
    public String getStanding() {
        return standing;
    }

    /**
     *
     * @return GPA of Student
     */
    public float getGPA() {
        return gpa;
    }

    /**
     *
     * @return String representation of Student
     */
    public String toString() {
        return getClass().getName() + "@" + id + ":" + lname + ":" + fname + ":" + standing + ":" + gpa;
    }

    /**
     *
     * @param o Object to compare to Student
     * @return if o equals the Student instance or not
     */
    public boolean equals(Object o) {
        //Check if o is an instance of Student
        if (!(o instanceof Student)) {
            return false;
        }
        Student s = (Student) o;

        //Return true if all instance variables of o and Student are equal, otherwise false
        return lname.equals(s.getLastName()) && fname.equals(s.getFirstName()) && standing.equals(s.getStanding()) && gpa == s.getGPA();
    }

    /**
     *
     * Print distribution numbers for standings
     */
    public static void printStandingDistribution() {
        System.out.println("Seniors: " + roundDecimalDouble(seniors / studentCount));
        System.out.println("Juniors: " + roundDecimalDouble(juniors / studentCount));
        System.out.println("Sophomores: " + roundDecimalDouble(sophomores / studentCount));
        System.out.println("Freshmen: " + roundDecimalDouble(freshman / studentCount));
    }

    /**
     *
     * Print distribution numbers for GPAs
     */
    public static void printGPADistribution() {
        System.out.println("4.0: " + roundDecimalDouble(gpa4 / studentCount));
        System.out.println("3.00-3.99: " + roundDecimalDouble(gpa3 / studentCount));
        System.out.println("2.00-2.99: " + roundDecimalDouble(gpa2 / studentCount));
        System.out.println("1.00-1.99: " + roundDecimalDouble(gpa1 / studentCount));
        System.out.println("0.00-0.99: " + roundDecimalDouble(gpa0 / studentCount));
    }

    /**
     *
     * Randomly choose a unique ID number between 0 and 9999999
     *
     * @return ID number to assign id
     */
    private int assignId() {
        if (!generated) {
            for (int i = 0; i < 10000000; i++) {
                unusedIDs.add(i);
            }

            Collections.shuffle(unusedIDs);
            generated = true;
        }

        return unusedIDs.remove(unusedIDs.size() - 1);
    }

    /**
     *
     * Randomly choose a last name in the lastNames array
     *
     * @return last name to assign to lname
     */
    private String assignLastName() {
        //Declare an array of possible last names
        String[] lastNames = {"Smith", "Johnson", "Williams", "Brown", "Jones", "Miller", "Davis", "Garcia", "Rodriguez", "Wilson"};

        //Randomly choose a last name and return it
        Random rand = new Random();
        int index = rand.nextInt(lastNames.length);
        return lastNames[index];
    }

    /**
     *
     * Randomly choose a first name with 5-10 random characters
     *
     * @return first name to assign to fname
     */
    private String assignFirstName() {
        //Declare first name and Random object
        Random rand = new Random();
        String firstName = "";

        //Randomly decide a length between 5-10
        int length = rand.nextInt(4, 10);

        //Assign the first letter as a capital letter
        //ASCII values for capital letters
        firstName += (char) rand.nextInt(65, 91);

        //Assign the rest of the letters as lowercase letters
        for (int i = 0; i < length; i++) {
            //ASCII for lowercase letters
            firstName += (char) rand.nextInt(97, 123);
        }

        //Return first name
        return firstName;
    }

    /**
     *
     * Randomly choose a standing of senior, junior, sophomore, or freshman
     * while maintaining distribution of 10%, 20%, 30%, and 40% respectively
     *
     * @return standing to assign to standing
     */
    private String assignStanding() {
        //Pick random integer to randomly assign GPA
        Random rand = new Random();
        int i = rand.nextInt(100);
        
        //Assign 10% of students a senior standing
        if (i < 10) {
            seniors++;
            return "senior";
        }
        //Assign 20% of students a junior standing
        else if (i < 30) {
            juniors++;
            return "junior";
        } 
        //Assign 30% of students a sophomore standing
        else if (i < 60) {
            sophomores++;
            return "sophomore";
        }
        //Assign 40% of students a freshman standing
        else {
            freshman++;
            return "freshman";
        }
    }

    /**
     *
     * Randomly choose a GPA of 4.0, 3.00-3.99, 2.00-2.99, 1.00-1.99, or
     * 0.00-0.99 while maintaining distribution of 5%, 20%, 50%, 20%, and 5%
     * respectively
     *
     * @return GPA to assign to gpa
     */
    private float assignGPA() {
        //Pick random integer to randomly assign GPA
        Random rand = new Random();
        int i = rand.nextInt(100);
        
        //Assign 5% of students a gpa between 0-0.99
        if (i < 5) {
            gpa0++;
            return roundDecimalFloat(rand.nextFloat(0F, 0.995F));
        }
        //Assign 5% of students a gpa of 4.0
        else if (i < 10) {
            gpa4++;
            return 4.00F;
        } 
        //Assign 20% of students a gpa between 3-3.99
        else if (i < 30) {
            gpa3++;
            return roundDecimalFloat(rand.nextFloat(3.00F, 3.995F));
        }
        //Assign 20% of students a gpa between 1-1.99
        else if (i < 50) {
            gpa1++;
            return roundDecimalFloat(rand.nextFloat(1.00F, 1.995F));
        }
        //Assign 50% of students a gpa between 2-2.99
        else {
            gpa2++;
            return roundDecimalFloat(rand.nextFloat(2.00F, 2.995F));
        }
    }

    /**
     *
     * @param f floating point number
     * @return f rounded to two decimal places
     */
    private float roundDecimalFloat(float f) {
        return Math.round(f * 100.0F) / 100.0F;
    }

    /**
     *
     * @param d double number
     * @return d rounded to two decimal places
     */
    private static double roundDecimalDouble(double d) {
        return Math.round(d * 100.0) / 100.0;
    }
}
