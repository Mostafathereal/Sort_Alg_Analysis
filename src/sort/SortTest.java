/**
 * 
 */
package sort;

//import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This is the Junit test class, which tests each type of sort with each of the seven randomly produced arrays of products
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class SortTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	Product[] products1;
	Product[] products2;
	Product[] products3;
	Product[] products4;
	Product[] products5;
	Product[] products6;
	Product[] products7;
	
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	private boolean isSorted(Comparable[] a) {
		for(int i = 0; i < a.length - 1; i++) {
			if(a[i].compareTo(a[i+1]) > 0 ) return false;
		}
		return true;
	}

	/**
	 * setup method used to set up the product arrays for testing the sorting algorithms
	 * 
	 */
	@Before
	public void setUp() throws Exception {
		File file = new File("data/a1_in.txt");
		FileReader FR = new FileReader(file);
		BufferedReader BR = new BufferedReader(FR);
		String line1 = BR.readLine();
		String line2 = BR.readLine();
		String line3 = BR.readLine();
		String line4 = BR.readLine();
		String line5 = BR.readLine();
		String line6 = BR.readLine();
		String line7 = BR.readLine();
		
		products1 = (Product[]) new Product[16];
		products2 = (Product[]) new Product[64];
		products3 = (Product[]) new Product[256];
		products4 = (Product[]) new Product[1024];
		products5 = (Product[]) new Product[4096];
		products6 = (Product[]) new Product[16384];
		products7 = (Product[]) new Product[65536];

		StringTokenizer ST1 = new StringTokenizer(line1);
		StringTokenizer ST2 = new StringTokenizer(line2);
		StringTokenizer ST3 = new StringTokenizer(line3);
		StringTokenizer ST4 = new StringTokenizer(line4);
		StringTokenizer ST5 = new StringTokenizer(line5);
		StringTokenizer ST6 = new StringTokenizer(line6);
		StringTokenizer ST7 = new StringTokenizer(line7);
		
		String ID;
		String SA;
		
		int i = 0;
		while(ST1.hasMoreTokens()) {
			ID = new String(ST1.nextToken(","));
			SA = new String(ST1.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products1[i] = new Product();
			products1[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST2.hasMoreTokens()) {
			ID = new String(ST2.nextToken(","));
			SA = new String(ST2.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products2[i] = new Product();
			products2[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST3.hasMoreTokens()) {
			ID = new String(ST3.nextToken(","));
			SA = new String(ST3.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products3[i] = new Product();
			products3[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST4.hasMoreTokens()) {
			ID = new String(ST4.nextToken(","));
			SA = new String(ST4.nextToken(",")); 
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products4[i] = new Product();
			products4[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST5.hasMoreTokens()) {
			ID = new String(ST5.nextToken(","));
			SA = new String(ST5.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products5[i] = new Product();
			products5[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST6.hasMoreTokens()) {
			ID = new String(ST6.nextToken(","));
			SA = new String(ST6.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products6[i] = new Product();
			products6[i].init(ID, salesA);
			//System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
			i++;
		}
		
		i = 0;
		while(ST7.hasMoreTokens()) {
			ID = new String(ST7.nextToken(","));
			SA = new String(ST7.nextToken(","));
			ID = ID.replace("{", "");
			SA = SA.replace("}", "");
			int salesA = Integer.parseInt(SA);
			products7[i] = new Product();
			products7[i].init(ID, salesA);
			i++;
		}
		
		//System.out.println("BAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		
//		for(i = 0; i<16; i++) {
//			System.out.println(products1[i].getID() + " " + products1[i].getSalesAmount());
//		}
		
		BR.close();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link sort.Heap#sortHeap(java.lang.Comparable[], int)}.
	 */
	@Test
	public void testHeap() {
		
		Stopwatch T1 = new Stopwatch();
		Heap.sortHeap(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Heap.sortHeap(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Heap.sortHeap(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Heap.sortHeap(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Heap.sortHeap(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
		Stopwatch T6 = new Stopwatch();
		Heap.sortHeap(products6, products6.length);
		double Time6 = T6.elapsedTime();
		
		Stopwatch T7 = new Stopwatch();
		Heap.sortHeap(products7, products7.length);
		double Time7 = T7.elapsedTime();

		System.out.println("FOR HEAP:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.print(Time5);
		System.out.print("  ");
		System.out.print(Time6);
		System.out.print("  ");
		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
		assert isSorted(products6) == true;
		assert isSorted(products7) == true;
		
	}
	
	/**
	 * Test method for {@link sort.Merge#sortMergeTD(java.lang.Comparable[], int)}.
	 */
	@Test
	public void testMergeTD() {
		
		Stopwatch T1 = new Stopwatch();
		Merge.sortMergeTD(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Merge.sortMergeTD(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Merge.sortMergeTD(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Merge.sortMergeTD(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Merge.sortMergeTD(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
		Stopwatch T6 = new Stopwatch();
		Merge.sortMergeTD(products6, products6.length);
		double Time6 = T6.elapsedTime();
		
		Stopwatch T7 = new Stopwatch();
		Merge.sortMergeTD(products7, products7.length);
		double Time7 = T7.elapsedTime();
		
		System.out.println("FOR MERGE TD:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.print(Time5);
		System.out.print("  ");
		System.out.print(Time6);
		System.out.print("  ");
		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
		assert isSorted(products6) == true;
		assert isSorted(products7) == true;
	}
	
	/**
	 * Test method for {@link sort.Merge#sortMergeBU(java.lang.Comparable[], int)}.
	 */
	@Test
	public void testMergeBU() {
		
		Stopwatch T1 = new Stopwatch();
		Merge.sortMergeBU(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Merge.sortMergeBU(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Merge.sortMergeBU(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Merge.sortMergeBU(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Merge.sortMergeBU(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
		Stopwatch T6 = new Stopwatch();
		Merge.sortMergeBU(products6, products6.length);
		double Time6 = T6.elapsedTime();
		
		Stopwatch T7 = new Stopwatch();
		Merge.sortMergeBU(products7, products7.length);
		double Time7 = T7.elapsedTime();

		System.out.println("FOR MERGE BU:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.print(Time5);
		System.out.print("  ");
		System.out.print(Time6);
		System.out.print("  ");
		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
		assert isSorted(products6) == true;
		assert isSorted(products7) == true;	
		
	}
	
	/**
	 * Test method for {@link sort.Insertion#sortInsert(java.lang.Comparable[])}.
	 */
	@Test
	public void testSortInsert() {
		
		Stopwatch T1 = new Stopwatch();
		Insertion.sortInsert(products1);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Insertion.sortInsert(products2);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Insertion.sortInsert(products3);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Insertion.sortInsert(products4);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Insertion.sortInsert(products5);
		double Time5 = T5.elapsedTime();
		
//		Stopwatch T6 = new Stopwatch();
//		Insertion.sortInsert(products6);
//		double Time6 = T6.elapsedTime();
//		
//		Stopwatch T7 = new Stopwatch();
//		Insertion.sortInsert(products7);
//		double Time7 = T7.elapsedTime();
		
		System.out.println("FOR SORT INSERT:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.println(Time5);
//		System.out.print("  ");
//		System.out.print(Time6);
//		System.out.print("  ");
//		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
//		assert isSorted(products6) == true;
//		assert isSorted(products7) == true;
		
		
	}
	
	/**
	 * Test method for {@link sort.Insertion#sortComparable(java.lang.Comparable[])}.
	 */
	@Test
	public void testInsertComparable() {
		
		Stopwatch T1 = new Stopwatch();
		Insertion.sortComparable(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Insertion.sortComparable(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Insertion.sortComparable(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Insertion.sortComparable(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Insertion.sortComparable(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
//		Stopwatch T6 = new Stopwatch();
//		Insertion.sortComparable(products6, products6.length);
//		double Time6 = T6.elapsedTime();
//		
//		Stopwatch T7 = new Stopwatch();
//		Insertion.sortComparable(products7, products7.length);
//		double Time7 = T7.elapsedTime();
		
		System.out.println("FOR INSERT COMPARABLE:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.println(Time5);
//		System.out.print("  ");
//		System.out.print(Time6);
//		System.out.print("  ");
//		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
//		assert isSorted(products6) == true;
//		assert isSorted(products7) == true;
		
	}
	
	/**
	 * Test method for {@link sort.Insertion#insertBinary(java.lang.Comparable[])}.
	 */
	@Test
	public void testInsertBinary() {
		
		Stopwatch T1 = new Stopwatch();
		Insertion.sortBinary(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Insertion.sortBinary(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Insertion.sortBinary(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Insertion.sortBinary(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Insertion.sortBinary(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
//		Stopwatch T6 = new Stopwatch();
//		Insertion.sortBinary(products6, products6.length);
//		double Time6 = T6.elapsedTime();
//		
//		Stopwatch T7 = new Stopwatch();
//		Insertion.sortBinary(products7, products7.length);
//		double Time7 = T7.elapsedTime();
		
		System.out.println("FOR INSERT BINARY:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.println(Time5);
//		System.out.print("  ");
//		System.out.print(Time6);
//		System.out.print("  ");
//		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
//		assert isSorted(products6) == true;
//		assert isSorted(products7) == true;
		
		
	}
	
	/**
	 * Test method for {@link sort.Quick#sortBasicQuick(java.lang.Comparable[])}.
	 */
	@Test
	public void testBasicQuick() {
		
		Stopwatch T1 = new Stopwatch();
		Quick.sortBasicQuick(products1);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Quick.sortBasicQuick(products2);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Quick.sortBasicQuick(products3);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Quick.sortBasicQuick(products4);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Quick.sortBasicQuick(products5);
		double Time5 = T5.elapsedTime();
		
		Stopwatch T6 = new Stopwatch();
		Quick.sortBasicQuick(products6);
		double Time6 = T6.elapsedTime();
		
		Stopwatch T7 = new Stopwatch();
		Quick.sortBasicQuick(products7);
		double Time7 = T7.elapsedTime();
	
		
		System.out.println("FOR BASIC QUICK:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.print(Time5);
		System.out.print("  ");
		System.out.print(Time6);
		System.out.print("  ");
		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
		assert isSorted(products6) == true;
		assert isSorted(products7) == true;
		
		
	}
	
	
	/**
	 * Test method for {@link sort.Quick#sortThreePartition(java.lang.Comparable[])}.
	 */
	@Test
	public void testThreePartition() {
		
		Stopwatch T1 = new Stopwatch();
		Quick.sortThreePartition(products1, products1.length);
		double Time1 = T1.elapsedTime();
		
		Stopwatch T2 = new Stopwatch();
		Quick.sortThreePartition(products2, products2.length);
		double Time2 = T2.elapsedTime();
		
		Stopwatch T3 = new Stopwatch();
		Quick.sortThreePartition(products3, products3.length);
		double Time3 = T3.elapsedTime();
		
		Stopwatch T4 = new Stopwatch();
		Quick.sortThreePartition(products4, products4.length);
		double Time4 = T4.elapsedTime();
		
		Stopwatch T5 = new Stopwatch();
		Quick.sortThreePartition(products5, products5.length);
		double Time5 = T5.elapsedTime();
		
		Stopwatch T6 = new Stopwatch();
		Quick.sortThreePartition(products6, products6.length);
		double Time6 = T6.elapsedTime();
		
		Stopwatch T7 = new Stopwatch();
		Quick.sortThreePartition(products7, products7.length);
		double Time7 = T7.elapsedTime();
		
		System.out.println("FOR THREE PARTITION:--------------------------------");
		System.out.print(Time1);
		System.out.print("  ");
		System.out.print(Time2);
		System.out.print("  ");
		System.out.print(Time3);
		System.out.print("  ");
		System.out.print(Time4);
		System.out.print("  ");
		System.out.print(Time5);
		System.out.print("  ");
		System.out.print(Time6);
		System.out.print("  ");
		System.out.println(Time7);

		
		assert isSorted(products1) == true;
		assert isSorted(products2) == true;
		assert isSorted(products3) == true;
		assert isSorted(products4) == true;
		assert isSorted(products5) == true;
		assert isSorted(products6) == true;
		assert isSorted(products7) == true;
		
		
		
	}
	

}
