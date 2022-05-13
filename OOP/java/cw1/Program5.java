import java.util.Scanner;

public class Program5 {
    static int randomNum(int min, int max) {
	return (int)(Math.random()*((max-min)+1))+min;
    }
    public static void main(String args[]) {
	int min = 1; //от какого числа генерируем
	Scanner sc = new Scanner(System.in);
	System.out.print("Введите n: ");
	int n = sc.nextInt();
	int guessNumber = randomNum(min, n); //загаданное число
	System.out.print("Введите k: ");
	int k = sc.nextInt();
	for (int i = 1; i <= k; i++) {
	    System.out.println("\nПопытка " + i);
	    int conjecture;//попытка предугадать
	    while (true) {
		System.out.print("Ваше число: ");
		conjecture  = sc.nextInt();
		if ((conjecture >= min) && (conjecture <= n))
		    break;
		System.out.println("Ваше число выходит за диапазон");
	    }
	    
	    if (guessNumber == conjecture) {
		System.out.println("Вы угадали!");
		return;
	    }
	    if (conjecture < guessNumber)
		System.out.println("Загаданное число больше!");
	    else
		System.out.println("Загаданное число меньше!");
	}
	System.out.println("Попытки закончились. Загаданное число - " + guessNumber); 
    }

}
