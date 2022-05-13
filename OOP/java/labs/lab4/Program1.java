import java.io.*;
import java.util.Scanner;
public class Program1{
    public static void main(String args[]) throws Exception{
	String filename = "ex1.csv";
	FileReader fr = new FileReader(filename);
	Scanner scan = new Scanner(fr);
	
	while (scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }  
	fr.close();
    }

}
