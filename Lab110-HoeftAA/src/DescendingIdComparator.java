/**
 *
 * @author Ashton Hoeft
 * @version 4/21/2023
 * 
 * This program defines a comparator for IDs
 */
public class DescendingIdComparator implements Comparator{
    /**
     * 
     * @param k1 ID1 to compare
     * @param k2 ID2 to compare
     * @return which ID is bigger as an integer code
     */
    public int compare(Object k1, Object k2) {
        //Declare variables
        Student s1 = (Student) k1;
        Student s2 = (Student) k2;
        
        //Compare IDs
        if(s1.getID() < s2.getID())
            return 1;
        if(s1.getID() > s2.getID())
            return -1;
        else
            return 0;
    }
}