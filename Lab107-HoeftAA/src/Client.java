/**
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 * 
 * This class creates a LinkedBinaryTree that represents the literal string impression
 * and tests the methods of LinkedBinaryTree.
 */
public class Client {
    public static void main(String[] args) {
        //Print the literal string expression of the expression
        System.out.println("Literal string representation: ( 9 * 8 ) + ( 17 / ( 14 + 23 ) * -2 )");
       
        //Declare and construct the tree
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>();
        tree.addRoot("+");
        tree.addLeft(tree.root(), "*");
        tree.addRight(tree.root(), "*");
        tree.addLeft(tree.left(tree.root()), "9");
        tree.addRight(tree.left(tree.root()), "8");
        tree.addLeft(tree.right(tree.root()), "/");
        tree.addRight(tree.right(tree.root()), "-2");
        tree.addLeft(tree.left(tree.right(tree.root())), "17");
        tree.addRight(tree.left(tree.right(tree.root())), "+");
        tree.addLeft(tree.right(tree.left(tree.right(tree.root()))), "14");
        tree.addRight(tree.right(tree.left(tree.right(tree.root()))), "23");
        
        //Print the height of the tree
        System.out.println("Height: " + tree.height(tree.root()));
        
        //Print the preorder traversal of the tree
        System.out.print("Preorder traversal: ");
        for(Position p : tree.preorder()) {
            System.out.print(p.getElement());
        }
        System.out.println("");
        
        //Print the inorder traversal of the tree
        System.out.print("Inorder traversal: ");
        for(Position p : tree.inorder()) {
            System.out.print(p.getElement());
        }
        System.out.println("");
        
        //Print the postorder traversal of the tree
        System.out.print("Postorder traversal: ");
        for(Position p : tree.postorder()) {
            System.out.print(p.getElement());
        }
        System.out.println("");
        
        //Print the breadthfirst traversal of the tree
        System.out.print("Breadthfirst traversal: ");
        for(Position p : tree.breadthfirst()) {
            System.out.print(p.getElement());
        }
        System.out.println("");
        
        //Print the eulerTourBinary traversal of the tree
        System.out.print("EulerTourBinary traversal: ");
        tree.eulerTourBinary(tree.root());
    }
}