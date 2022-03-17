public class Program3 {
    public static void main(String args[]) {
	double a = 0;
	double b = 10;
	System.out.println(findX(a, b));
    }
    
    static double findX(double a, double b) {
	final double ACCURACY = 0.01;
	double y_a = f(a);
	double y_b = f(b);

	if (y_a * y_b < 0) {
	    double x = (a + b) / 2;
	    double y_x = Math.abs(f(x));
	    if (y_x < ACCURACY)
		return x;
	  
	    double x_left = findX(a, x);
	    if (!Double.isNaN(x_left))
		return x_left;

	    double x_right = findX(x, b);
	    if (!Double.isNaN(x_right))
		return x_right;
	}
	return Double.NaN;
    }
    
    static double f(double x) {
	double y = Math.cos(Math.pow(x, 5)) + Math.pow(x, 4) - 345.3 * x - 23;
	return y;
    }
}
