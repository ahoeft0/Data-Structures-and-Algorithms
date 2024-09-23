/**
 *
 * @author Ashton Hoeft
 * @version February 9, 2023
 *
 * This program tests the ArrayBag and LinkedBag classes to see how long it
 * takes to add and remove different amounts of data
 *
 */
public class Client {
    public static void main(String[] args) {
        //Declare test size and array to hold results from test
        int testSize = 1;
        long[][] testResults = new long[8][3];

        //Store the test sizes in the results array
        for (int i = 0; i < 8; i++) {
            testSize *= 10;
            testResults[i][0] = testSize;
        }

        //Run the tests and store the results for ArrayBag
        testSize = 1;
        for (int i = 0; i < 8; i++) {
            //Increment test size create test ArrayBag
            testSize *= 10;
            ArrayBag testBag = new ArrayBag(testSize);

            //Run the add and remove tests for ArrayBag and record the time to finish
            long start = System.currentTimeMillis();
            for (int j = 0; j < testSize; j++) {
                testBag.addTest(1);
            }
            for (int k = testSize; k > 0; k--) {
                testBag.removeTest();
            }
            long finish = System.currentTimeMillis();
            long elapsed = finish - start;
            testResults[i][1] = elapsed;
        }

        //Run the tests and store the results for LinkedBag
        testSize = 1;
        for (int i = 0; i < 8; i++) {
            //Increment test size and create test LinkedBag
            testSize *= 10;
            LinkedBag testBag2 = new LinkedBag();

            //Run the add and remove tests for LinkedBag and record the time to finish
            long start = System.currentTimeMillis();
            for (int j = 0; j < testSize; j++) {
                testBag2.addTest(1);
            }
            for (int k = testSize; k > 0; k--) {
                testBag2.removeTest();
            }
            long finish = System.currentTimeMillis();
            long elapsed = finish - start;
            testResults[i][2] = elapsed;
        }

        //Print out the reults of the tests in an ASCII Table
        printTable(testResults);
    }

    /**
     * Make an ASCII Table using data from the tests
     *
     * @param array the data to put into the ASCII Table
     */
    public static void printTable(long[][] array) {
        //Create and print out the ASCII Table
        for (long[] array1 : array) {
            System.out.printf("+---------------+---------------+---------------+\n");
            for (int j = 0; j < array1.length; j++) {
                System.out.printf("|  %,11d  ", array1[j]);
            }
            System.out.printf("|\n");
        }
        System.out.printf("+---------------+---------------+---------------+\n");
    }
}
