import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class TestIngred {
    SoftAssertions soft = new SoftAssertions();
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
        soft.assertThat(ingred.getType()).isEqualTo(ingredient);
        soft.assertThat(ingred.getName()).isEqualTo(name);
        soft.assertThat(ingred.getPrice()).isEqualTo(price);
        soft.assertAll();
    }
}
