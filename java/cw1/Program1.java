import java.util.Scanner;

public class Program1 {
    public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	int n1 = scan.nextInt();
	int n2 = scan.nextInt();
	int n3 = scan.nextInt();
	n1 *= 2;
	n2 -= 3;
	n3 *= n3;
	int sum = n1 + n2 + n3;	 
	System.out.printf("%d + %d + %d = %d\n", n1, n2, n3, sum);
    }

}
