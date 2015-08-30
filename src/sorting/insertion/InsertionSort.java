/**
 * Analysis of Insertion Sort
 * 
 *
 */


package sorting.insertion;

import java.util.Arrays;


public class InsertionSort {

	public static void main(String[] args) {

		int index = 0;
		int[] input = new int[args.length];

		for(String str : args) {
			input[index++] = Integer.parseInt(str);
		}

		sort(input);
		// print(input, "Sorted List");
		print(Arrays.toString(input));
	}

	/**
	 *	Sorts an array using the insertion sort algorithm
	 *
	 *	@param list	An array of integers to be sorted
	 *	@throws	ArrayIndexOutOfBoundsException
	 */
	public static void sort(int[] data) {
		for(int i=1; i<data.length; i++) {
			int j=i;
			int temp;
			while(j>0 && data[j-1]>data[j]) {
				temp = data[j];
				data[j] = data[j-1];
				data[j-1] = temp;
				j--;
			}
		}
	}

	public static void print(int[] ls, String msg) {
		System.out.print(msg + " :: => ");
		for(int x : ls) {
			System.out.print(x + ", ");
		}
		System.out.println();
	}
	public static void print(String str) {
		System.out.println(str);
	}
}