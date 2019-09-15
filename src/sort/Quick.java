package sort;

/**
 * 
 * This Module implements two quick sorts, Basic, and Three Partition
 * parts of the following code were taken from algs 4 
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Quick {
	/**
	 * basic quick sort
	 * @param x - the input array containing products that need to be sorted.
	 */
    @SuppressWarnings({"rawtypes"})
	public static void sortBasicQuick (  Comparable[] x ) {
        sort(x, 0, x.length - 1);
	}
	
    @SuppressWarnings({"rawtypes"})
    private static void sort(Comparable[] a, int low, int hi) { 
        //returning if the two pointers meet, meaning sort is complete
    	if (hi <= low) {
        	return;
        }
        else {
        	// recursively performing Qsort on each half of every partition
            int j = partition(a, low, hi);
            sort(a, low, j-1);
            sort(a, j+1, hi);
        }
    }

    @SuppressWarnings({"rawtypes"})
    private static int partition(Comparable[] a, int low, int hi) {
    	// finding partitioning element and returning it's index
    	
    	Comparable partElement = a[low];
    	int loww = low;
        int hii = hi + 1;
        for(;;) { 
        	
        	// finding high item to swap with 
            while (isLess(partElement, a[--hii])) {
                if (hii == low) {
                	break;      
                }
            }
            
            // finding low item to swap with
            while (isLess(a[++loww], partElement)) {
                if (loww == hi) {
                	break;
                }
            }

            //breaking if pointers cross
            if (loww >= hii) {
            	break;
            }
            
            swap(a, loww, hii);
        }

        swap(a, low, hii);
        return hii;
    }


    @SuppressWarnings({"rawtypes", "unchecked"})
	/**
	 * helper method for comparing two elements
	 * @param x - the first element to be compared
	 * @param y - the second element to be compared
	 */
    private static boolean isLess(Comparable x, Comparable y) {
    	//returns a bool to indicate if x is less than y
        if (x == y) {
        	return false;   
        }
        return x.compareTo(y) < 0;
    }
    
	/**
	 * helper method for exchanging two elements
	 * @param a - the input array containing the elements to be exchanged
	 * @param x - the first element to be exchanged
	 * @param y - the second element to be exchanged
	 */
    @SuppressWarnings("rawtypes")
    private static void swap(Comparable[] a, int x, int y) {
    	//swapping elements at indices x and y from array a
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
	
	/**
	 * three partition quick sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
    @SuppressWarnings({"rawtypes"})
	public static void sortThreePartition ( Comparable[] x, int n ) {
        sort3P(x, 0, x.length - 1);
	}
    
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static void sort3P(Comparable[] a, int low, int hi) { 
        if (hi <= low) {
        	return;
        }
        Comparable lp = a[low];
        int loww = low;
        int hii = hi;
        int i = low + 1;
        for (;;) {
        	if (hii < i) {
        		break;
        	}
            
            if (a[i].compareTo(lp) > 0) {
            	swap(a, i, hii--);
            }
            else if (a[i].compareTo(lp) < 0) {
            	swap(a, loww++, i++);
            }
            else              {
            	i++;
            }
        }
        sort3P(a, hii+1, hi);
        sort3P(a, low, loww-1);
        
    }
  
}
