import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeSet;
import java.util.AbstractMap.SimpleEntry;

public class TreeSetFrequencyDictionary implements FrequencyDictionary 
{
	private TreeSet<Entry<String, Integer>> data;

	public TreeSetFrequencyDictionary() 
	{
		data = new TreeSet<Entry<String, Integer>>(new EntryComparator());
	}

	@Override
	public Integer get(String word)
	{
		for (Entry<String, Integer> entry : data)
		{
			if (entry.getKey().equals(word))
				return entry.getValue();
		}
		
		return null;
	}

	@Override
	public void put(String word) 
	{
		for (Entry<String, Integer> entry : data)
		{
			if (entry.getKey().equals(word))
			{
				entry.setValue(entry.getValue() + 1);
				return;
			}
		}
		
		data.add(new SimpleEntry<String, Integer>(word, 1));

	}

	@Override
	public ArrayList<Entry<String, Integer>> getTop(String prefix, int count) 
	{
		if (count <= 0)
			return null;
		
		ArrayList<Entry<String, Integer>> filteredData = new ArrayList<Entry<String, Integer>>();
		for (Entry<String, Integer> entry : data)
		{	
			if (entry.getKey().startsWith(prefix))
				filteredData.add(entry);
		}
		filteredData.sort(new FDictComparator());
		
		ArrayList<Entry<String, Integer>> result = new ArrayList<Entry<String, Integer>>();
		for (Entry<String, Integer> entry : filteredData)
		{	
			if (count-- <= 0)
				break;
			result.add(entry);
		}
		
		return result;
	}

}
