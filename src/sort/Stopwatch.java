package sort;

/**
 * 
 * This class implements a stopwatch, used to time the sorting algorithms
 * This was created during the 2XB3 lab walkthrough 4
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Stopwatch {
	
	private final long start;
	
	/**
	 * This method initializes a starting time when it is called
	 */
	public Stopwatch() {
		start = System.currentTimeMillis();
	}
	
	/**
	 * this method returns the difference between the start time and the current time when it is called which is the elapsed time
	 * @return elapsed time 
	 */
	public double elapsedTime() {
		
		double now = System.currentTimeMillis();		
		return (now - start) / 1000.0;
	}

}
