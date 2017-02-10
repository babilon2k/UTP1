package zad2;

import java.util.Comparator;

public class NameComparator implements Comparator<Purchase> {

	@Override
	public int compare(Purchase o1, Purchase o2) {
		if(o1.surname.compareTo(o2.surname)==0){
			return o1.customer_ID.compareTo(o2.customer_ID);
		}
		else{
			return o1.surname.compareTo(o2.surname);
		}
	}
}
