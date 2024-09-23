//Import classes
import java.util.Random;


/**
 *
 * @author Ashton Hoeft
 * @version 4/17/2023
 * 
 * This program tests the BinarySearchTree class and prints out the data that is gathered from the tests
 */
public class Client {
    public static void main(String[] args) {  
        BinarySearchTree bt = new BinarySearchTree();  
          //Add nodes to the binary tree  
          bt.insert(50);  
          bt.insert(30);  
          bt.insert(70);  
          bt.insert(60);  
          bt.insert(10);  
          bt.insert(90);  
  
          //Displays the binary tree 
          System.out.println("Binary search tree after insertion:");  
          System.out.print("Inorder traversal of tree: ");
          bt.inorderTraversal(bt.root());  
          System.out.print("\nPreorder traversal of tree: ");
          bt.preorderTraversal(bt.root());
          System.out.print("\nPostorder traversal of tree: ");
          bt.postorderTraversal(bt.root());  
    
          //Deletes node 90 which has no child  
          bt.deleteNode(bt.root(), 90);  
          System.out.println("\n\nBinary search tree after deleting node 90:");  
          System.out.print("Inorder traversal of tree: ");
          bt.inorderTraversal(bt.root());  
          System.out.print("\nPreorder traversal of tree: ");
          bt.preorderTraversal(bt.root());
          System.out.print("\nPostorder traversal of tree: ");
          bt.postorderTraversal(bt.root());  
  
          //Deletes node 30 which has one child  
          bt.deleteNode(bt.root(), 30);  
          System.out.println("\n\nBinary search tree after deleting node 30:");  
          System.out.print("Inorder traversal of tree: ");
          bt.inorderTraversal(bt.root());  
          System.out.print("\nPreorder traversal of tree: ");
          bt.preorderTraversal(bt.root());
          System.out.print("\nPostorder traversal of tree: ");
          bt.postorderTraversal(bt.root());   
  
          //Deletes node 50 which has two children  
          bt.deleteNode(bt.root(), 50);  
          System.out.println("\n\nBinary search tree after deleting node 50:");  
          System.out.print("Inorder traversal of tree: ");
          bt.inorderTraversal(bt.root());  
          System.out.print("\nPreorder traversal of tree: ");
          bt.preorderTraversal(bt.root());
          System.out.print("\nPostorder traversal of tree: ");
          bt.postorderTraversal(bt.root());   
        
          //Create array for data and store headers in it
          String [][] data = new String[8][4];
          data[0][0] = "Tree Name";
          data[0][1] = "Tree Height";
          data[0][2] = "Insertion Time (ms)";
          data[0][3] = "Number of Insertions";
          
        //Create ascending tree, find its height, and store data
        BinarySearchTree ascending = new BinarySearchTree();
        long start = System.currentTimeMillis();
        for(int i = 0; i < 7813; i++) {
            ascending.insert(i);
        }
        long end = System.currentTimeMillis();
        long time = end - start;
        data[1][2] = "" + time;
        data[1][0] = "Ascending Tree";
        data[1][1] = "" + ascending.height(ascending.root());
        data[1][3] = "7813";
        
        //Create descending tree, find its height, and store data
        BinarySearchTree descending = new BinarySearchTree();
        start = System.currentTimeMillis();
        for(int i = 7813; i > 0; i--) {
            descending.insert(i);
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[2][2] = "" + time;
        data[2][0] = "Descending Tree";
        data[2][1] = "" + descending.height(descending.root());
        data[2][3] = "7813";
        
        //Create random tree, find its height, and store data
        int count = 0;
        BinarySearchTree random = new BinarySearchTree();
        Random rand = new Random();
        int root = rand.nextInt();
        start = System.currentTimeMillis();
        random.insert(root);
        count++;
        while(count < 1000000) {
            int i = rand.nextInt();
            if(random.contains(random.root(), i).getData() != i) {
                random.insert(i);
                count++;
            }   
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[3][2] = "" + time;
        data[3][0] = "Random Tree 1";
        data[3][1] = "" + random.height(random.root());
        data[3][3] = "" + count;
        
        //Create random tree, find its height, and store data
        count = 0;
        random = new BinarySearchTree();
        root = rand.nextInt();
        start = System.currentTimeMillis();
        random.insert(root);
        count++;
        while(count < 1000000) {
            int i = rand.nextInt();
            if(random.contains(random.root(), i).getData() != i) {
                random.insert(i);
                count++;
            }   
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[4][2] = "" + time;
        data[4][0] = "Random Tree 2";
        data[4][1] = "" + random.height(random.root());
        data[4][3] = "" + count;
        
        //Create random tree, find its height, and store data
        count = 0;
        random = new BinarySearchTree();
        root = rand.nextInt();
        start = System.currentTimeMillis();
        random.insert(root);
        count++;
        while(count < 1000000) {
            int i = rand.nextInt();
            if(random.contains(random.root(), i).getData() != i) {
                random.insert(i);
                count++;
            }   
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[5][2] = "" + time;
        data[5][0] = "Random Tree 3";
        data[5][1] = "" + random.height(random.root());
        data[5][3] = "" + count;
        
        //Create random tree, find its height, and store data
        count = 0;
        random = new BinarySearchTree();
        root = rand.nextInt();
        start = System.currentTimeMillis();
        random.insert(root);
        count++;
        while(count < 1000000) {
            int i = rand.nextInt();
            if(random.contains(random.root(), i).getData() != i) {
                random.insert(i);
                count++;
            }   
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[6][2] = "" + time;
        data[6][0] = "Random Tree 4";
        data[6][1] = "" + random.height(random.root());
        data[6][3] = "" + count;
        
        //Create random tree, find its height, and store data
        count = 0;
        random = new BinarySearchTree();
        root = rand.nextInt();
        start = System.currentTimeMillis();
        random.insert(root);
        count++;
        while(count < 1000000) {
            int i = rand.nextInt();
            if(random.contains(random.root(), i).getData() != i) {
                random.insert(i);
                count++;
            }   
        }
        end = System.currentTimeMillis();
        time = end - start;
        data[7][2] = "" + time;
        data[7][0] = "Random Tree 5";
        data[7][1] = "" + random.height(random.root());
        data[7][3] = "" + count;
        
        //Print new lines
        System.out.println("\n");
        
        //Print out the data in a table
        printTableDynamic(data);
      }  
    
    /**
    * Make an ASCII Table using data from the tests
    *
    * @param array the data to put into the ASCII Table
    */
    public static void printTableDynamic(String [][] array) {
        //Determine column widths
        int maxLength[] = new int[array[0].length];
        for(int i = 0; i < maxLength.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if(array[j][i].length() > maxLength[i])
                    maxLength[i] = array[j][i].length();
            }
        }
        
        //Create divider line
        String divider = "+";
        for(int i = 0; i < maxLength.length; i++) {
            for(int j = 0; j < maxLength[i] + 4; j++) {
                divider += "-";
            }
            divider += "+";
        }
        divider += "\n";

        //Print out table
        for (String[] subArray : array) {
            //Print divider line
            System.out.printf(divider);
            
            for(int i = 0; i < maxLength.length; i++ ) {
                //Print column one
                String format = "|  %" + maxLength[i] + "s  ";
                System.out.printf(format, subArray[i]);
            }
            
            //Print new line
            System.out.printf("|\n");
        }
        
        //Print divider
        System.out.print(divider);
    }
}