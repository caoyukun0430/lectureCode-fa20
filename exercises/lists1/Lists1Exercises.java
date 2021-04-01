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

    /** Dis 3 exampreps
     * Implement the method evenOdd by destructively changing the ordering of a given
     * IntList so that even indexed links precede odd indexed links.
     * For instance, if lst is defined as IntList.list(0, 3, 1, 4, 2, 5), evenOdd(lst)
     * would modify lst to be IntList.list(0, 1, 2, 3, 4, 5).
     * */
    public static void evenOdd(IntList lst) {
        // no need to reorder if there is only 0, 1, 2 elements
        if (lst == null || lst.rest == null || lst.rest.rest == null) {
            return;
        }
        // Second record the starting pos of odd list
        IntList second = lst.rest;
        int index = 0;
        // only when index % 2 = 0 and it's last element(even length) or next last element(odd length) will we exit
        while (!(index % 2 == 0 && (lst.rest == null || lst.rest.rest == null))) {
            // Save location before overwrite by .next
            IntList temp = lst.rest;
            lst.rest = lst.rest.rest;
            lst = temp;
            index++;
        }
        lst.rest = second;
    }

    /** Dis 3 exampreps
     * IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     * IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
     * Fill in the method skippify such that the result of calling skippify on A and B
     * are as below:
     * - After calling A.skippify(), A: (1, 3, 6, 10)
     * - After calling B.skippify(), B: (9, 7, 4)
     * */
    public static void skippify(IntList lst) {
        IntList p = lst;
        int n = 1;
        while (p != null) {
            // n is number of hops, next records each hop pos
            IntList next = p.rest;
            for (int i = 1; i <= n; i++) {
                // if we hit next is null, we breaks and return null, so nothing after p is included
                if(next == null) {
                    break;
                }
                next = next.rest;
            }
            // include nothing after p is next is null, otherwise get the new hopped pos
            p.rest = next;
            // update p to continue from hopped pos
            p = p.rest;
            n += 1;
        }
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
         System.out.println(dincrList(L, 3));
//        IntList L = new IntList(1, null);
//        L = new IntList(2, L);
//        L = new IntList(3, L);
//        L = new IntList(4, L);
//        L = new IntList(5, L);
//        L = new IntList(6, L);
//        L = new IntList(7, L);
//        evenOdd(L);
//        skippify(L);
//        System.out.println(L.get(1));
    }
}