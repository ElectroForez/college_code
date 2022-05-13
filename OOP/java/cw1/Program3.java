public class Program3 {
    public static void main(String args[]) {
	final String STR = "0";
	String outStr = STR; 
	int countRepeat = 5;
	
	for (int i = 1; i <= countRepeat; i++) {
	    System.out.println(outStr);
	    outStr += STR;
	}
    }
}
