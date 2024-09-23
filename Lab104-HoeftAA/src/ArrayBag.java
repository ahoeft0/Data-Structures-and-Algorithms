import java.util.Random;

/**
 *
 * @author Ashton Hoeft
 * @version January 31, 2023
 * 
 * This Class defines ArrayBag and defines its methods
 * @param <E> Class to be used in the methods
 */
public class ArrayBag<E> implements Bag<E> {
    private E [] list;
    private int count;
    
    /**
     * Default constructor for ArrayBag
     */
    public ArrayBag() {
        list = (E[]) new Object[2];
    }
    
    /**
     * Constructor for ArrayBag
     * @param length length of the list
     */
    public ArrayBag(int length) {
        list = (E[]) new Object[length];  
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
     * Clears the list by setting all values to null
     */
    public void clear() {
        for(int i = 0; i < count; i++)
            list[i] = null;
        count = 0;
    }
    
    /**
     * 
     * @param e Object to check frequency of
     * @return frequency of e in list
     */
    public int getFrequencyOf(E e) {
        int frequency = 0;
        for(int i = 0; i < count; i++) {
            if(list[i].equals(e))
                frequency++;
        }
        return frequency;
    }
    
    /**
     * 
     * @param e Object to check if it is in the list
     * @return if e is in list or not
     */
    public boolean contains(E e) {
        for(int i = 0; i < count; i++) {
            if(list[i].equals(e))
                return true;
        }
        return false;
    }
    
    /**
     * 
     * @param e Object to add to end of list<br/>
     *  Add e to the end of the list and if it is full, double the list length
     */
    public void add(E e) {
        if(count == list.length) {
            E [] temp = (E[]) new Object[list.length * 2];
            for(int i = 0; i < count; i++) {
                temp[i] = list[i];
            }
            list = temp;
            temp = null;
        }
        list[count] = e;
        count++;
    }
    
    /**
     * 
     * @param e Object to remove from the list
     * @return the first occurrence of e
     */
    public E remove(E e) {
        if(count == 0) {
            return null;
        }
        for(int i = 0; i < count; i++) {
            if(list[i].equals(e)) {
                count--;
                for(int j = i; j < count + 1; j++) {
                    try {
                        list[j] = list[j + 1];
                    }
                    catch(ArrayIndexOutOfBoundsException ai) {
                        list[j] = null;
                    }
                }
                return e;
            }
        }
        return null;
    }
    
    /**
     * 
     * @return random Object removed from list
     */
    public E remove() {
        if(count == 0) {
            return null;
        }
        Random rand = new Random();
        int index = rand.nextInt(1, count + 1);
        E e = list[index - 1];
        for(int i = index - 1; i < count; i++) {
            try {
                    list[i] = list[i + 1];
                }
                catch(ArrayIndexOutOfBoundsException ai) {
                    list[i] = null;
                }
        }
        count--;
        return e;
    }
    
    /**
     * 
     * @param i index of Object to return
     * @return Object at index i of list
     */
    public E get(int i) {
        if(i >= list.length)
            return null;
        return list[i];
    }
    
    /**
     * 
     * @return String representation of ArrayBag object
     */
    @Override
    public String toString() {
        String listString = "";
        for(int i = 0; i < count; i++) {
            listString += "\n(" + list[i].toString() + ")";
        }
        return getClass().getName() + "@" + listString + ":" + count;
    }
    
    /**
     * 
     * @param o ArrayBag object to compare
     * @return if Object o is equal to ArrayBag or not
     */
    public boolean equals( Object o )
    {
        if ( !( o instanceof ArrayBag ) )
            return false;
        ArrayBag a = ( ArrayBag ) o;
        if(this.list.length != a.list.length)
            return false;
        else {
            for(int i = 0; i < list.length; i++) {
                if(!(this.list[i].equals(a.list[i])))
                    return false;
            }
        return this.count == a.count;
        }
    }
    
    /**
     * 
     * @param e object to add to the ArrayBag
     */
    public void addTest(E e) {
        list[count] = e;
        count++;
    }
    
    /**
     * 
     * @return last object in the ArrayBag
     */
    public E removeTest() {
        count--;
        E removed = list[count];
        list[count] = null;
        return removed;
    }
}