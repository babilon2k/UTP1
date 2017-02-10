/**
 *
 *  @author Czerniak Mieszko S14782
 *
 */

package zad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomersPurchaseSortFind
{
	public static List<Purchase> list;

	public void readFile(String fname)
	{
		Scanner sc;
		try
		{
			sc = new Scanner(new File(fname));

			String customer_ID;
			String surname;
			String name;
			float price;
			float quantity;
			String temp;
			list = new ArrayList<Purchase>();
			while (sc.hasNext())
			{
				sc.useDelimiter(";|\n");
				customer_ID = sc.next();
				surname = sc.next();
				name = sc.next();
				price = Float.parseFloat(sc.next());
				temp = sc.next();
				quantity = Float.parseFloat(temp.substring(0));
				list.add(new Purchase(customer_ID, surname, name, price,
						quantity));
			}
			sc.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void showSortedBy(String string)
	{
		List<Purchase> sortedList = new ArrayList<Purchase>(list);
		if (string == "Nazwiska")
		{
			sortedList.sort(new NameComparator());
			System.out.println("Nazwiska");
			for (int i = 0; i < sortedList.size(); i++)
			{
				sortedList.get(i).print();
			}
		} else if (string == "Koszty")
		{
			sortedList.sort(new CostComparator());
			System.out.println("\nKoszty");
			for (int i = 0; i < sortedList.size(); i++)
			{
				sortedList.get(i).printKoszt();
			}
		}
	}

	public void showPurchaseFor(String id)
	{
		System.out.println("\nKlient " + id);
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).customer_ID.equals(id))
			{
				list.get(i).print();
			}
		}
	}
}
