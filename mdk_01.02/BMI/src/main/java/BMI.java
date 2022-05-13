public class BMI {
    public static double calcBMI(double weightKg, double heightCm) {
        double heightM = heightCm / 100;
        return weightKg / (heightM * heightM);
    }

    public static String getBMIResult(double weightKg, double heightCm) {
        String BMIResult = null;
        double BMIValue;

        if (heightCm <= 0 || heightCm > 350) {
            BMIResult = "указан некорректный рост";
        }
        if (weightKg <= 0 || weightKg > 1000) {
            BMIResult = "указан некорректный вес";
        }

        if (BMIResult != null) {
            return BMIResult;
        }

        BMIValue = calcBMI(weightKg, heightCm);

        if (BMIValue > 0 && BMIValue <= 16) {
            BMIResult = "выраженный дефицит массы тела";
        } else if (BMIValue > 16 && BMIValue < 19) {
            BMIResult = "недостаточная масса тела";
        } else if (BMIValue >= 19 && BMIValue < 25) {
            BMIResult = "нормальная масса тела";
        } else if (BMIValue >= 25) {
            BMIResult = "избыточная масса тела";
        }

        return BMIResult;
    }
}
