import java.util.LinkedList;
import java.util.Map.Entry;

public class LinkedListFrequencyDictionary extends ListFrequencyDictionary
{
	public LinkedListFrequencyDictionary()
	{
		super(new LinkedList<Entry<String, Integer>>());
	}

}
