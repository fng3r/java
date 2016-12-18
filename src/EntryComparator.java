import java.util.Comparator;
import java.util.Map.Entry;

public class EntryComparator implements Comparator<Entry<String, Integer>> 
{
	@Override
	public int compare(Entry<String, Integer> one, Entry<String, Integer> other) 
	{
		if (one.getKey().equals(other.getKey()))
    		return 0;
		int cmp = Integer.compare(other.getValue(), one.getValue());

		if (cmp == 0) return -1;
		return cmp;
    }
}
