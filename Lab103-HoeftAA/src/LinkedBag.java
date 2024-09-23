import java.util.Random;

/**
 *
 * @author Ashton Hoeft
 * @version January 31, 2023
 * 
 * This class defines the LinkedBag and its methods
 * @param <E> Class to be used in methods
 */
public class LinkedBag<E> implements Bag<E> {
    private SinglyLinkedList<E> list;
    
    /**
     * Default Constructor for LinkedBag
     */
    public LinkedBag() {
        list = new SinglyLinkedList();
    }
    
    /**
     * Constructor for LinkedBag
     * @param i length of list
     */
    public LinkedBag(int i) {
        list = new SinglyLinkedList();
    }
    
    /**
     * 
     * @return size of bag
     */
    public int size() {
        return list.size();
    }
    
    /**
     * 
     * @return if bag is empty or not
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    /**
     * clear the contents of the bag
     */
    public void clear() {
        for(int i = 0; i < list.size(); i++) {
            list.removeFirst();
        }
    }
   
    /**
     * 
     * @param e Object to be used in method
     * @return frequency of e in bag
     */
    public int getFrequencyOf(E e) {
        int frequency = 0;
        for(int i = 0; i < list.size(); i++) {
            list.addLast(list.removeFirst());
            if(list.last().equals(e))
                frequency++;
        }
        return frequency;
    }
    
    /**
     * 
     * @param e
     * @return if list contains e or not
     */
    public boolean contains(E e) {
        int frequency = 0;
        for(int i = 0; i < list.size(); i++) {
            list.addLast(list.removeFirst());
            if(list.last().equals(e))
                frequency++;
        }
        return frequency != 0;
    }
    
    /**
     * 
     * @param e Object to be added to the end of bag 
     */
    public void add(E e) {
        list.addLast(e);
    }
    
    /**
     * 
     * @param e Object to be removed from bag
     * @return the removed Object
     */
    public E remove(E e) {
        int frequency = 0;
        E removed = null;
        int size = list.size();
        for(int i = 0; i < size; i++) {
            if(list.first().equals(e) && frequency == 0) {
                removed = list.first();
                frequency++;
                list.removeFirst();
            }
            else
                list.addLast(list.removeFirst());
        }
       
        return removed;
    }
    
    /**
     * 
     * @return a randomly removed object from the bag
     */
    public E remove() {
        Random rand = new Random();
        int index = rand.nextInt(0, list.size());
        E removed = null;
        int size = list.size();
        for(int i = 0; i < size; i++) {
            if(index == i) {
                removed = list.first();
                list.removeFirst();
            }
            else
                list.addLast(list.removeFirst());
        }

        return removed;
    }
    
    /**
     * 
     * @param i index of object to get
     * @return Object at index i
     */
    public E get(int i) {
        E get = null;
        for(int j = 0; j < list.size(); j++) {
            list.addLast(list.removeFirst());
            if(j == i - 1) {
                get = list.last();
            }
        }
        
        return get;
    }
    
    /**
     * 
     * @return String representation of LinkedBag object
     */
    public String toString() {
        String string = getClass().getName() + "@";
        for(int i = 0; i < list.size(); i++) {
            string += "\n(" + list.first().toString() + ")";
            list.addLast(list.removeFirst());
        }
        return string;
    }
    
    /**
     * 
     * @param o LinkedBag object to compare
     * @return if Object o is equal to LinkedBag or not
     */
    public boolean equals(Object o) {
        if ( !( o instanceof LinkedBag ) )
            return false;
        LinkedBag l = ( LinkedBag ) o;
        
        int booleanCount = 0;
        for(int i = 0; i < list.size(); i++) {
            list.addLast(list.removeFirst());
            if(!(list.last().equals(l)))
                booleanCount++;
        }
        return booleanCount == 0;
    } 
}