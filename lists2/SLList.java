 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
//			System.out.println(size);
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

//		private static void lectureQuestion() {
//		SLList L = new SLList();
//		IntNode n = IntNode(5, null);
//	}

	/** Constructor
	 * Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	 /** Constructor
	  * Creates an SLList with x in the beginning. */
	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	 /** Constructor
	  * Creates an SLList with an array of integers. */
	 public SLList(int[] array) {
		 sentinel = new IntNode(63, null);
		 IntNode p = sentinel;
		 size = 0;
		 for (int j : array) {
			 p.next = new IntNode(j, null);
			 p = p.next;
			 size += 1;
		 }
	 }


 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

	 /** Deletes the first item in the list. */
 	public void deleteFirst() {
		sentinel.next = sentinel.next.next;
		size = size - 1;
	}

	 /** Adds an item to the end of the list recursively.
	  * We need to private helper addLast()
	  * */
	 private static void addLastRecursive(IntNode p, int x) {
		 if (p.next == null) {
			 p.next = new IntNode(x, null);
		 } else {
			 addLastRecursive(p.next, x);
		 }
	 }
	 public void addLastRecursive(int x) {
		 size += 1;
		 addLastRecursive(sentinel, x);
	 }

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
 	
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
// 		SLList L = new SLList(10);
// 		L.addFirst(5);
// 		L.addLast(20);
// 		L.deleteFirst();
// 		System.out.println(L.size());
//		System.out.println(L.getFirst());

		/* Creates a list of integers, new int[] {5, 10, 15}*/
		int[] array = new int[] {5, 10, 15};
		SLList Larray = new SLList(array);
		Larray.addFirst(1);
		Larray.addLast(20);
		System.out.println(Larray.size());
		System.out.println(Larray.getFirst());

 	}
}