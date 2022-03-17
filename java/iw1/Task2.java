import java.util.Scanner;

class Task2 {
    public static void main(String[] args) {
       	System.out.printf("Введите число, в котором хотите посчитать сумму цифр: ");
	Scanner in = new Scanner(System.in);
	int inputNumber = in.nextInt();
	int sum = 0;
	while (inputNumber != 0) {
	    sum += inputNumber % 10;
	    inputNumber /= 10;
	    }
	
	System.out.printf("Сумма чисел = %d\n", sum);
    }
}
