/**
 *
 *  @author Czerniak Mieszko S14782
 *
 */

package zad2;


public class Purchase {
	public String customer_ID;
	public String surname;
	public String name;
	public float price;
	public float quantity;
	public float costs;
	
	public Purchase(String id, String surname, String name, float price, float quantity) {
		this.customer_ID = id;
		this.surname = surname;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.costs = quantity * price;
	}
	
	public void print () {
		System.out.println(customer_ID + ";" + surname + ";" + name + ";" + price + ";" + quantity);
	}
	
	public void printKoszt () {
		System.out.println(customer_ID + ";" + surname + ";" + name + ";" + price + ";" + quantity 
				+ " koszt:(" + costs + ")");
	}

}
