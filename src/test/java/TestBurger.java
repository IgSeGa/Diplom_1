import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.*;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger{
    @Mock
    List<Ingredient> ingredients;
    @Mock
    Ingredient ingredient;
    @Mock
    Bun bun;
    @Spy
    Burger burger;


    @Test
    public void testSetBuns(){
        burger.setBuns(bun);
        Mockito.verify(burger).setBuns(bun);
    }
    @Test
    public void testAddIngredient(){
        Burger burger = new Burger(bun, ingredients);
        burger.addIngredient(ingredient);
        Mockito.verify(ingredients).add(ingredient);
    }
    @Test
    public void testRemoveIngredient(){
        Burger burger = new Burger(bun, ingredients);
        burger.removeIngredient(1);
        Mockito.verify(ingredients).remove(1);
    }
    @Test
    public void testMoveIngredient(){
        Burger burger = new Burger(bun, ingredients);
        burger.moveIngredient(1,3);
        Mockito.verify(ingredients).add(3,ingredients.remove(1));
    }

    @Test
    public void testGetPrice(){
        Burger burger = new Burger(bun, List.of(ingredient));
        Mockito.when(bun.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredient.getPrice()).thenReturn(3.15f);
        Assert.assertTrue(9.43f == burger.getPrice());
    }
    @Test
    public void testGetReciept(){
        Burger burger = new Burger(bun, List.of(ingredient));
        Mockito.when(bun.getName()).thenReturn("С повидлом");
        Mockito.when(burger.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("Котлетосик");
        String x = burger.getReceipt();
        String[] split = x.split("\r\n");
        Assert.assertEquals("(==== С повидлом ====)", split[0]);
        Assert.assertEquals("= filling Котлетосик =", split[1]);
        Assert.assertEquals("(==== С повидлом ====)", split[2]);
        Assert.assertEquals("", split[3]);
        Assert.assertEquals("Price: 3,140000", split[4]);
    }
}
