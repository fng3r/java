import java.util.Comparator;
import java.util.Map.Entry;

public class FDictComparator implements Comparator<Entry<String, Integer>> 
{
	@Override
	public int compare(Entry<String, Integer> one, Entry<String, Integer> other) 
	{
		int result = one.getValue().compareTo(other.getValue());
		if (result != 0) 
			return -result;
		
		return one.getKey().compareTo(other.getKey());
	}

}
