import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class TestBun {
    Bun bun = new Bun("Булка", 3.14f);

    @Test
    public void testName(){
        Assert.assertEquals("Булка", bun.getName());
    }
    @Test
    public void testPrice(){
        Assert.assertTrue(3.14f == bun.getPrice());
    }
}
