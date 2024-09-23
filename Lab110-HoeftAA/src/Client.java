//Import classes
import java.text.DecimalFormat;

/**
 *
 * @author Ashton Hoeft
 * @version 4/25/2023
 * 
 * This program tests the Sort and Student classes and stores the data from the tests in a table
 */
public class Client {
    public static void main(String[] args) {
        //Declare number formatter and number of items to sort for O(n^2) sorts
        DecimalFormat formatter = new DecimalFormat("#,###");
        int sortAmount = 100000;
        int arrayAmount = 1000000;
        
        //Declare array of Students and populate it will 1000000 Student instances
        Student[] students = new Student[arrayAmount];
        for(int i = 0; i < arrayAmount; i++) {
            students[i] = new Student();
        }
        
        //Declare data array and store column labels
        String[][] data = new String[8][3];
        data[0][0] = "Sort";
        data[0][1] = "N";
        data[0][2] = "Time (ms)";
        
        //Run merge sort and store data
        Student[] tempArray = copyArray(students, students.length);
        long start = System.currentTimeMillis();
        Sort.mergeSort(tempArray, new AscendingIdComparator());
        long end = System.currentTimeMillis();
        long time = end - start;
        data[1][0] = "Merge";
        data[1][1] = formatter.format(arrayAmount);
        data[1][2] = "" + formatter.format(time);
        
        //Run quick sort and store data
        tempArray = copyArray(students, students.length);
        start = System.currentTimeMillis();
        Sort.quickSort(tempArray, new AscendingGPAComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[2][0] = "Quick";
        data[2][1] = formatter.format(arrayAmount);
        data[2][2] = "" + formatter.format(time);
        
        //Run simple bubble sort and store data
        tempArray = copyArray(students, sortAmount);
        start = System.currentTimeMillis();
        Sort.simpleBubbleSort(tempArray, new AscendingIdComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[3][0] = "SimpleBubble";
        data[3][1] = formatter.format(sortAmount);
        data[3][2] = "" + formatter.format(time);
        
        //Run efficient bubble sort and store data
        tempArray = copyArray(students, sortAmount);
        start = System.currentTimeMillis();
        Sort.efficientBubbleSort(tempArray, new DescendingIdComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[4][0] = "EfficientBubble";
        data[4][1] = formatter.format(sortAmount);
        data[4][2] = "" + formatter.format(time);
        
        //Run insertion sort and store data
        tempArray = copyArray(students, sortAmount);
        start = System.currentTimeMillis();
        Sort.insertionSort(tempArray, new AscendingGPAComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[5][0] = "Insertion";
        data[5][1] = formatter.format(sortAmount);
        data[5][2] = "" + formatter.format(time);
        
        //Run selection sort and store data
        tempArray = copyArray(students, sortAmount);
        start = System.currentTimeMillis();
        Sort.selectionSort(tempArray, new DescendingStandingComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[6][0] = "Selection";
        data[6][1] = formatter.format(sortAmount);
        data[6][2] = "" + formatter.format(time);
        
        //Run radix sort and store data
        tempArray = copyArray(students, students.length);
        start = System.currentTimeMillis();
        Sort.radixSort(tempArray, new AscendingIdComparator(), new AscendingFirstNameComparator(), new DescendingLastNameComparator(), new AscendingGPAComparator(), new DescendingStandingComparator());
        end = System.currentTimeMillis();
        time = end - start;
        data[7][0] = "Radix";
        data[7][1] = formatter.format(arrayAmount);
        data[7][2] = "" + formatter.format(time);
        
        //Print table
        ASCIITable.printTableDynamic_v3(data, "CSCI 161 Lab110 Sorting", true, true, true);
    }
    
    /**
     * 
     * @param s array to copy
     * @param length how much of the array to copy
     * @return copy of s with length length
     */
    private static Student[] copyArray(Student[] s, int length) {
        //If length is larger than length of s, throw an exception
        if(length > s.length)
            throw new IllegalArgumentException("length cannot be greater than length of array");
        //Copy array s to temp and return copied array
        Student[] temp = new Student[length];
        for(int i = 0; i < temp.length; i++) {
            temp[i] = s[i];
        }
        
        return temp;
    }
}