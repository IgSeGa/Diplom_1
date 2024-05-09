import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger{
    private List<Ingredient> list;
    private Burger burger;
    private SoftAssertions soft;

    @Mock
    Bun bun;
    @Mock
    Bun bun2;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredient2;
    @Mock
    Ingredient ingredient3;

    @Before
    public void setUp(){
        list = new ArrayList<>(Arrays.asList(ingredient,ingredient2));
        burger = new Burger(bun, list);
        soft = new SoftAssertions();
    }

    @Test
    public void testSetBut(){
        burger.setBuns(bun2);
        Assert.assertEquals(bun2, burger.bun);
    }
    @Test
    public void testAddIngred(){
        burger.addIngredient(ingredient3);
        soft.assertThat(list).contains(ingredient3);
        soft.assertThat(list.get(2)).isEqualTo(ingredient3);
        soft.assertThat(list.size()).isEqualTo(3);
        soft.assertAll();
    }
    @Test
    public void testRemoveIngred(){
        burger.removeIngredient(0);
        soft.assertThat(ingredient).isNotIn(list);
        soft.assertThat(list).contains(ingredient2);
        soft.assertThat(list.size()).isEqualTo(1);
        soft.assertAll();
    }
    @Test
    public void testMoveIngredient(){
        burger.moveIngredient(0,1);
        soft.assertThat(list.get(0)).isEqualTo(ingredient2);
        soft.assertThat(list.get(1)).isEqualTo(ingredient);
        soft.assertThat(list.size()).isEqualTo(2);
        soft.assertAll();
    }
    @Test
    public void testGetPrice(){
        Mockito.when(bun.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredient.getPrice()).thenReturn(3.15f);
        Assert.assertTrue(9.43f == burger.getPrice());
    }
    @Test
    public void testGetReciept() {
        Mockito.when(bun.getName()).thenReturn("С повидлом");
        Mockito.when(burger.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("Котлетосик");
        Mockito.when(ingredient2.getName()).thenReturn("Кепчук");
        String x = "(==== С повидлом ====)\r\n= filling Котлетосик =\r\n= sauce Кепчук =\r\n(==== С повидлом ====)\r\n\r\nPrice: 3,140000\r\n";
        Assert.assertEquals(x, burger.getReceipt());
    }
}
