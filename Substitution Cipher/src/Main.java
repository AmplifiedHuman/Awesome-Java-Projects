//This is an addition project I made. (not included in this weeks exercise)
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.print("Please enter a string to be encrypted:");
		// hello its me
		Scanner reader = new Scanner(System.in);
		String message = reader.nextLine();
		final String key = "qwertyuiopasdfghjklzxcvbnm";
		String encoded = encode(message, key);
		System.out.println(encoded);
		String decoded = decode(encoded, key);
		System.out.println(decoded);
		reader.close();

	}

	public static String encode(String message, String key) {
		String encoded = "";
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < message.length(); i++) {
			String sequence = "" + message.charAt(i);
			if (key.toUpperCase().contains(sequence)) {
				sequence = "" + key.charAt(alphabet.indexOf(sequence.toLowerCase()));
				sequence = sequence.toUpperCase();
			} else if (key.contains(sequence)) {
				sequence = "" + key.charAt(alphabet.indexOf(sequence));
			}
			encoded += sequence;
		}
		return encoded;
	}

	public static String decode(String message, String key) {
		String decoded = "";
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < message.length(); i++) {
			String sequence = "" + message.charAt(i);
			if (key.toUpperCase().contains(sequence)) {
				sequence = "" + alphabet.charAt(key.indexOf(sequence.toLowerCase()));
				sequence = sequence.toUpperCase();
			}
			if (key.contains(sequence)) {
				sequence = "" + alphabet.charAt(key.indexOf(sequence));
			}
			decoded += sequence;
		}
		return decoded;
	}
}