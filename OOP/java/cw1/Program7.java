public class Program7 {
    public static void main(String args[]) {
	Rectangle rec = new Rectangle();
	rec.setA_B(2, 2);
	rec.setColor("Yellow");
	rec.printParams();
    }
}


interface Figures {
    void setCoor(int x, int y);
    void setColor(String color);
    void printParams();
    boolean isVisible();
    double PI = 3.14159265;
}
class Figure {
    protected int x = 0;
    protected int y = 0;
    public void setCoor(int x, int y) {
	this.x = x;
	this.y = y;
    }
    
    public void printParams() {
	System.out.println("x = " + x);
	System.out.println("y = " + y);
    }
    
}

class Point extends Figure implements Figures {
    protected String color;
    protected boolean visible = true;
    public void setColor(String color) {
	this.color = color;
    }
    
    public boolean isVisible() {
	return visible;
    }
    
    public void printParams() {
	super.printParams();
	System.out.println("color = " + color);
	System.out.println("visible = " + isVisible());
    }
}

class Circle extends Point {
    int R;
    public void setR(int R) {
	this.R = R;
    }
    public void printParams() {
	super.printParams();
	System.out.println("R = " + R);
	System.out.println("square = " + getSquare());
    }
    public double getSquare() {
	return PI * R * R;
    }
}

class Rectangle extends Point {
    int a, b;
    
    public void setA_B(int a, int b) {
	this.a = a;
	this.b = b;
    }
    
    public void printParams() {
	super.printParams();
	System.out.println("a = " + a);
	System.out.println("b = " + b);
	System.out.println("square = " + getSquare());
    }
    public int getSquare() {
	return a * b;
    }
    
}
