import org.junit.Assert;
import org.junit.Test;

public class MarkResultTests {
    @Test
    public void negativeMark(){
        var actualResult = Marks.getMarkResult(-1);
        Assert.assertEquals("no mark result", actualResult);
    }

    @Test
    public void zeroMark(){
        var actualResult = Marks.getMarkResult(0);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void mark10Result(){
        var actualResult = Marks.getMarkResult(10);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void resultUpper2(){
        var actualResult = Marks.getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void resultLower3(){
        var actualResult = Marks.getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void mark53(){
        var actualResult = Marks.getMarkResult(53);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void resultUpper3(){
        var actualResult = Marks.getMarkResult(53);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void resultLower4(){
        var actualResult = Marks.getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void resultUpper4(){
        var actualResult = Marks.getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void resultLower5(){
        var actualResult = Marks.getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void resultUpper5(){
        var actualResult = Marks.getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void markBeyound5Limit(){
        var actualResult = Marks.getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }
}
