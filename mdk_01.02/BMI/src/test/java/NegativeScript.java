import org.junit.Assert;
import org.junit.Test;

public class NegativeScript {

    @Test
    public void negativeHeight() {
        var actualResult = BMI.getBMIResult(7, -70);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }

    @Test
    public void negativeWeight() {
        var actualResult = BMI.getBMIResult(-10, 7);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void zeroWeight() {
        var actualResult = BMI.getBMIResult(0, 7);
        Assert.assertEquals("указан некорректный вес", actualResult);
    }

    @Test
    public void zeroHeight() {
        var actualResult = BMI.getBMIResult(7, 0);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }
}
