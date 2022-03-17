class Rectangle {
    double x1, y1, x2, y2;
    double a, b;
    void setRectangle(double x1, double y1, double x2, double y2) {
	this.x1 = x1;
	this.y1 = y1;
	this.x2 = x2;
	this.y2 = y2;
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
	//System.out.println("Площадь квадрата = " + rectangle.getArea());

	int n = 5;

	Rectangle[] rectangleList = new Rectangle[n];  // creates an array of length k

	for (int i = 0; i < n; i++) { // adds a new node at each index
	    rectangleList[i] = new Rectangle();
	    rectangleList[i].setRectangle(0, 0, i + 2, i + 2);
	}

	int  minAreaRecId = 0;
	for (int i = 1; i < n; i++) {
	    if (rectangleList[i].getArea() < rectangleList[minAreaRecId].getArea()) {
		minAreaRecId = i;
	    }
	}
	System.out.println("Минимальная площадь = " + rectangleList[minAreaRecId].getArea());
	System.out.printf("Координаты (%3.2f, %3.2f, %3.2f, %3.2f)\n", rectangleList[minAreaRecId].x1, rectangleList[minAreaRecId].y1, rectangleList[minAreaRecId].x2, rectangleList[minAreaRecId].y2);
    }
}
