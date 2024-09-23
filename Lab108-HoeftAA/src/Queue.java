/**
 * Queue Interface
 * Code Fragment 6.9
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 *
 * This class defines the Queue and its method signatures
 * @param <E> Class to be used in methods
 */
public interface Queue<E> {

    int size();

    boolean isEmpty();

    void enqueue(E e);

    E first();

    E dequeue();
}
