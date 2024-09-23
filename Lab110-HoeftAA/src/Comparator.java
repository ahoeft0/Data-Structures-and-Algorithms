/**
 *
 * @author Ashton Hoeft
 * @version 4/21/2023
 * 
 * This program declares the interface for a generic Comparator
 */
public interface Comparator<K> {
    int compare(K k1, K k2);
}
