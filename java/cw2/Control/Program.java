import Entities.Lecture;

public class Program {
    public static void main(String args[]) {	
	Lecture lec = new Lecture();
	lec.create("ООП", "29-04-21", "456", "8:20", "3ИСиП-19-1");
	lec.setInfo("Спим!");
	lec.getInfo();
	Lecture lec_copy = lec.copy();
	lec.getInfo();
    }

}
