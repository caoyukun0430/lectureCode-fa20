public class MySLListNoSentinel {
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode first;
    private int size;

    /** Constructors for list and empty list */
    public MySLListNoSentinel() {
        first =null;
        size = 0;
    }

    public MySLListNoSentinel(int x) {
        first = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        first = new IntNode(x, first);
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return first.item;
    }

    /** Adds an item to the end of the list recursively.
     * We need to private helper addLast()
     * */
    private static void addLast(IntNode p, int x) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
        } else {
            addLast(p.next, x);
        }
    }
    public void addLast(int x) {
        size += 1;
        addLast(first, x);
    }

    /** Adds an item to the end of the list iteratively. */
    public void addLastIterative(int x) {
        if ( first == null) {
            first = new IntNode(x, null);
            size += 1;
            return;
        }
        IntNode p = first;
        while(p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
        size += 1;
    }

//    /** All legacy size() methods not needed, since we have caching size()
//       Returns the number of items in the list recursively.
//     * We need to private helper size()
//     * */
//    private static int size(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        }
//        return 1 + size(p.next);
//    }
//    public int size() {
//        return size(first);
//    }

    /**
     * Returns the size of the list - Caching
     */
    public int size() {
        return size;
    }

//    /** Returns the number of items in the list iteratively
//     * same as iterativeSize in IntList.java
//     * */
//    public int sizeIterative() {
//        IntNode p = first;
//        int size = 0;
//        while (p != null) {
//            size +=1;
//            p = p.next;
//        }
//        return size;
//    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        MySLListNoSentinel L = new MySLListNoSentinel();
        L.addFirst(10);
        L.addLastIterative(20);
        System.out.println(L.size());
    }
}
