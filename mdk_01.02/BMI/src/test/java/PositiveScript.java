import org.junit.Assert;
import org.junit.Test;

public class PositiveScript {
    @Test
    public void pronouncedUnderweight() {
        var actualResult = BMI.getBMIResult(30, 180);
        Assert.assertEquals("выраженный дефицит массы тела", actualResult);
    }

    @Test
    public void underweight() {
        var actualResult = BMI.getBMIResult(60, 180);
        Assert.assertEquals("недостаточная масса тела", actualResult);
    }

    @Test
    public void normalWeight() {
        var actualResult = BMI.getBMIResult(75, 180);
        Assert.assertEquals("нормальная масса тела", actualResult);
    }

    @Test
    public void excessWeight() {
        var actualResult = BMI.getBMIResult(75, 100);
        Assert.assertEquals("избыточная масса тела", actualResult);
    }

    @Test
    public void checkNormalBMIValue() {
        var actualResult = BMI.calcBMI(75, 180);
        Assert.assertEquals(23.15, actualResult, 0.01);
    }
}
