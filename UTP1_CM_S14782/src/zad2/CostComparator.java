package zad2;

import java.util.Comparator;

public class CostComparator implements Comparator<Purchase> {
	
	@Override
	public int compare(Purchase o1, Purchase o2) {
		if(o1.costs>o2.costs){
			return -1;
		}
		else if(o1.costs<o2.costs){
			return 1;
		}
		else{
			return o1.customer_ID.compareTo(o2.customer_ID);
		}
	}
}
