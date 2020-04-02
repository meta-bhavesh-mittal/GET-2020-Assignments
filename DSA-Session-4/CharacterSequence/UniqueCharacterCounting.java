package Session4.CharacterSequence;

import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Set;

/**
 * String Counting class is created to calculate the unique character in a string .
 *
 * @author BHAVESH MITTAL
 *
 */
public class UniqueCharacterCounting {

	Map<String, Integer> map = new HashMap<String, Integer>();
	Set<String> set;

	public static void main(String[] args) 
	{
		UniqueCharacterCounting obj = new UniqueCharacterCounting();
		System.out.println(obj.UniqueCharCount(null));
		System.out.println(obj.UniqueCharCount("BHAVESH MITTALa"));
		System.out.println(obj.UniqueCharCount(""));
		System.out.println(obj.UniqueCharCount("MITTAL"));
		System.out.println(obj.UniqueCharCount("BHAVESH"));
		System.out.println(obj.UniqueCharCount("BHAVESH MITTAL"));
		System.out.println(obj.UniqueCharCount("BHAVESH"));

	}

	/**
	 * calculation method stores the unique character to inside the map no of unique charactesrs.
	 * 
	 * 
	 * @param inputString
	 * @return no of unique character
	 */
	public int UniqueCharCount(String inputString)
	{
		set = new HashSet<String>();
		int answer = 0;

		try 
		{
			if(inputString == null)
			{
				throw new InputMismatchException("Wrong Input");
			}
			else if(inputString == " ")
			{
				throw new InputMismatchException("Input Cannot Be Empty");
			}
			else if(cache(inputString) != -1)
			{
				answer = cache(inputString);
			}
			else
			{
				for(int i = 0 ; i < inputString.length() ; i++)
				{
					if(!" ".equals(Character.toString(inputString.charAt(i))))
					{
						set.add(Character.toString(inputString.charAt(i))); 
					}
				}
				answer = set.size();
				map.put(inputString, answer);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return answer;

	}

	
	/**
	 *  this method verifies that if the string is already present in the 
	 *  cache memory .
	 *  
	 * @param inputString
	 * @return cacheValue
	 */
	public int cache(String inputString)
	{
		int cacheValue = -1;
		if(map.containsKey(inputString))
		{
			cacheValue = map.get(inputString);
		}
		return cacheValue;
	}

}
