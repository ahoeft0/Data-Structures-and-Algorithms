/**
 *
 * @author Ashton Hoeft
 * @version 4/21/2023
 * 
 * This program defines a comparator for names
 */
public class DescendingFirstNameComparator implements Comparator{
    /**
     * 
     * @param k1 name1 to compare
     * @param k2 name2 to compare
     * @return which name comes first as an integer code
     */
    public int compare(Object k1, Object k2) {
        //Declare variables
        Student s1 = (Student) k1;
        Student s2 = (Student) k2;
        
        //Compare names
        return s2.getFirstName().compareToIgnoreCase(s1.getFirstName());
    }
}