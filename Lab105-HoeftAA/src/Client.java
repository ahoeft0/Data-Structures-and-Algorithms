
import java.util.Scanner;

/**
 * This is an assignment hints file.
 * It is not completely documented.
 * It is not a complete solution.
 * @author latimer
 */
public class Client {

    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        boolean quit = false;

        // loop until the user wants to quit
        while (!quit) {
            System.out.println("==========  Menu  ==========");
            System.out.println(" A)  Factorial ");
            System.out.println(" B)  Fibonacci Bad ");
            System.out.println(" C)  Fibonacci Good ");
            System.out.println(" Q)  Quit ");

            System.out.print("Enter choice: ");
            String choice = keyScan.nextLine();

            switch (choice) {
                case "A":
                case "a":
                    callFactorial();
                    break;
                case "B":
                case "b":
                    callFibonacciBad();
                    break;
                case "C":
                case "c":
                    callFibonacciGood();
                    break;
                case "Q":
                case "q":
                    quit = true;
                    break;

                default:
                    System.out.println("Invalid Choice, Try Again\n");
            }
        }
    }

    /**
     * This method is called by the menu when the user want to calculate
     * a factorial.
     * This methods checks for a valid parameter
     * - when the parameter is valid the factorial method is called with the parameter.
     * - when the parameter is invalid, appropriate action is taken.
     */
    public static void callFactorial() {
        System.out.println("callFacotrial() method has been called.");
        Scanner keyScan = new Scanner(System.in);

        String answer = "";

        boolean tryAgain = true;
        int n = 0;
        // loop unitl user does not want to try again.
        while (tryAgain) {

            boolean inValidInput = true;

            // loop until user enters a valid integer
            while (inValidInput) {

                System.out.print("Enter a positive Integer: ");
                answer = keyScan.nextLine();

                try {
                    n = Integer.parseInt(answer);

                    if (n < 0 || n > 12) {
                        throw new IllegalArgumentException("Number must be >= 0 and < 13.");
                    }

                    inValidInput = false;
                } catch (NumberFormatException nfe) {
                    System.out.println("You must enter an integer value.  Try again.");
                } catch (IllegalArgumentException iae) {
                    System.out.println(iae.getMessage() + " Try again.");
                }
            }

            System.out.printf("factorial( %d ) = %,d \n", n, factorial1(n));  // the call to the factorial1 method.

            System.out.print("Calculate another factorial? (Y/N): ");
            answer = keyScan.nextLine();
            if (answer.equalsIgnoreCase("N")) {
                tryAgain = false;
            }
        }
    }

    /**
     * The basic factorial algorithm.
     * This algorithm does not check for valid parameters and should only
     * be called by the callFactorial method.
     * 
     * @param i
     * @return 
     */
    public static int factorial1(int i) {
        if (i < 1) {
            return 1;
        } else {
            return i * factorial1(i - 1);
        }
    }    
    
    /**
     * This is an example of a stub.
     * You can completely write and test your menu without having completed
     * all of the methods called by the menu.
     * 
     */
    public static void callFibonacciBad() {
        System.out.println("callFibonacciBad() method has been called.");
    }

    /**
     * This is an example of a stub.
     * You can completely write and test your menu without having completed
     * all of the methods called by the menu.
     * 
     */    
    public static void callFibonacciGood() {
        System.out.println("callFibonacciBad() method has been called.");
    }


}
