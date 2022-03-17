import java.io.*;
import java.util.Scanner;

public class Program2 {
    public static void main(String args[]) throws IOException {
	String filename = "ex2.csv";
	FileWriter fw= new FileWriter(filename);
	Scanner sc = new Scanner(System.in);
	int n = 3;
	for (int i=0; i<n; i++) {
	    String fio = sc.next();
	    fw.write(fio + "\n");
	}
	
	fw.close();
    }
}
