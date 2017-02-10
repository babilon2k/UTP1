package zad1;

import java.util.Comparator;
import java.util.List;

public class Lcomp implements Comparator<List<String>>
{
	@Override
	public int compare(List<String> arg0, List<String> arg1)
	{
		if (arg0.size() > arg1.size())
		{
			return -1;
		} else if (arg0.size() < arg1.size())
		{
			return 1;
		} else
		{
			return arg0.get(0).compareTo(arg1.get(0));
		}
	}
}
