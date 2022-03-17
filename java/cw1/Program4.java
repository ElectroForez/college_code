public class Program4 {
    public static void main(String args[]) {
	int x = 237;
	int lastN = x / 100;
	x = x % 100 * 10;
	x += lastN;
	System.out.println(x);
    }
}
