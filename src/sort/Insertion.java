package sort;


/**
 * 
 * This class implements 3 types of insertion sort (regular, comparable, and binary)
 * parts of the following code were taken from algs 4 
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Insertion {
	/**
	 * regular insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortInsert( Product[] x ) {
		//Iterating for each element in the array
        for (int i = 1; i < x.length; i++) {
        	//swapping until element is in the correct spot
            for (int j = i; j > 0; j--) {
            	//comparing each element to the one before it to determine if swapping is necessary
                if (x[j-1].compareTo(x[j]) > 0) {
                    swap(x, j-1, j);
                }
                else {
                	break;
                }
            }
        }	
	}

    @SuppressWarnings({"rawtypes"})
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
    	//Iterating for each element in the array
        for (int i = 1; i < n; i++) {
        	//swapping until element is in the correct spot
            for (int j = i; j > 0; j--) {
            	//comparing each element to the one before it to determine if swapping is necessary
                if (isLess(x[j], x[j-1])) {
                    swap(x, j-1, j);
                }
                else break;
            }
        }	
	}
    
    @SuppressWarnings({"rawtypes"})
	/**
	 * optimized insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
        for (int i = 1; i < n; i++) {
        	
        	//binary search to find where to insert element i of x
            int low = 0;
            int hi = i;
            Comparable element = x[i];
            for(;;) {
            	if(hi > low) {
	                int mid = low + (hi - low) / 2; 
	                if (isLess(element, x[mid])) {
	                	hi = mid;
	                }
	                else {
	                	low = mid + 1;
	                }
            	}
            	else {
            		break;
            	}
            }
            
            // this is the insertion 
            for (int j = i; j > low; --j) {
                x[j] = x[j-1];
            }
            x[low] = element;
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
    
	/**
	 * helper method for exchanging two elements
	 * @param a - the input array containing the elements to be exchanged
	 * @param i - the first element to be exchanged
	 * @param j - the second element to be exchanged
	 */
    @SuppressWarnings("rawtypes")
    private static void swap(Comparable[] a, int x, int y) {
    	//swapping elements at indices x and y from array a
        Comparable temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
    
    
}
