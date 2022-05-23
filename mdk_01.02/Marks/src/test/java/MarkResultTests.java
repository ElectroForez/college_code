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
    public void mark10(){
        var actualResult = Marks.getMarkResult(10);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void mark35(){
        var actualResult = Marks.getMarkResult(35);
        Assert.assertEquals("2", actualResult);
    }

    @Test
    public void mark36(){
        var actualResult = Marks.getMarkResult(36);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void mark53(){
        var actualResult = Marks.getMarkResult(53);
        Assert.assertEquals("3", actualResult);
    }

    @Test
    public void mark57(){
        var actualResult = Marks.getMarkResult(57);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void mark71(){
        var actualResult = Marks.getMarkResult(71);
        Assert.assertEquals("4", actualResult);
    }

    @Test
    public void mark72(){
        var actualResult = Marks.getMarkResult(72);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void mark100(){
        var actualResult = Marks.getMarkResult(100);
        Assert.assertEquals("5", actualResult);
    }

    @Test
    public void mark101(){
        var actualResult = Marks.getMarkResult(101);
        Assert.assertEquals("no mark result", actualResult);
    }
}
