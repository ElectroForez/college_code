import java.util.HashMap;
import java.util.ArrayList;

public class Program {
    public static void main(String args[]) {
	EconomClassCar econom = new EconomClassCar();
	econom.getFullIncome();
	CoupeCar coupe = new CoupeCar();
	coupe.getFullIncome();
	SleepingCar sleeping = new SleepingCar();
	sleeping.getFullIncome();
	PasTrain train = new PasTrain();
	train.addCar(econom);
	train.addCar(coupe);
	train.addCar(sleeping);
	train.getVoyageIncome();
    }

}

abstract class PasTrainCar {
    protected  HashMap<String, Integer> ticketPrices;
    protected  HashMap<String, Integer> ticketAmount;
    public int getFullIncome() {
	int fullIncome = 0;
	for (String ticket: ticketPrices.keySet()) {
	    fullIncome += ticketPrices.get(ticket) * ticketAmount.get(ticket);	    
	}
	return fullIncome;
    }
}

//Плацкартный вагон
class EconomClassCar extends PasTrainCar {
    final static String down = "down";
    final static String downSide = "downSide";
    final static String upper = "upper";
    final static String upperSide = "upperSide";
    public EconomClassCar() {
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 1500);
	ticketPrices.put(downSide, 1000);
	ticketPrices.put(upper, 1500);
	ticketPrices.put(upperSide, 1000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, 40);
	ticketAmount.put(downSide, 20);
	ticketAmount.put(upper, 40);
	ticketAmount.put(upperSide, 20);
    }
    
    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в плацкарте: " + fullIncome);
	return fullIncome;
    }
}

//Купе
class CoupeCar extends PasTrainCar {
    final static String down = "down";
    final static String upper = "upper";
    public CoupeCar() {
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 3000);
	ticketPrices.put(upper, 3000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, 40);
	ticketAmount.put(upper, 40);
    }

    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в купе: " + fullIncome);
	return fullIncome;
    }
    
}

//СВ
class SleepingCar extends PasTrainCar {
    final static String down = "down";
    public SleepingCar() {
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 15000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, 20);
    }
    
    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в СВ: " + fullIncome);
	return fullIncome;
    }
}

class PasTrain {
    private ArrayList<PasTrainCar> trainComposit = new ArrayList<>();

    public void addCar(PasTrainCar car) {
	trainComposit.add(car);
    }

    public int getVoyageIncome() {
	System.out.println("Доход от рейса");
	int voyageIncome = 0;
	for (PasTrainCar car: trainComposit) {
	    voyageIncome += car.getFullIncome();
	}
	System.out.println("Итого: " + voyageIncome);
	return voyageIncome;
    }
}
