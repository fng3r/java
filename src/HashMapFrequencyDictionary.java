import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class HashMapFrequencyDictionary implements FrequencyDictionary 
{
	private HashMap<String, Integer> data;
	
	public HashMapFrequencyDictionary()
	{
		data = new HashMap<String, Integer>();
	}
	
	@Override
	public Integer get(String word) 
	{
		return data.get(word);
	}

	@Override
	public void put(String word) 
	{
		Integer count = data.containsKey(word) ? data.get(word) : 0;
		data.put(word, count + 1);
	}

	@Override
	public ArrayList<Entry<String, Integer>> getTop(String prefix, int count) 
	{
		if (count < 0)
			return null;
		
		ArrayList<Entry<String, Integer>> filteredData = new ArrayList<Entry<String, Integer>>();
		for (Entry<String, Integer> entry : data.entrySet())
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
