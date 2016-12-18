import java.util.ArrayList;
import java.util.Map.Entry;

public class ArrayListFrequencyDictionary extends ListFrequencyDictionary 
{
	public ArrayListFrequencyDictionary()
	{
		super(new ArrayList<Entry<String, Integer>>());
	}
}
