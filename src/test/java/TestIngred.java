import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngred {
    private IngredientType ingredient;
    private String name;
    private float price;
    public TestIngred(IngredientType ingredient, String name, float price){
        this.ingredient = ingredient;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.SAUCE, "Булка", 3.14f},
                {IngredientType.FILLING, "Лепешка", 80.15f},
        };
    }

    @Test
    public void testIngredientClass(){
        Ingredient ingred = new Ingredient(ingredient, name, price);
        Assert.assertTrue(ingredient == ingred.getType());
        Assert.assertEquals(name, ingred.getName());
        Assert.assertTrue(price == ingred.getPrice());
    }
}
