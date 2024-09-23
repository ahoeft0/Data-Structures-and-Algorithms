/**
 *
 * @author Ashton Hoeft
 * @version 4/21/2023
 * 
 * This program defines a comparator for standings
 */
public class DescendingStandingComparator implements Comparator{
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
        int key1 = 0;
        int key2 = 0;
        
        //Convert standings into comparable keys as integers
        if(null != s1.getStanding())
            switch (s1.getStanding()) {
            case "senior":
                key1 = 4;
                break;
            case "junior":
                key1 = 3;
                break;
            case "sophomore":
                key1 = 2;
                break;
            case "freshman":
                key1 = 1;
                break;
            default:
                break;
        }
        if(null != s2.getStanding())
            switch (s2.getStanding()) {
            case "senior":
                key2 = 4;
                break;
            case "junior":
                key2 = 3;
                break;
            case "sophomore":
                key2 = 2;
                break;
            case "freshman":
                key2 = 1;
                break;
            default:
                break;
        }
        
        //Compare standings
        if(key1 < key2)
            return 1;
        else if(key1 > key2)
            return -1;
        else
            return 0;
    }
}
