/** Array based list.
 *  @author Josh Hug
 * # Sample check
 * index:  0  1  2  3  4  5
 * items: [1, 2, 3, 4, 0, 0, ...]
 *  size: 4
 *
 * # Invariants
 * addLast: The next item will go into position size
 * getLast: The item to be returned is in position size - 1
 * size: The number of items in the list should be size
 */

public class AList {
    private int[] items;
    private int size;

    /** Creates an empty list. */
    public AList() {
        items = new int[100];
        size = 0;
    }

    /**
     * Resizes the underlying array to the target capacity. *
     * (Note that this method works very slow.)
     */
    private void resize(int capacity) {
        int[] newItems = new int[capacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
        // size += capacity; NO!! Don't change size! Because no new items are added,
        // size doesn't change!
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int removed = getLast();
        items[size -1] = 0; // doesn't hurt but not necessary
        size -= 1;
        return removed;
    }

} 