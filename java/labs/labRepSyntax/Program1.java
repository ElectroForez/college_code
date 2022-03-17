public class Program1 {
    static int randomNum(int min, int max) {
	return (int)(Math.floor(Math.random() * (max - min + 1)) + min);
    }
    
    public static void main(String args[]) {
	final String player1 = "Первый игрок";
	final String player2 = "Второй игрок";
	final String STONE = "Камень";
	final String SCISSORS = "Ножницы";
	final String PAPER = "Бумага";
	String variants[] = {STONE, SCISSORS, PAPER};
	String wins[] = {SCISSORS, PAPER, STONE};

	int i_v1 = randomNum(0, variants.length - 1);
	int i_v2 = randomNum(0, variants.length - 1);

	System.out.println(player1 + " выбрал: " + variants[i_v1]);
	System.out.println(player2 + " выбрал: " + variants[i_v2]);
	
	boolean victory = false;
	String winner = "";
	if (variants[i_v2] == wins[i_v1]) { 
	    victory = true;
	    winner = player1;
	} else if (variants[i_v1] == wins[i_v2]) {
	    victory = true;
	    winner = player2;
	    int t = i_v1;
	    i_v1 = i_v2;
	    i_v2 = t;
	}
	
	if (victory) {
	    System.out.println(winner + " победитель");
	    System.out.printf("%s победил %s\n", variants[i_v1], variants[i_v2]);
	    
	}  else {
	    System.out.println("Ничья");
	}
		
    }
}
