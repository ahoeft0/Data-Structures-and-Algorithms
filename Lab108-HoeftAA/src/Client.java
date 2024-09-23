//Import classes
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Ashton Hoeft
 * @version 3/22/2023
 * 
 * This program tests the methods created in the client and runs different methods on an arithmetic expression
 */
public class Client {
    public static void main(String[] args) throws FileNotFoundException {
        //Get file input from user
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter file path with expression list: ");
        File file = new File(scan.nextLine());
        scan = new Scanner(file);
        System.out.println("");
        
        //Run methods on all expressions in file
        while(scan.hasNext()) {
            try {
                //Store expression
                String input = scan.nextLine();
                
                //Print in-fix notation
                System.out.println("In-fix Expression: " + input);
                
                //Store and print post-fix notation
                String expression = ArithmeticOperations.infixToPostfix(input);
                System.out.println("Post-fix Expression: " + expression);
                
                //Print evaluation of expression
                System.out.println("Evaluation of Expression: " + ArithmeticOperations.postfixEvaluation(expression));
                 
                //Make Binary Expression Tree
                LinkedBinaryTree <String> tree = ArithmeticOperations.postfixToBinaryTree(expression);
                
                //Print the preorder traversal of the tree
                System.out.print("Preorder traversal: ");
                for(Position p : tree.preorder()) {
                    System.out.print(p.getElement() + " ");
                }
                System.out.println("");
        
                //Print the inorder traversal of the tree
                System.out.print("Inorder traversal: ");
                for(Position p : tree.inorder()) {
                    System.out.print(p.getElement() + " ");
                }
                System.out.println("");
        
                //Print the postorder traversal of the tree
                System.out.print("Postorder traversal: ");
                for(Position p : tree.postorder()) {
                    System.out.print(p.getElement() + " ");
                }
                System.out.println("");
        
                //Print the eulerTourBinary traversal of the tree
                System.out.print("EulerTourBinary traversal: ");
                tree.eulerTourBinary(tree.root());
                
                //Print new line between expression operations
                System.out.println("");
            }
            catch(IllegalArgumentException iae){
                System.out.println(iae.getMessage() + "\n");
            }
        }
    }
}