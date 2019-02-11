/*
 * Using taylor's series to estimate arctan(1)
 * Extremely inefficient, takes 1000000 iterations to get 5 decimal point precision
 */

public class GregorySeries {

	public static void main(String[] args) {
		int n = 1000000;
		double pi = 1;
		for (int i = 1; i <= n; i++) {
			if (i % 2 == 1) {
				pi -= ((double) 1 / (2 * i + 1));
			} else {
				pi += ((double) 1 / (2 * i + 1));
			}
		}
		pi *= 4;
		System.out.println(pi);
	}

}
