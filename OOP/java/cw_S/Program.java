import java.util.HashMap;
import java.util.ArrayList;

public class Program {
    public static void main(String args[]) {
	EconomClassCar econom = new EconomClassCar(40, 20, 40, 20);
	econom.getFullIncome();
	CoupeCar coupe = new CoupeCar(20, 20);
	coupe.getFullIncome();
	SleepingCar sleeping = new SleepingCar(30);
	sleeping.setSeatPrices(27000);
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
    public abstract void setSeatPrices(int... prices);
}

//Плацкартный вагон
class EconomClassCar extends PasTrainCar {
    final static String down = "down";
    final static String downSide = "downSide";
    final static String upper = "upper";
    final static String upperSide = "upperSide";
    
    //в конструкторе передаётся количество мест
    public EconomClassCar(int cDown, int cDownSide, int cUpper, int cUpperSide) {
	/* Инициализация стоимости и количества билетов
	   со значениями по умолчанию */
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 1500);
	ticketPrices.put(downSide, 1000);
	ticketPrices.put(upper, 1500);
	ticketPrices.put(upperSide, 1000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, cDown);
	ticketAmount.put(downSide, cDownSide);
	ticketAmount.put(upper, cUpper);
	ticketAmount.put(upperSide, cUpperSide);
    }    
    
    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в плацкарте: " + fullIncome);
	return fullIncome;
    }
    
    public void setSeatPrices(int... prices) {
	ticketPrices.put(down, prices[0]);
	ticketPrices.put(downSide, prices[1]);
	ticketPrices.put(upper, prices[2]);
	ticketPrices.put(upperSide, prices[3]);
    }
}

//Купе
class CoupeCar extends PasTrainCar {
    final static String down = "down";
    final static String upper = "upper";
    
    //в конструкторе передаётся количество мест
    public CoupeCar(int cDown, int cUpper) {
	/* Инициализация стоимости со значениями по умолчанию
	   и количества билетов*/
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 3000);
	ticketPrices.put(upper, 3000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, cDown);
	ticketAmount.put(upper, cUpper);
    }

    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в купе: " + fullIncome);
	return fullIncome;
    }

    public void setSeatPrices(int... prices) {
	ticketPrices.put(down, prices[0]);
	ticketPrices.put(upper, prices[1]);
    }
    
}

//СВ
class SleepingCar extends PasTrainCar {
    final static String down = "down";
    //в конструкторе передаётся количество мест
    public SleepingCar(int cDown) {
	/* Инициализация стоимости со значениями по умолчанию
	   и количества билетов */
	ticketPrices = new HashMap<>();
	ticketPrices.put(down, 15000);

	ticketAmount = new HashMap<>();
	ticketAmount.put(down, cDown);
    }
    
    public int getFullIncome(){
	int fullIncome = super.getFullIncome();
	System.out.println("Полный доход в СВ: " + fullIncome);
	return fullIncome;
    }

    public void setSeatPrices(int... prices) {
	ticketPrices.put(down, prices[0]);
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
