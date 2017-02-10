/**
 *
 *  @author Czerniak Mieszko S14782
 *
 */

package zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Anagrams
{
	public List<String> list;
	public List<List<String>> sortedList;

	public Anagrams(String allWords) throws FileNotFoundException
	{
		list = new ArrayList<String>();
		sortedList = new ArrayList<List<String>>();
		Scanner sc = new Scanner(new File(allWords));

		while (sc.hasNext())
		{
			list.add(sc.next());
		}
		sc.close();
	}

	List<List<String>> getSortedByAnQty()
	{
		List<List<String>> listOfLists = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		List<String> listCpy = new ArrayList<String>(list);

		for (String wordToCompare : list)
		{
			if (listCpy.contains(wordToCompare))
			{
				temp.add(wordToCompare);
				for (int i = list.indexOf(wordToCompare) + 1; i < list
						.size(); i++)
				{
					if (wordToCompare.length() == list.get(i).length()
							&& checkAnagrams(wordToCompare, list.get(i)))
					{
						temp.add(list.get(i));
						listCpy.remove(list.get(i));
					}
				}
				listOfLists.add(new ArrayList<String>(temp));
				temp.clear();
			}
		}
		listOfLists.sort(new Lcomp());
		sortedList = new ArrayList<List<String>>(listOfLists);
		return listOfLists;
	};

	boolean checkAnagrams(String str1, String str2)
	{
		for (int i = 0; i < str1.length(); i++)
		{
			if (!str2.contains(Character.toString(str1.charAt(i))))
			{
				return false;
			}
		}
		return true;
	}

	String getAnagramsFor(String w)
	{
		String wynik = w + ": ";
		for (int i = 0; i < sortedList.size(); i++)
		{
			for (int j = 0; j < sortedList.get(i).size(); j++)
			{
				if ((sortedList.get(i)).get(j).equals(w))
				{
					(sortedList.get(i)).remove(w);
					wynik += sortedList.get(i);
				}
			}
		}
		if (wynik == w + ": ")
		{
			wynik += "null";
		}
		return wynik;
	}
}
