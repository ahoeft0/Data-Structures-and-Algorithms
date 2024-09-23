import java.util.ArrayList;
import java.util.List;

/**
 * AbstractBinaryTree Class
 * Code Fragments 8.7, 8.22, 8.29
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 *
 * This class defines the AbstractBinaryTree and its methods
 * @param <E> Class to be used in methods
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E>
        implements BinaryTree<E> {

    public Position<E> sibling(Position<E> p) {
        Position<E> parent = parent(p);
        if (parent == null) {
            return null; // p must be the root
        }
        if (p == left(parent)) // p is a left child
        {
            return right(parent); // (right child might be null)
        } else // p is a right child
        {
            return left(parent); // (left child might be null)
        }
    }

    public int numChildren(Position<E> p) {
        int count = 0;
        if (left(p) != null) {
            count++;
        }
        if (right(p) != null) {
            count++;
        }
        return count;
    }

    public Iterable<Position<E>> children(Position<E> p) {
        List<Position<E>> snapshot = new ArrayList<>(2); // max capacity of 2
        if (left(p) != null) {
            snapshot.add(left(p));
        }
        if (right(p) != null) {
            snapshot.add(right(p));
        }
        return snapshot;
    }

    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        if (left(p) != null) {
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if (right(p) != null) {
            inorderSubtree(right(p), snapshot);
        }
    }

    public Iterable<Position<E>> inorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            inorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    public Iterable<Position<E>> positions() {
        return inorder();
    }
    
    private void eulerTourBinaryCall(Position p) {
        if(left(p) != null) {
            System.out.print("(");
            eulerTourBinaryCall(left(p));
            //System.out.print(")");
        }
        System.out.print(p.getElement());
        if(right(p) != null) {
            //System.out.print("(");
            eulerTourBinaryCall(right(p));
            System.out.print(")");
        }
    }
    
    public void eulerTourBinary(Position p) {
        eulerTourBinaryCall(p);
        System.out.println();
    }
}