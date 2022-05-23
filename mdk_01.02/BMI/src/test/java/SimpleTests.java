import junit.framework.Assert;
import org.junit.Test;

public class SimpleTests
{
    @Test
    public void testNormalWeight()
    {
        var actualResult = getIMTResult(180f, 75f);
        Assert.assertEquals("нормальной массе тела", actualResult);
    }

    @Test
    public void testZeroHeight()
    {
        var actualResult = getIMTResult(0f, 65f);
        Assert.assertEquals("указан некорректный рост", actualResult);
    }


    private String getIMTResult(Float heightCm, Float weightKg)
    {
        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;
        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19)  {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult+="указан некорректный рост";
        return userResult;
    }


}
