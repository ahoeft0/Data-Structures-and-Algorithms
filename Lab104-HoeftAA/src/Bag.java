/**
 *
 * @author Ashton Hoeft
 * @version January 31, 2023
 * 
 * This program declares the methods to implement for generic interface Bag
 * @param <E> Class to be used in methods
 */
public interface Bag<E> {
    /**
     * 
     * @return size of bag
     */
    public int size();
    
    /**
     * 
     * @return if bag is empty or not
     */
    public boolean isEmpty();
    
    /**
     * clear the bag of its contents
     */
    public void clear();
    
    /**
     * 
     * @param e Object to get frequency of
     * @return frequency of e
     */
    public int getFrequencyOf(E e);
    
    /**
     * 
     * @param e Object to check if it is in list
     * @return if e is in list or not
     */
    public boolean contains(E e);
    
    /**
     * 
     * @param e Object to add
     */
    public void add(E e);
    
    /**
     * 
     * @param e Object to remove
     * @return e if it is list and null if it is not
     */
    public E remove(E e);
    
    /**
     * 
     * @return random Object from list
     */
    public E remove();
    
    /**
     * 
     * @param i place of Object to return
     * @return Object at place i
     */
    public E get(int i);
    
    /**
     * 
     * @return String representation of Bag
     */
    public String toString();
    
    /**
     * 
     * @param o Object to compare to Bag
     * @return if o and Bag are equal or not
     */
    public boolean equals(Object o);
}