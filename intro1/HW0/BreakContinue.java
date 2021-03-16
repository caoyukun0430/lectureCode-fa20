public class BreakContinue {
  /**Optional: Exercise 4
   * replaces each element a[i] with the sum of a[i] through a[i + n], but only if a[i] is positive valued.
   */
  public static void windowPosSum(int[] a, int n) {
    // Deepcopy of a, otherwise will be modify
    int [] b = java.util.Arrays.copyOf(a, a.length);
    for (int i = 0; i < a.length; i++) {
        if (a[i] < 0) {
          continue;
        }
        // define the upper bound when i+n exceeds
        int upper = i+n <= a.length-1 ? i + n : a.length-1;
        for (int j = i; j <= upper; j++) {
          System.out.printf("i is %d, j is %d, aj is %d \n", i, j, a[j]);
          a[i] += a[j];
        }
        // a[i] has added itself twice
        a[i] = a[i] - b[i];
    }
  }

  public static void main(String[] args) {
    //int[] a = {1, 2, -3, 4, 5, 4};
    int[] a = {1, -1, -1, 10, 5, -1};
    int n = 2;
    windowPosSum(a, n);

    // Should print 4, 8, -3, 13, 9, 4
    System.out.println(java.util.Arrays.toString(a));
  }
}