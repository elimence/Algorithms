package anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class AnagramSort{

	public static void main(String[] args) {
		Map<Integer, List<String>> sortedListGroup = new HashMap<>();
		Map<String, List<String>> sortedListMap = null;
		Map<Integer, List<String>> sortedListMapNG = null;

		int runTime = 10000;
		long averageTime = 0;

		// for( int x=0; x<runTime; x++ ){
		// 	long startTime = System.nanoTime();
		// 	sortedListMap = mapAnagrams(args);
		// 	long endTime   = System.nanoTime();
		// 	averageTime += endTime - startTime;
		// }
		// System.out.println( sortedListMap.values() + " :: RunTime[Map] : " + averageTime / runTime + " nano seconds" );

		

		// averageTime = 0;

		// for( int x=0; x<runTime; x++ ){
		// 	long startTime = System.nanoTime();
		// 	sortedListMapNG = mapAnagramsNextGen(args);
		// 	long endTime   = System.nanoTime();
		// 	averageTime += endTime - startTime;
		// }
		// System.out.println( sortedListMapNG.values() + " :: RunTime[NGen] : " + averageTime / runTime + " nano seconds" );

		// averageTime = 0;

		for( int x=0; x<runTime; x++ ){
			long startTime = System.nanoTime();
			sortedListGroup = groupAnagrams(args);
			long endTime   = System.nanoTime();
			averageTime += endTime - startTime;
		}
		Map<Integer,List<String>> temp = groupAnagrams(args);
		// System.out.println( temp + " :: RunTime[Group] : " + averageTime / runTime + " nano seconds" );		
		System.out.println(temp);
	}


	private static Map<Integer, List<String>> groupAnagrams(String[] list) {
		Map<Integer, List<String>> sortedList = new HashMap<>();

		for(int x=0; x<list.length; x++) {
			if(list[x] == null){
				continue;
			}

			String curX    = list[x];
			int    hashX   = primeHash(curX);

			sortedList.put(hashX, new ArrayList());
			// sortedList.get(hashX).put(curX);

			for(int y=x; y<list.length; y++ ){
				String curY = list[y];

				if(curY == null || curY.length() != curX.length()) {
					continue;
				}
				int hashY = primeHash(curY);

				if(hashX == hashY) {
					// System.out.println( hashX == hashY);
					sortedList.get(hashX).add(curY);
					// System.out.println(sortedList);
					list[ y ] = null; // if its an anagram null it out to avoid checking again
				}
			}
		}

		return sortedList;
	}

	public static Map<String, List<String>> mapAnagrams(String[] args){
		Map<String,List<String>> matchMap = new HashMap<>();
		for (String word : args) {
		    String key = anagramKey(word);
		    if (!matchMap.containsKey(key)) {
		        matchMap.put(key, new ArrayList<String>());
		    }
		    matchMap.get(key).add(word);
		}

		return matchMap;
	}

	public static Map<Integer, List<String>> mapAnagramsNextGen(String[] args){
		Map<Integer,List<String>> matchMap = new HashMap<>();
		for (String word : args) {
		    int key = primeHash(word);
		    if (!matchMap.containsKey(key)) {
		        matchMap.put(key, new ArrayList<String>());
		    }
		    matchMap.get(key).add(word);
		}

		return matchMap;
	}


// Utility Mehthods

	private static int primeHash( String word ){
		int productOfPrimes = 1;
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

		for(char ch : word.toCharArray()) {
			productOfPrimes *= prime[ch - 'a'];
		}
		
		return productOfPrimes;
	}

	private static final String anagramKey(String word) {
	    word = word.toLowerCase();
	    char[] chars = word.toCharArray();
	    Arrays.sort(chars);
	    return new String(chars);
	}

}