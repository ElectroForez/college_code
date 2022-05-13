public class Perimetr {
    public static void main(String args[]) {
	Polygon p = new Polygon(1, 2, 3, 4);
	p.getStat();
	Rectangle rec = new Rectangle(3, 4, 5);
	rec.getStat();
    }
}

interface MathFun {
    default int sumAll(int... values) {
	int result = 0;
	for(int n : values){
	    result += n;
	}
	return result;
    }
    
}
class Polygon implements MathFun  {
    int sides[];
    public Polygon(int... sides) {
	this.sides = sides;
    }

    public void getStat() {
	int per = sumAll(sides);
	System.out.println("Периметр равен = " + per);
    }
}

class Rectangle extends Polygon {
    public Rectangle(int... sides) {
	super(sides);
    }
    
    public void getStat() {
	super.getStat();
	System.out.println("Площадь треугольника равна = " + getSquare());
    }
    
    public double getSquare() {
	int p = sumAll(sides);
	return Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
    }
}
