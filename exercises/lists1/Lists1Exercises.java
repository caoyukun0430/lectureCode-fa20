public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        /* Your code here. */
        return L;        
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        IntList p = L;
        // Solution 1 iterative:
        // while (p != null) {
        //   System.out.printf("p is %d", p.first);
        //   p.first = p.first - x;
        //   System.out.printf("p-x is %d \n", p.first);
        //   p = p.rest;
        // }

        // Solution 2 recursive:
        p.first = p.first - x;
        if (p.rest != null) {
          dincrList(p.rest, x);
        }
        return L;
    }

    public static void main(String[] args) {
        IntList L = new IntList(5, null);
        L.rest = new IntList(7, null);
        L.rest.rest = new IntList(9, null);

        System.out.println(L.size());
        System.out.println(L.iterativeSize());

        // Test your answers by uncommenting. Or copy and paste the
        // code for incrList and dincrList into IntList.java and
        // run it in the visualizer.
        System.out.println(L.get(1));
        // System.out.println(incrList(L, 3));
        IntList Lnew = dincrList(L, 3);
        for (int i = 0; i < Lnew.size(); i++) {
          System.out.println(Lnew.get(i));
        }
        // System.out.println(dincrList(L, 3));        
    }
}