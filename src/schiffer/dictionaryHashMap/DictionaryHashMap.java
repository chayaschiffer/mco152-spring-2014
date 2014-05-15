package schiffer.dictionaryHashMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
public class DictionaryHashMap {
	private final Map<String, String> map;

	public DictionaryHashMap() throws FileNotFoundException {
		String fileName = "./OWL.txt";
		map = new HashMap<String, String>();
		readDataInFile(fileName);
	}

	public boolean exists(String aString) {
		String theWord = aString.trim().toUpperCase();
		return map.containsKey(theWord);
	}

	public Iterator<String> iterator(){
		return map.keySet().iterator();
	}
	public void readDataInFile(String filename) throws FileNotFoundException {
		Scanner inputFile = new Scanner(new File(filename));

		while (inputFile.hasNext()) {
			map.put(inputFile.next(),  inputFile.nextLine());
			//word is the key
			//definition is the value
		}
		inputFile.close();

	}
	
	public String getDefinition(String word){
		return map.get(word);
	}

}

/*containsKey has an efficiency of o(1)
 * 
 * hash map -no add method. map.put(two parameters)
 * 
 * when you want to look up something by value, hash map is the most efficient
*/