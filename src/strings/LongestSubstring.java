package strings;

public class LongestSubstring {

	public static void main(String args[]) {
		String lSubstring = getLongestSub(args, 0, 0, 0);
		System.out.println("Longest Substring is : " + lSubstring);
	}


	private static String getLongestSub(String[] list, int startIndex, int start, int end) {
		int x, y;

		for(x=startIndex; x<list[0].length(); x++) {

			for(y=0; y<list.length; y++) {
				if(! list[0].substring(startIndex, x).equalsIgnoreCase(
					 list[y].substring(startIndex, x))) {
					return list[0].substring(start, end);
				}
			}

			if((start - end) < (x - startIndex)) {
				start = startIndex;
				end   = x;
			}
		}

		return getLongestSub(list, startIndex + 1, start, end);
	}
}