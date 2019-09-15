package sort;


/**
 * 
 * This class implements 2 different merge sorts, TD, and BU
 * parts of the following code were taken from algs 4 
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Merge {
	
    @SuppressWarnings({"rawtypes"})
	/**
	 * top-down merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD ( Comparable[] x, int n ) {
    	// creating auxilary array
        Comparable[] auxilary = new Comparable[n];
        
        //performing TD merge sort
        sort(x, auxilary, 0, n-1);
		
	}

    @SuppressWarnings({"rawtypes"})
    private static void merge(Comparable[] a, Comparable[] auxilary, int low, int mid, int hi) {
    	
    	// coppying array a[] into auxilary
        for (int k = low; k <= hi; k++) {
            auxilary[k] = a[k]; 
        }
        
        int i = low;
        int j = mid+1;
        
        // performing the actual merge on a[] 
        for (int k = low; k <= hi; k++) {
            if      (i > mid) {
            	a[k] = auxilary[j++];
            }
            else if (j > hi) {
            	a[k] = auxilary[i++];
            }
            else if (isLess(auxilary[j], auxilary[i])) {
            	a[k] = auxilary[j++];
            }
            else {
            	a[k] = auxilary[i++];
            }
        }
    }

    @SuppressWarnings({"rawtypes"})
    private static void sort(Comparable[] a, Comparable[] auxilary, int low, int hi) {
    	// return once we have gone through the whole array
        if (hi <= low) return;
        
        int mid = low + (hi - low) / 2;
        
        //recursively calling sort, then merge, ensuring that we are merging only sorted sub arrays
        sort(a, auxilary, mid + 1, hi);
        sort(a, auxilary, low, mid);
        merge(a, auxilary, low, mid, hi);
    }
	
	/**
	 * bottom-up merge sort using Comparable
	 * @param a - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
    @SuppressWarnings({"rawtypes"})
	public static void sortMergeBU ( Comparable[] a, int n ) {
    	
    	//Iterative instead of recursive
    	
    	//creating auxialry aray
        Comparable[] auxilary = new Comparable[n];
        
        
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
            	// Performing merge from bottom of the `tree` to the top
            	// ensuring that only sorted sub arrays get merged
                merge(a, auxilary, lo, lo+len-1, Math.min(lo+len+len-1, n-1));
            }
        }
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
}
