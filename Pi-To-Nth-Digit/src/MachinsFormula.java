import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MachinsFormula {
	public static final RoundingMode roundingMode = RoundingMode.HALF_EVEN;
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(System.in);
		System.out.print("Calculate pi to nth decimals(1-500): ");
		int n = Integer.parseInt(reader.nextLine());
		long time1 = System.currentTimeMillis();
		
		BigDecimal arctan1_5 = arctan(5, n + 5);
		BigDecimal arctan1_239 = arctan(239, n + 5);
		BigDecimal pi = arctan1_5.multiply(BigDecimal.valueOf(4)).subtract(arctan1_239).multiply(BigDecimal.valueOf(4));
		long time2 = System.currentTimeMillis();
		
		FileWriter writer = new FileWriter("Pi.txt");
		writer.write(pi.setScale(n, RoundingMode.DOWN).toPlainString());
		//writes to a file
		System.out.println(pi.setScale(n, RoundingMode.DOWN).toPlainString());
		reader.close();
		writer.close();
		System.out.println("Time Taken: " + (time2 - time1) / (double)1000);
		
	}

	public static BigDecimal arctan(int inverseX, int scale) {
		BigDecimal result, numer, term;
		BigDecimal invX = BigDecimal.valueOf(inverseX);
		BigDecimal invX2 = BigDecimal.valueOf(inverseX * inverseX);
		//need to use this method because 1/239 is not rational

		numer = BigDecimal.ONE.divide(invX, scale, roundingMode);

		result = numer;
		//loop eventually terminates when term = 0
		int i = 1;
		do {
			numer = numer.divide(invX2, scale, roundingMode);
			int denom = 2 * i + 1;
			term = numer.divide(BigDecimal.valueOf(denom), scale, roundingMode);
			if ((i % 2) != 0) {
				result = result.subtract(term);
			} else {
				result = result.add(term);
			}
			i++;
		} while (term.compareTo(BigDecimal.ZERO) != 0);
		return result;
	}

}
