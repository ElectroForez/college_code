class Rectangle {
    int x1, y1, x2, y2;
    double a, b;
    void setRectangle(double x1, double y1, double x2, double y2) {
	a = Math.sqrt(Math.pow(y2-y1, 2));
	b = Math.sqrt(Math.pow(x2-x1, 2));
    }
    double getArea() {
	return a * b;
    }
}

class RectangleDemo {
    public static void main(String[] args) {
	Rectangle rectangle = new Rectangle();
	rectangle.setRectangle(0, 0, 5, 5);
	System.out.println("Площадь квадрата = " + rectangle.getArea());
	 
    }
}
