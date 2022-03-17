public class Program2 {
    public static void main(String args[]) {
	int array[] = {5, 1, 1, 1, 1, 1, 1, 1, 1, 7};
	for (int el: array) 
	    System.out.printf("%d ", el);
	System.out.println("\n" + strangeSum(array));
    }
    
    static int strangeSum(int arr[]) {
	int sum = 0;
	for (int el: arr) {
	    if (el % 2 == 0) {
		return sum;
	    }
	    sum += el;
	}
	sum = sum - arr[0] - arr[arr.length - 1];
	return sum;
    }
}
