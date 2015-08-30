package strings;

public class PreFixer {

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("invalid arguments");
			return;
		}
		String commonPrefix_1 = getLongestCommonPrefix_1(args);
		System.out.println("(Method 1) Common Prefix for list is : " + commonPrefix_1);

		String commonPrefix_2 = getLongestCommonPrefix_2(args);
		System.out.println("(Method 2) Common Prefix for list is : " + commonPrefix_2);
	}



	/* Method 1 */
	private static String getLongestCommonPrefix_1 (String[] list) {
		int matchIndex = recursiveChecker(0, list);
		return list[0].substring(0, matchIndex);
	}

	private static int recursiveChecker(int strIndex, String[] list) {
		for (int x = 0; x < list.length; x++) {
			if (strIndex >= list[x].length()) {
				return strIndex;
			}
			if(list[0].charAt(strIndex) != list[x].charAt(strIndex)) {
				return strIndex;
			}
		}
		return recursiveChecker(strIndex + 1, list);
	}

	/* Method 2 */
	private static String getLongestCommonPrefix_2(String[] list) {
		int commonPrefixLength = 0;
		while(allCharsAreSame(list, commonPrefixLength)) {
			commonPrefixLength++;
		}
		return list[0].substring(0, commonPrefixLength);
	}

	private static boolean allCharsAreSame(String[] list, int pos) {
		for(String currentString : list) {
			if(currentString.length() <= pos || 
				currentString.charAt(pos) != list[0].charAt(pos)) {
				return false;
			}
		}
		return true;
	}
}

