/**
 * Position Interface
 * Code Fragment 7.7
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 *
 * This class defines the Position and its method signature
 * @param <E> Class to be used in methods
 */
public interface Position<E> {

    E getElement() throws IllegalStateException;
}
