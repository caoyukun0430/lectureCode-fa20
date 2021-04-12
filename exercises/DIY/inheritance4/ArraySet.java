import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArraySet<T> implements Iterable<T> {
    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        // this is one way, just ignore null
//        if (contains(x) || x == null) {
//            return;
//        }
        // in lecture, Hug chooses to throw exceptions
        if (x == null) {
            throw new IllegalArgumentException("can't add null");
        }
        if (contains(x)) {
            return;
        }
        items[size] = x;
        size += 1;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    /** returns an iterator (a.k.a. seer) into ME */
    @Override
    public Iterator<T> iterator() {
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T> {
        private int widPos;

        public ArraySetIterator() {
            widPos = 0;
        }

        @Override
        public boolean hasNext() {
            return widPos < size;
        }

        @Override
        public T next() {
            if (hasNext()) {
                T nextItem = items[widPos];
                widPos += 1;
                return nextItem;
            }
            return null;
        }
    }

//    @Override
//    public String toString() {
//        StringBuilder stringSB = new StringBuilder("{");
//        for (int i = 0; i < size - 1; i++) {
//            stringSB.append(items[i]);
//            stringSB.append(", ");
//        }
//        stringSB.append(items[size - 1]);
//        stringSB.append("}");
//        return stringSB.toString();
//    }

    /** advanced toString() method using .join() */
    @Override
    public String toString() {
        List<String> stringOfItems = new ArrayList<String>();
        for (T item : this) {
            stringOfItems.add(item.toString());
        }
        return "{" + String.join(", ", stringOfItems) + "}";
    }

    @Override
    public boolean equals(Object o) {
        // trivial true
        if (this == o) {return true;}
        // several trivial false cases to speed up.
        if (o == null) {return false;}
        if (this.getClass() != o.getClass()) {return false;}
        ArraySet<T> other = (ArraySet<T>) o;
        if (size() != other.size()) {return false;}
        for (T item : this) {
            if (!other.contains(item)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ArraySet<String> s = new ArraySet<>();
//        s.add(null);
        s.add("horse");
        s.add("fish");
        s.add("house");
        s.add("fish");        
        System.out.println(s.contains("horse"));        
        System.out.println(s.size());

        ArraySet<Integer> aset = new ArraySet<>();
        aset.add(5);
        aset.add(23);
        aset.add(42);

        System.out.println(aset);
        System.out.println(aset.equals(null));
        System.out.println(aset.equals(aset));
        System.out.println(aset.equals("aset"));


        Iterator<Integer> iter = aset.iterator();

//        while(iter.hasNext()) {
//            System.out.println(iter.next());
//        }
        //iteration
        for (int i : aset) {
            System.out.println(i);
        }
    }

    /* Also to do:
    1. Make ArraySet implement the Iterable<T> interface.
    2. Implement a toString method.
    3. Implement an equals() method.
    */
}
