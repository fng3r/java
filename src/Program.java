import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class Program 
{
	public static void main(String[] args)
	{
		int limit = 500000;
		int count = 10;
		FrequencyDictionary[] dicts = {new TreeSetFrequencyDictionary(), new HashMapFrequencyDictionary(), new LinkedListFrequencyDictionary(), new ArrayListFrequencyDictionary()};
		for (FrequencyDictionary fdict : dicts)
		{
			test(fdict, limit, count);
			System.out.println();
		}
	}
	
	public static void test(FrequencyDictionary fdict, int limit, int count)
	{
		System.out.println(fdict.getClass().getSimpleName());
		
		long startTime = System.currentTimeMillis();
		build(fdict, limit);
		long endTime = System.currentTimeMillis();
		System.out.println("Creating dict of size " + limit + " took " + (endTime - startTime) + " milliseconds");
		
		startTime = System.currentTimeMillis();
		top(fdict, count);
		endTime = System.currentTimeMillis();
		System.out.println("Getting top " + count + " took " + (endTime - startTime) + " milliseconds");
	}
	
	public static void top(FrequencyDictionary fdict, int count)
	{
		List<Entry<String, Integer>> result = fdict.getTop("ê", count);

		for (Entry<String, Integer> entry : result)
		{
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
	
	public static void build(FrequencyDictionary fdict, int limit)
	{
		int count = 0;
		try (Stream<String> stream = Files.lines(Paths.get("src\\files\\lt1.txt"), Charset.forName("Cp1251")))
		{
	        for(String line : (Iterable<String>)stream::iterator)
	        {
	        	if (count > limit)
	        		break;
	        	String[] words = line.split("[\\s,.-:();\"?!']");
//	        	for (String word : words)
//	        	{
//	        		if (!word.isEmpty())
//	        			System.out.println(word);
//	        	}
	        	count += words.length;
	        	fdict.putAll(words);
	        }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
