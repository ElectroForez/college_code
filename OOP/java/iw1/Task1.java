import java.util.Scanner;

class Task1 {

    public static void main(String[] args) {
	//ввод чисел
	Scanner in = new Scanner(System.in);
	System.out.print("Input a: ");
	int a = in.nextInt();
	System.out.print("Input b: ");
	int b = in.nextInt();
	System.out.print("Input c: ");
	int c = in.nextInt();
	System.out.print("Input d: ");
	int d = in.nextInt();

	//пускай первым числом будет меньшая сторона, а вторым большая
	if (a > b) {
	    int t = a;
	    a = b;
	    b = t;
	}

	if (c > d) {
	    int t = c;
	    c = d;
	    d = t;
	}
      
 	boolean isInclude = false;//эта переменная будет означать входит ли один из конвертов
	
	if (a * b > c * d) {//смотрим у кого больше форма
	    if (a / c >= 1) {//условие для проверки ходит ли меньшая сторона в большую
		if (b / d >= 1) {
		    isInclude = true;//если дошло до сюда, то обе стороны входят
		}
	    }
	} else {//второй конверт больше
	     if (c / a >= 1) {
		if (d / b >= 1) {
		    isInclude = true;
		}
	     }	 
	}
	//выводим влез ли конверт или нет
	if (isInclude) {
	    System.out.print("Конверты влазят друг в друга\n");
	} else {
	    System.out.print("Конверты не влазят друг в друга\n");
	}
	
    }
}
