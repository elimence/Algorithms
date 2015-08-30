package palindrom;

public class Palindrome {

	public static void main(String args[]) {
		System.out.println(isPalindromeBitwise(args[0]));
	}

	public static boolean isPalindromeBitwise(String word) {
		int result = 0;
		for(char ch : word.toCharArray()) {
			result ^= ch;
		}
		return result == 0 || word.indexOf((char) result) != -1;
	}
}