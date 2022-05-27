public class Program {
    public static void main(String[] args) {
	String str1 = "This";
	String str2 = "This";
	if (str1 == str2) {
	    System.out.println("Строки равны" + 1);
	}
	str1 = "This";
	 str2 = "This";
	str1 = str2 + "";
	if (str1 == str2) {
	    System.out.println("Строки равны" + 2);
	}
	 str1 = "This";
	 str2 = "This";
	str2 = str1 + "";
	if (str1.equals(str2)) {
	    System.out.println("Строки равны" + 3);
	}
    }
}
