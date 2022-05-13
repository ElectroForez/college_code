public class BMI {
    public static void main(String args[]) {

    }

    public static double calcBMI(double weight, double height) {
	/*weight - (kg); height - (cm) */
	double valueBMI = weight / (height * height);	
	return valueBMI;
    }
    
    public static String getBMIResult(double weight, double height) {
	/*weight - (kg); height - (cm) */
	String BMIresult;
	double BMIvalue;
	
	if (height <= 0 || height > 350) {
	    BMIresult = "указан некорректный рост";
	}
	if (weight <= 0 || weight > 1000) {
	    BMIresult = "указан некорректный вес";
	}
	
	if (BMIresult != null) {
	    BMIvalue = calcBMI(weight, height);
	} else {
	    return BMIresult;
	}

	if (BMI < 0 && BMI <= 16) {
	    BMIresult = "выраженный дефицит массы тела";
	} else if (BMI > 16 && BMI < 19) {
	    BMIresult = "недостаточная масса тела";
	} else if (BMI >= 19 && BMI < 25) {
	    BMIresult = "нормальная масса тела";
	} else if (BMI >= 25) {
	    BMIresult = "избыточная масса тела";
	}
	return BMIresult;
    }
}
