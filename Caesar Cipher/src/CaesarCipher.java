public class CaesarCipher {

	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		bruteforce("pm ol ohk hufaopun jvumpkluaphs av zhf, ol dyval pa pu jpwoly, aoha pz, if zv johunpun aol vykly vm aol slaalyz vm aol hswohila, aoha uva h dvyk jvbsk il thkl vba.");
	}

	public static String encrypt(String msg, int shift) {
		msg = msg.toLowerCase();
		String encrypted = "";
		char currentChar;
		int order;
		
		for (int i = 0; i < msg.length(); i++) {
			currentChar = msg.charAt(i);
			if (ALPHABET.contains(currentChar + "")) {
				order = ALPHABET.indexOf(currentChar);
				currentChar = ALPHABET.charAt(Math.floorMod(order + shift, 26));
			}
			encrypted += currentChar;
		}
		
		return encrypted;
	}
	
	public static String decode(String msg, int shift) {
		msg = msg.toLowerCase();
		String decrypted = "";
		char currentChar;
		int order;
		
		for (int i = 0; i < msg.length(); i++) {
			currentChar = msg.charAt(i);
			if (ALPHABET.contains(currentChar + "")) {
				order = ALPHABET.indexOf(currentChar);
				currentChar = ALPHABET.charAt(Math.floorMod(order - shift, 26));
			}
			decrypted += currentChar;
		}
		
		return decrypted;
	}
	
	public static void bruteforce(String msg) {
		for (int i = 1; i < 26; i++) {
			System.out.println("Shift " + i + ":" + decode(msg, i));
		}
	}

}
