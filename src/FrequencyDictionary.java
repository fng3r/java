import java.util.ArrayList;
import java.util.Map.Entry;

public interface FrequencyDictionary
{
	public Integer get(String word);
	public void put(String word);
	public ArrayList<Entry<String, Integer>> getTop(String prefix, int count);
	public default void putAll(String[] string)
	{
		for (String word : string)
			put(word);
	}
}
