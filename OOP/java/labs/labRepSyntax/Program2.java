public class Program2 {
    public static void main(String args[]) {
	final int LENGTH = 10;
	double arr[] = new double[LENGTH];
	System.out.println("Array:");
	for (int i = 0; i < LENGTH; i++) {
	    arr[i] = Math.random();
	    System.out.println("a[" + i + "] = " + arr[i]);
	}
	
	double min = arr[0];
	double max = arr[0];
	double sum = 0;
	for (int i =1; i < LENGTH; i++) {
	    if (arr[i] > max) {
		max = arr[i];
	    } else if (arr[i] < min) {
		min = arr[i];
	    }
	    sum += arr[i];
	}
	double mean = sum / LENGTH;
	
	System.out.println("Максимум: " + max); 
	System.out.println("Минимум: " + min);
	System.out.println("Среднее: " + mean);
    }
}
