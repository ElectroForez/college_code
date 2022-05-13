public class Program2 {
    public static void main(String args[]) {
	String phrase = "ABCZ";
	System.out.println(getLetterPosition('A'));
	System.out.println(getLetterPosition('Z'));
	System.out.println(encrypt(phrase));
    }
    
    enum Letters {
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
    }
    
    public static int getLetterPosition(char letter) {
	return Letters.valueOf("" + letter).ordinal() + 1;
    }

    public static String encrypt(String phrase) {
	String result = "";
	for (char letter: phrase.toCharArray())
	    result += getLetterPosition(letter);
	return result;
    }
}
