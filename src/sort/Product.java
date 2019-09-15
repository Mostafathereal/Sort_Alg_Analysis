package sort;

/**
 * 
 * This class implements a product as an object
 * The sales amount and ID are both kept as instance variables `salesAmount` `ID`
 * The sales amount can be changed after initializing
 * @author Mostafa Mohsen, mohsem1, 400116062
 *
 */
public class Product implements Comparable<Product>{
	
	private String ID = new String();
	private int salesAmount;

	/**
	 * This is the initializer method used to initialize the values of ID and salesAmount
	 * @param ID - used to identify the product
	 * @param salesAmount - the sales amount of the product
	 */
	public void init(String ID, int salesAmount) {
		this.ID = ID;
		this.salesAmount = salesAmount;	
	}
	
	/**
	 * This is the method used for the Comparable interface, which returns a bool based on whether the given product is has a greater `salesAmount` then the on called upon
	 * @param j - the product to compare to
	 * @return the method returns an int, 1 if the called upon product has a larger sales amount than the passed product, -1 is it's smaller, and 0 if they're equal 
	 */
	@Override
	public int compareTo(Product j)
	{
		if (this.salesAmount > j.getSalesAmount()) return 1;
		else if (this.salesAmount < j.getSalesAmount()) return -1;
		else return 0;

	}
	
	/**
	 * This is the method is used to get the sales amount of a product
	 * @return the returned value is the sales amount
	 */
	public int getSalesAmount() {
		return this.salesAmount;
	}
	
	/**
	 * This is the method returns the ID of this specific product
	 */
	public String getID() {
		return this.ID;
		
	}
	
	/**
	 * This is the method used to set the sales amount of the product 
	 * @param amount - the new amount
	 */
	public void setSalesAmount(int amount) {
		this.salesAmount = amount;
	}
	
	/**
	 * This method is used to get a string representation of the product
	 * @return the value returned is the string representation which includes the ID and sales amount
	 */
	public String toString() {
		return ( this.ID + " " + this.salesAmount);
	}
	
}
