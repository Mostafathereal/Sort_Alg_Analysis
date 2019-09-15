package sort;


/**
 * 
 * This class implements heap sort
 * parts of the following code were taken from algs 4 
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Heap {

    @SuppressWarnings({"rawtypes"})
	/**
	 * heap sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
    	// constructing the heap tree
        for (int k = n/2; k >= 1; k--)
            sink(x, k, n);
        // performing heapsort
        while (n > 1) {
            swap(x, 1, n--);
            sink(x, 1, n);
        }
	}
	
    @SuppressWarnings({"rawtypes"})
	/**
	 * Sinking method
	 * @param pq - the input array containing the node to be sunk
	 * @param n - the size of the input array
	 * @param k - position of node
	 */
    private static void sink(Comparable[] a, int k, int n) {
    	// keep preforming sink until can no longer be preformed
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && isLess(a, j, j+1)) j++;
            if (!isLess(a, k, j)) break;
            swap(a, k, j);
            k = j;
        }
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
	/**
	 * helper method for comparing two elements
	 * @param pq - the input array containing the elements to be compared
	 * @param i - the first element to be compared
	 * @param j - the second element to be compared
	 */
    private static boolean isLess(Comparable[] a, int i, int j) {
    	//returns a bool to indicate if i is less than j
        return a[i-1].compareTo(a[j-1]) < 0;
    }

	/**
	 * helper method for exchanging two elements
	 * @param pq - the input array containing the elements to be exchanged
	 * @param i - the first element to be exchanged
	 * @param j - the second element to be exchanged
	 */
    @SuppressWarnings({"rawtypes"})
    private static void swap(Comparable[] a, int x, int y) {
    	//swapping elements at indices x and y from array a
        Comparable temp = a[x-1];
        a[x-1] = a[y-1];
        a[y-1] = temp;
    }	
	
}
