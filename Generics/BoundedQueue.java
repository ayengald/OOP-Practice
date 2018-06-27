
import java.util.List;
import java.util.ArrayList;
public class BoundedQueue<T> {
    //OVERVIEW: A class that stores a queue of generic type objects
    //RI: size > 0, rep must be less than size

    //Variables
    protected List<T> rep;
    protected int size = 0;  //max size of rep

    //Constructors
    public BoundedQueue(int size) {
        if (size > 0) {
            this.size = size;
            rep = new ArrayList<>();
        } else {
            //throw new InvalidStateException("BoundedQueue()");
        	throw new IllegalStateException("BoundedQueue()");
        }
    }

    //Methods
    public boolean isEmpty() {
        return (getCount() == 0);
    }

    public boolean isFull() {
        return (getCount() == size);
    }

    public int getCount() {
        return rep.size();
    }

    public void put(T e) {
        if (e != null && !isFull()) {
            if (getCount() <= size)
            rep.add(e);
        }
    }

    public T get() {
        T result = null;
        if (!isEmpty()) {
            result = rep.get(0);
            rep.remove(0);
        } else {
            throw new IllegalStateException("BoundedQueue.get");
        }
        return result;
    }

    public void putAll(Iterable<? extends T> src) {
        //EFFECTS: puts all elements from an Iterable type into rep until
        //rep isFull and discards remaining elements in Iterable.
        for (T t : src) { put(t); }
    }

    //Get Items from collection
    public void getAll () {
        //EFFECTS: removes all elements from rep until rep isEmpty.
        while (!isEmpty()) {
            get();
        }
    }

    public boolean repOK() {
        //EFFECTS: Returns true if the rep invariant holds for this
        //otherwise returns false

        if(rep.size() > size) return false;

        return true;
    }

    public static void main(String args[]) {
        BoundedQueue<Integer> queue = new BoundedQueue<>(10);

        
        for (int i = 0; !queue.isFull(); i++) {
            queue.put(i);
            System.out.println("put: " + i);
        }
        queue.put(null);
        //System.out.println("put: " + queue.toString());
        while (!queue.isEmpty()) {
            System.out.println("get: " + queue.get());
        }

    }

}
