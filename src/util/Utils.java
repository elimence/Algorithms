package util; 

public class Utils {

	public interface Executable {
		public void apply();
	}

	public static double functionProfiler(Executable func) {
		long start = System.nanoTime();
		func.apply();
		long elapsedTime = System.nanoTime() - start;
		double seconds = (double)elapsedTime / 1000000000.0;

		return seconds;
	}


}