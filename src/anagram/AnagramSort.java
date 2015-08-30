package anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class AnagramSort{

	public static void main( String[] args ){
		HashMap< Integer, ArrayList< String >> hm = new HashMap();
		
		// long startTime = System.nanoTime();
		// naiveSort_1( args, hm );
		// System.out.println( hm.values() );
		// long endTime = System.nanoTime();

		// long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.

		// System.out.println( "Execution Tiime[ naiveSort_1 ] : " + duration + " nano seconds" );

		// long startTime2 = System.nanoTime();
		// boolean flag2   = isAnagramMap( args[ 0 ], args[ 1 ]);
		// long endTime2   = System.nanoTime();
		// long duration2  = endTime2 - startTime2;
		// System.out.println( flag2 + " :: Execution Tiime[ Map ] : " + duration2 + " nano seconds" );

		// long startTime3 = System.nanoTime();
		// boolean flag3   = isAnagramSort( args[ 0 ], args[ 1 ]);
		// long endTime3   = System.nanoTime();
		// long duration3  = endTime3 - startTime3;
		// System.out.println( flag3 +" :: Execution Tiime[ Sort ] : " + duration3 + " nano seconds" );

		int runTime = 100000000;
		long averageTime1 = 0;
		for( int x=0; x<runTime; x++ ){
			long startTime1 = System.nanoTime();
			boolean flag1   = isAnagramPrime( args[ 0 ], args[ 1 ]);
			long endTime1   = System.nanoTime();
			averageTime1 += endTime1 - startTime1;
		}
		System.out.println( "Execution Tiime[ Prime ] : " + averageTime1 / runTime + " nano seconds" );

		// int runTime = 100000000;
		// long averageTime2 = 0;
		// for( int x=0; x<runTime; x++ ){
		// 	long startTime4 = System.nanoTime();
		// 	boolean flag4   = isAnagramBitwise( args[ 0 ], args[ 1 ]);
		// 	long endTime4   = System.nanoTime();
		// 	averageTime2 += endTime4 - startTime4;
		// }
		// System.out.println( "Execution Tiime[ Bitwise ] : " + averageTime2 / runTime + " nano seconds" );
	}


	public static void naiveSort_1( String[] list, HashMap< Integer, ArrayList< String >> hm ){

		for( int x=0; x<list.length; x++ ){
			if( list[ x ] == null ) continue;

			String curX    = list[ x ];
			int    hashX   = primeHash( curX );

			hm.put( hashX, new ArrayList( Arrays.asList( curX )));

			for( int y=x+1; y<list.length; y++ ){

				String curY    = list[ y ];
				int    hashY   = primeHash( curY );

				if( curY == null || curY.length() != curX.length())  continue;
				
				if( hashX == hashY ){
					hm.get( hashX ).add( curY );
		
					list[ y ] = null; // if its an anagram null it out to avoid checking again
				}
			}
		}
	}


// Utility Mehthods

	public static int primeHash( String word ){
		int productOfPrimes = 1;
		int prime[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 
			37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101 };

		for( char ch : word.toCharArray() ){
			productOfPrimes *= prime[ (int) ch - (int) 'a' ];
		}
		return productOfPrimes;
	}

	public static boolean isAnagramSort( String first, String second ){
		char[] f = first.toCharArray();
		char[] s = second.toCharArray();
		Arrays.sort( f );
		Arrays.sort( s );


		String firstSorted  = new String( f );
		String secondSorted = new String( s );

		return firstSorted.equals( secondSorted );
	}

	public static boolean isAnagramPrime( String first, String second ){
		return primeHash( first ) == primeHash( second );
	}

	public static boolean isAnagramMap( String first, String second ){
		HashMap< Character, Integer > map = new HashMap( 15 );

		if( first.length() != second.length() ) return false;

		for( char ch : first.toCharArray() ){
			if( map.containsKey( ch )) map.put( ch, map.get( ch ) + 1 );
			else                       map.put( ch, 1 );
		}
		for( char ch : second.toCharArray() ){
			if( map.containsKey( ch )) map.put( ch, map.get( ch ) - 1 );
			else                       return false;
		}
		for( char key : map.keySet() ){
			if( map.get( key ) != 0 ) return false;
		}
		return true;
	}

	public static boolean isAnagramBitwise( String first, String second ){
		int len = first.length();
		if( len != second.length() ) return false;

		int a = 0;

		for( int x=0; x<len; x++ ){
			a ^= first.charAt( x ) ^ second.charAt( x );
		}

		return a == 0;
	}

}