public class Program {
    public static void main(String[] args){
	StraightTriangle sTriangle1 = new StraightTriangle();
	StraightTriangle sTriangle2 = new StraightTriangle();
	sTriangle1.setCoor(0, 0, 5, 6);
	sTriangle2.setCoor(0, 0, 3, 4);
	System.out.printf("sTriangle1 perimetr =%6.2f square =%6.2f\n", sTriangle1.getPerimeter(), sTriangle1.getSquare());
	System.out.printf("sTriangle2 perimetr =%6.2f square =%6.2f\n", sTriangle2.getPerimeter(), sTriangle2.getSquare()); 
    }
}

class Triangle {
    int[] x;
    int[] y;
    public void setCoor(int x0, int y0, int x1, int y1, int x2, int y2) {
	x = new int[] {x0, x1, x2};
	y = new int[] {y0, y1, y2};
	checkCoor(x, y);
    }
    //Проверяем корректность координат. Они не должны быть одинаковыми
    public void checkCoor(int[] x, int[] y) throws Error {
	int x_check, y_check;
	for (int i = 0; i < x.length - 1; i++) {
	    x_check = x[i];//берём все пары, кроме последней, слева направо
	    y_check = y[i];
	    for (int j = i + 1; j < x.length; j++) {
		if (x_check == x[j] && y_check == y[j]) {//если есть одинаковые, значит это некорректный треугольник
		    System.out.printf("The pair (%d, %d) is repeated\n", x_check, y_check);
		    throw new Error ("The triangle must not have the same vertices");
		}
	    }
	}
    }
    
    public double getPerimeter() {
	double perimetr = 0;
	for (int i = 0; i < x.length - 1; i++) {//Считаем по формуле некоторые из отрезков в цикле
	    perimetr += Math.sqrt(Math.pow(x[i + 1] - x[i], 2) + Math.pow(y[i + 1] - y[i] , 2));
	}
	//Последний отрезок, связывающий последнюю вершину с 0 приходится отдельно считать 
	perimetr += Math.sqrt(Math.pow(x[x.length - 1] - x[0], 2) + Math.pow(y[y.length - 1] - y[0] , 2));
	return perimetr;
    }
}

class StraightTriangle extends Triangle {
    //у у1 будет x1 = x0, а у x2 y2=y0
    public void setCoor(int x0, int y0, int y1, int x2) {
	x = new int[] {x0, x0, x2};
	y = new int[] {y0, y1, y0};
	checkCoor(x, y);
    }
    
    public double getSquare() {
	double a = Math.sqrt(Math.pow(y[1] - y[0] , 2));
	double b = Math.sqrt(Math.pow(x[2] - x[0] , 2));
	return a * b / 2;
    }
}
