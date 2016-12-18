import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public abstract class ListFrequencyDictionary implements FrequencyDictionary
{
	List<Entry<String, Integer>> data;
	
	public ListFrequencyDictionary(List<Entry<String, Integer>> list) 
	{
		data = list;
	}

	@Override
	public Integer get(String word)
	{
		for (Entry<String, Integer> entry : data)
		{
			String entryKey = entry.getKey();
			if (entryKey.hashCode() == word.hashCode() && entryKey.equals(word))
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
