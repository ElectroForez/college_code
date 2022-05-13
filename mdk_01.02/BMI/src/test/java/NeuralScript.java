import junit.framework.Assert;
import org.junit.Test;

public class NeuralScript {
    @Test
    public void checkNormalBMIValue() {
        var actualResult = BMI.calcBMI(75, 180);
        Assert.assertEquals(23.15, actualResult, 0.01);
    }
}
