import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	System.out.printf("Введите длину массива: ");
	int lengthArray = in.nextInt();
	int[] numbers = new int[lengthArray]; 
	System.out.printf("Введите элементы массива: ");
	for (int i = 0; i < lengthArray; i++) {
	    numbers[i] = in.nextInt();
	}
	
	System.out.printf("Массив:");
	for (int i = 0; i < lengthArray; i++) {
	    System.out.printf("%d ", numbers[i]);
	}
	//считаем сумму
	int sum = 0;
	for (int i = 0; i < lengthArray; i++) {
	    if (i % 2 != 0) {
		sum += numbers[i];
	    }
	}
	
	
	System.out.printf("\nСумма элементов массива с нечётными индексами = %d\n", sum);
    }
    
}
