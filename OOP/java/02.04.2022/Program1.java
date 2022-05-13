public class Program1 {
    public static void main(String args[]) {
	int[][] arr1 = {{1,2,3},{4,5,6},{7,8,9}};
	int[][] arr2 = {{1,2},{4,5},{7,8}};
	System.out.println("Arr1:");
	printArr(arr1);
	System.out.println("Arr2:");
	printArr(arr2);
	int[][] arrRes = arrDot(arr1, arr2);
	System.out.println("Arr result:");
	printArr(arrRes);
    }
    //Функция умножения
    public static int[][] arrDot(int[][] arr1, int[][] arr2) {
	int[] shape1 = getShape(arr1);
	int[] shape2 = getShape(arr2);
	if (shape1[1] != shape2[0])//Проверка на форму матриц	    
	    throw new ArithmeticException("Нельзя умножить матрицу с длиной " + shape1[0] + "x" + shape1[1] +
					  " на матрицу с длиной " + shape2[0] + "x" + shape2[1]);
	
	int[][] resultMat = new int[shape1[1]][shape2[1]];
	for (int row1 = 0; row1 < shape1[0]; row1++) {
	    for(int col2 = 0; col2 < shape2[1]; col2++) {
		int sum = 0;
		for (int col1 = 0; col1 < shape1[1]; col1++)
		    sum += arr1[row1][col1] * arr2[col1][col2];
		resultMat[row1][col2] = sum;
	    }	    
	}		
	return resultMat;
    }
    //Функция печати массива
    public static void printArr(int[][] arr) {
	for (int[] row: arr) {
	    for (int el: row)
		System.out.printf("%3d ", el);
	    System.out.println();
	}
    }
    //Фукция получения формы массива
    //0 индекс - m, 1 индекс - n 
    public static int[] getShape(int[][] arr) {
	return new int[]{arr.length, arr[0].length};
    }

}
