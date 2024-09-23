//Import classes
import java.util.Arrays;

/**
 * Sort Class
 * 
 * Code Fragments
 * from
 * Java Illuminated Text pages 524,525
 * 
 * Code Fragments 12.1, 12.2, 12.5
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Ashton Hoeft
 * @version 4/21/2023
 *
 * This class defines Sort and its sorting methods
 */
public class Sort {
    /**
     * 
     * @param <K> object in array
     * @param array array to sort
     * @param comp variable to compare
     */
    public static <K> void simpleBubbleSort(K[] array, Comparator<K> comp) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length - 1; j++) {
                if(comp.compare(array[j], array[j + 1]) > 0) {
                    K temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 
     * @param <K> object in array
     * @param array array to sort
     * @param comp variable to compare
     */
    public static <K> void efficientBubbleSort(K[] array, Comparator<K> comp) {
        for(int i = 0; i < array.length; i++) {
            boolean isSorted = true;
            for(int j = 0; j < array.length - 1 - i; j++) {
                if(comp.compare(array[j], array[j + 1]) > 0) {
                    K temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                return;
            }
        }
    }

    /**
     * 
     * @param <K> object in array
     * @param array array to sort
     * @param comp variable to compare
     */
    public static <K> void insertionSort(K[] array, Comparator<K> comp) {
        int j;
        K temp;
        
        for(int i = 1; i < array.length; i++) {
            j = i;
            temp = array[i];
            
            while(j != 0 && comp.compare(array[j-1], temp) == 1) {
                array[j] = array[j - 1];
                j--;
            }
            
            array[j] = temp;
        }
    }

    /**
     * 
     * @param <K> object in array
     * @param array array to find largest index of
     * @param size size of array
     * @param comp variable to compare
     * @return index of largest element
     */
    private static <K> int indexOfLargestElement(K[] array, int size, Comparator<K> comp) {
        int index = 0;
        for(int i = 1; i < size; i++) {
            if(comp.compare(array[i], array[index]) == 1)
                index = i;
        }
        return index;
    }
    
    /**
     * 
     * @param <K> object in array
     * @param array array to sort
     * @param comp variable to compare
     */
    public static <K> void selectionSort(K[] array, Comparator<K> comp) {
        K temp;
        int max;
        
        for(int i = 0; i < array.length; i++) {
            max = indexOfLargestElement(array, array.length - i, comp);
            
            temp = array[max];
            array[max] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    /**
     * Merge contents of arrays S1 and S2 into properly sized array S.
     */
    public static <K> void merge(K[] S1, K[] S2, K[] S, Comparator<K> comp) {
        int i = 0, j = 0;
        while (i + j < S.length) {
            if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
                S[i + j] = S1[i++]; // copy ith element of S1 and increment i
            } else {
                S[i + j] = S2[j++]; // copy jth element of S2 and increment j
            }
        }
    }

    /**
     * Merge-sort contents of array S.
     */
    public static <K> void mergeSort(K[] S, Comparator<K> comp) {
        int n = S.length;
        if (n < 2) {
            return; // array is trivially sorted
        }// divide
        int mid = n / 2;
        K[] S1 = Arrays.copyOfRange(S, 0, mid); // copy of first half
        K[] S2 = Arrays.copyOfRange(S, mid, n); // copy of second half
        // conquer (with recursion)
        mergeSort(S1, comp); // sort copy of first half
        mergeSort(S2, comp); // sort copy of second half
        // merge results
        merge(S1, S2, S, comp); // merge sorted halves back into original
    }

    /**
     * 
     * Quick-sort contents of a queue
     * 
     * @param <K> object in array
     * @param k array of sort
     * @param comp variable to compare
     */
    public static <K> void quickSort(K[] k, Comparator<K> comp) {
        Queue <K> queue = arrayToQueue(k);
        quickSortAlgorithm(queue, comp);
        queueToArray(queue, k);
    }
    
    /**
     * Quick-sort contents of a queue.
     */
    private static <K> void quickSortAlgorithm(Queue<K> S, Comparator<K> comp) {
        int n = S.size();
        if (n < 2) {
            return; // queue is trivially sorted
        } // divide
        K pivot = S.first(); // using first as arbitrary pivot
        Queue<K> L = new LinkedQueue<>();
        Queue<K> E = new LinkedQueue<>();
        Queue<K> G = new LinkedQueue<>();
        while (!S.isEmpty()) { // divide original into L, E, and G
            K element = S.dequeue();
            int c = comp.compare(element, pivot);
            if (c < 0) // element is less than pivot
            {
                L.enqueue(element);
            } else if (c == 0) // element is equal to pivot
            {
                E.enqueue(element);
            } else // element is greater than pivot
            {
                G.enqueue(element);
            }
        }
        // conquer
        quickSortAlgorithm(L, comp); // sort elements less than pivot
        quickSortAlgorithm(G, comp); // sort elements greater than pivot
        // concatenate results
        while (!L.isEmpty()) {
            S.enqueue(L.dequeue());
        }
        while (!E.isEmpty()) {
            S.enqueue(E.dequeue());
        }
        while (!G.isEmpty()) {
            S.enqueue(G.dequeue());
        }
    }
    
    /**
     * 
     * @param s array to convert to a queue
     * @return queue representation of s
     */
    private static <K> LinkedQueue<K> arrayToQueue(K[] s) {
        LinkedQueue<K> temp = new LinkedQueue();
        for(int i = 0; i < s.length; i++) {
            temp.enqueue(s[i]);
        }
        return temp;
    }
    
    /**
     * 
     * @param q queue to convert to an array
     * @return array representation of queue
     */
    private static <K> void queueToArray(Queue<K> q, K[] k) {
        for(int i = 0; i < k.length; i++) {
            k[i] = q.dequeue();
        }
    }

    /**
     * 
     * @param <K> object in array
     * @param array array to sort
     * @param comparators list of variables to sort
     */
    public static <K> void radixSort(K[] array, Comparator<K> ... comparators) {
        if(comparators.length > 5 || comparators.length < 2)
            throw new IllegalArgumentException("You can only use 2 to 5 comparators.");
        
        for(int i = comparators.length - 1; i >= 0; i--) {
            mergeSort(array, comparators[i]);
        }
    }
}