//Import classes
import java.util.ArrayList;

/**
 * BinarySearchTree class
 * Code Fragment
 * from
 * javatpoint.com
 * Transcribed by
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 *
 * This class defines the BinarySearchTree class and its methods
 */
public class BinarySearchTree {  
    //Represent a node of binary tree  
    private static class Node implements Position {

        private int data; // an element stored at this node
        private Node parent; // a reference to the parent node (if any)
        private Node left; // a reference to the left child (if any)
        private Node right; // a reference to the right child (if any)

        public Node(int e, Node above, Node leftChild, Node rightChild) {
            data = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }
        // accessor methods

        public int getData() {
            return data;
        }

        public Node getParent() {
            return parent;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }
        // update methods

        public void setData(int e) {
            data = e;
        }

        public void setParent(Node parentNode) {
            parent = parentNode;
        }

        public void setLeft(Node leftChild) {
            left = leftChild;
        }

        public void setRight(Node rightChild) {
            right = rightChild;
        }
    }
  
      //Represent the root of binary tree  
      private Node root;
      
      public Position root() {
          return root;
      }
      
      public static Position parent(Position p) {
            Node n = (Node) p;
            if(n == null) {
                return null;
            }
            return n.parent;
        }
      
       public static Position left(Position p) {
            Node n = (Node) p;
            if(n == null) {
                return null;
            }
            return n.left;
        }
       
        public static Position right(Position p) {
            Node n = (Node) p;
            if(n == null) {
                return null;
            }
            return n.right;
        }
  
      public BinarySearchTree(){  
          root = null;  
      }  
  
      //insert() will add new node to the binary search tree  
      public void insert(int data) {  
          //Create a new node  
          Node newNode = new Node(data, null, null, null);  
  
          //Check whether tree is empty  
          if(root == null){  
              root = newNode;  
              return;  
            }  
          else {  
              //current node point to root of the tree  
              Node current = root, parent = null;  
  
              while(true) {  
                  //parent keep track of the parent node of current node.  
                  parent = current;  
  
                  //If data is less than current's data, node will be inserted to the left of tree  
                  if(data < current.data) {  
                      current = current.left;  
                      if(current == null) {  
                          parent.setLeft(newNode);  
                          return;  
                      }  
                  }  
                  //If data is greater than current's data, node will be inserted to the right of tree  
                  else {  
                      current = current.right;  
                      if(current == null) {  
                          parent.setRight(newNode);  
                          return;  
                      }  
                  }  
              }  
          }  
      }  
  
      //minNode() will find out the minimum node  
      public Position minNode(Position root) {  
          Node rootNode = (Node) root;
          if (rootNode.left != null)  
              return minNode(rootNode.left);  
          else  
              return rootNode;  
      }  
  
      //deleteNode() will delete the given node from the binary search tree  
      public Position deleteNode(Position position, int value) {  
          Node node = (Node) position;
          if(node == null){  
              return null;  
           }  
          else {  
              //value is less than node's data then, search the value in left subtree  
              if(value < node.data)  
                  node.left = (Node) deleteNode(node.left, value);  
  
              //value is greater than node's data then, search the value in right subtree  
              else if(value > node.data)  
                  node.right = (Node) deleteNode(node.right, value);  
  
              //If value is equal to node's data that is, we have found the node to be deleted  
              else {  
                  //If node to be deleted has no child then, set the node to null  
                  if(node.left == null && node.right == null)  
                      node = null;  
  
                  //If node to be deleted has only one right child  
                  else if(node.left == null) {  
                      node = node.right;  
                  }  
  
                  //If node to be deleted has only one left child  
                  else if(node.right == null) {  
                      node = node.left;  
                  }  
  
                  //If node to be deleted has two children node  
                  else {  
                      //then find the minimum node from right subtree  
                      Node temp = (Node) minNode(node.right);  
                      //Exchange the data between node and temp  
                      node.data = temp.data;  
                      //Delete the node duplicate node from right subtree  
                      node.right = (Node) deleteNode(node.right, temp.data);  
                  }  
              }  
              return node;  
          }  
      }  
  
      //inorder() will perform inorder traversal on binary search tree  
      public void inorderTraversal(Position position) {  
          Node node = (Node) position;
          
          //Check whether tree is empty  
          if(root == null){  
              System.out.println("Tree is empty");  
              return;  
           }  
          else {  
  
              if(node.left!= null)  
                  inorderTraversal(node.left);  
              System.out.print(node.data + " ");  
              if(node.right!= null)  
                  inorderTraversal(node.right);  
  
          }  
      }
      
      public void preorderTraversal(Position p) {
          Node n = (Node) p;
          
          //Check whether tree is empty  
          if(root == null){  
              System.out.println("Tree is empty");  
              return;  
           }
          else {  
              System.out.print(n.getData() +" ");
              if(n.left!= null)  
                  preorderTraversal(n.left);   
              if(n.right!= null)  
                  preorderTraversal(n.right);  
  
          } 
          
      }
      
      public void postorderTraversal(Position p) {
          Node n = (Node) p;
          
          //Check whether tree is empty  
          if(root == null){  
              System.out.println("Tree is empty");  
              return;  
           }
          else {  
              if(n.left!= null)  
                  postorderTraversal(n.left);   
              if(n.right!= null)  
                  postorderTraversal(n.right);  
              System.out.print(n.getData() +" ");
          } 
          
      }
      
      public boolean isRoot(Position p) {
        return p == root();
    }
      
      public int depth(Position p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }
      
      public int height(Position p) {
        int h = 0; // base case if p is external
        for (Position c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }
      
      public Iterable<Position> children(Position p) {
        ArrayList<Position> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }
      
      //deleteNode() will delete the given node from the binary search tree  
      public Position contains(Position position, int value) {  
          Node node = (Node) position;
          if(node == null){  
              return null;  
           }  
              //value is less than node's data then, search the value in left subtree  
              if(value < node.data)  
                  node.left = (Node) deleteNode(node.left, value);  
  
              //value is greater than node's data then, search the value in right subtree  
              else if(value > node.data)  
                  node.right = (Node) deleteNode(node.right, value);  
  
              return position;
      }
}