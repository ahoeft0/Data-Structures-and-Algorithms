/**
 *
 * @author Ashton Hoeft
 * @version January 20, 2023
 * 
 * This program defines the Scores class and its methods.
 * 
 */

import java.util.Random;

public class Scores {
    private int [] list;
    private int count;
    
    /**
     * Default constructor for Scores
     */
    public Scores() {
        list = new int [2];
    }
    
    /**
     * Constructor for Scores
     * @param length length of the list
     */
    public Scores(int length) {
        list = new int [length];  
    }
    
    /**
     * 
     * @return count
     */
    public int size() {
        return count;
    }
    
    /**
     * 
     * @return if list is empty or not
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**
     * Clears the list by setting all values to 0
     */
    public void clear() {
        for(int i = 0; i < count; i++)
            list[i] = 0;
    }
    
    /**
     * 
     * @param num number to check frequency of
     * @return frequency of num in list
     */
    public int getFrequencyOf(int num) {
        int frequency = 0;
        for(int i = 0; i < count; i++) {
            if(list[i] == num)
                frequency++;
        }
        return frequency;
    }
    
    /**
     * 
     * @param num number to check if it is in the list
     * @return if num is in list or not
     */
    public boolean contains(int num) {
        for(int i = 0; i < count; i++) {
            if(list[i] == num)
                return true;
        }
        return false;
    }
    
    /**
     * 
     * @param num number to add to end of list<br/>
     *  Add num to the end of the list and if it is full, double the list length
     */
    public void add(int num) {
        if(count == list.length) {
            int [] temp = new int[list.length * 2];
            for(int i = 0; i < list.length; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null;
        }
        list[count] = num;
        count++;
    }
    
    /**
     * 
     * @param num number to remove at the first occurrence of number in the list
     * @return the first occurrence of num
     */
    public int remove(int num) {
        if(count == 0) {
            throw new IllegalStateException
                    ("The remove() method cannot be called on an empty list");
        }
        for(int i = 0; i < count; i++) {
            if(list[i] == num) {
                count--;
                for(int j = i; j < count + 1; j++) {
                    try {
                        list[j] = list[j + 1];
                    }
                    catch(ArrayIndexOutOfBoundsException ai) {
                        list[j] = 0;
                    }
                }
                return num;
            }
        }
        throw new IllegalStateException
                ("The score (num) is not in the list of scores.");
    }
    
    /**
     * 
     * @return random variable removed from list
     */
    public int remove() {
        if(count == 0) {
            throw new IllegalStateException
                    ("The remove() method cannot be called on an empty list");
        }
        Random rand = new Random();
        int index = rand.nextInt(1, count + 1);
        int num = list[index - 1];
        for(int i = index - 1; i < count; i++) {
            try {
                    list[i] = list[i + 1];
                }
                catch(ArrayIndexOutOfBoundsException ai) {
                    list[i] = 0;
                }
        }
        count--;
        return num;
    }
    
    /**
     * 
     * @param i index of number to return
     * @return score at index i of list
     */
    public int get(int i) {
        if(i >= list.length)
            throw new ArrayIndexOutOfBoundsException
                    ("The index (i) is out of bounds of the array.");
        return list[i];
    }
    
    /**
     * 
     * @return String representation of Scores object
     */
    public String toString() {
        String listString = "";
        for(int i = 0; i < count; i++) {
            listString += "(" + list[i] + ")";
        }
        return getClass().getName() + "@" + listString + ":" + count;
    }
    
    /**
     * 
     * @param o Scores object to compare
     * @return if Object o is equal to Scores or not
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof Scores ) )
            return false;
        Scores s = ( Scores ) o;
        if(list.length != s.list.length)
            return false;
        else {
            for(int i = 0; i < list.length; i++) {
                if(list[i] != s.list[i])
                    return false;
            }
        return count == s.count;
        }
    }
}