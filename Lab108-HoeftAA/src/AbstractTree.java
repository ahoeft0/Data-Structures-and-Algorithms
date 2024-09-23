import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * AbstractTree Class Code Fragments 8.2, 8.3, 8.5, 8.16, 8.17, 8.18, 
 * 8.19, 8.20, 8.21, 8.23, 8.24, 8.25, 8.26
 * from
 * Data Structures & Algorithms, 6th edition by Michael T. Goodrich, Roberto Tamassia
 * & Michael H. Goldwasser Wiley 2014 Transcribed by
 *
 * @author Ashton Hoeft
 * @version 3/11/2023
 *
 * This class defines the AbstractTree and its methods
 * @param <E> Class to be used in methods
 */
public abstract class AbstractTree<E> implements Tree<E> {

    public boolean isInternal(Position<E> p) {
        return numChildren(p) > 0;
    }

    public boolean isExternal(Position<E> p) {
        return numChildren(p) == 0;
    }

    public boolean isRoot(Position<E> p) {
        return p == root();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int depth(Position<E> p) {
        if (isRoot(p)) {
            return 0;
        } else {
            return 1 + depth(parent(p));
        }
    }

    public int height(Position<E> p) {
        int h = 0; // base case if p is external
        for (Position<E> c : children(p)) {
            h = Math.max(h, 1 + height(c));
        }
        return h;
    }

    //---------------- nested ElementIterator class ----------------
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = positions().iterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }

    public Iterator<E> iterator() {
        return new ElementIterator();
    } 

    public Iterable<Position<E>> positions() {
        return preorder();
    }

    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        snapshot.add(p); // for preorder, we add position p before exploring subtrees
        for (Position<E> c : children(p)) {
            preorderSubtree(c, snapshot);
        }
    }

    public Iterable<Position<E>> preorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            preorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }

    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c); // add children to back of queue
                }
            }
        }
        return snapshot;
    }

    public static String spaces(int n) {
        String temp = "";
        for (int i = 0; i < n; i++) {
            temp += " ";
        }
        return temp;
    }

    public static <E> void printPreorderIndent(Tree<E> T, Position<E> p, int d) {
        System.out.println(spaces(2 * d) + p.getElement()); // indent based on d
        for (Position<E> c : T.children(p)) {
            printPreorderIndent(T, c, d + 1); // child depth is d+1
        }
    }

    public static <E>
            void printPreorderLabeled(Tree<E> T, Position<E> p, ArrayList<Integer> path) {
        int d = path.size(); // depth equals the length of the path
        System.out.print(spaces(2 * d)); // print indentation, then label
        for (int j = 0; j < d; j++) {
            System.out.print(path.get(j) + (j == d - 1 ? " " : "."));
        }
        System.out.println(p.getElement());
        path.add(1); // add path entry for first child
        for (Position<E> c : T.children(p)) {
            printPreorderLabeled(T, c, path);
            path.set(d, 1 + path.get(d)); // increment last entry of path
        }
        path.remove(d); // restore path to its incoming state
    }

    public static int diskSpace(Tree<Integer> T, Position<Integer> p) {
        int subtotal = p.getElement(); // we assume element represents space usage
        for (Position<Integer> c : T.children(p)) {
            subtotal += diskSpace(T, c);
        }
        return subtotal;
    }

    public static <E> void parenthesize(Tree<E> T, Position<E> p) {
        System.out.print(p.getElement());
        if (T.isInternal(p)) {
            boolean firstTime = true;
            for (Position<E> c : T.children(p)) {
                System.out.print((firstTime ? " (" : ", ")); // determine proper punctuation
                firstTime = false; // any future passes will get comma
                parenthesize(T, c); // recur on child
            }
            System.out.print(")");
        }
    }
}
