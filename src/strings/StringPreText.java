package strings;

public class StringPreText{

	public static void main( String args[] ){
		int res1 = getCommonPrefixNaive( args );
		System.out.println( res1 );
	}

	public static int getCommonPrefixNaive( String[] list ){

		int bitSum = 0;

		for( int x=0; x<list.length; x++ ){
			bitSum ^= list[ x ].charAt( x );

			if( bitSum != 0 )
				return x;
		}

		return 0;
	}
}