import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Database;
import praktikum.Ingredient;
import praktikum.Database;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    Database database = new Database();
    @Mock
    Ingredient ingredients;
    @Mock
    Bun bun;
    @Spy
    Burger burger;

    @Test
    public void testSetBuns(){
        List<Bun> buns = database.availableBuns();
        burger.setBuns(buns.get(0));
        Mockito.verify(burger).setBuns(buns.get(0));
        int x = 8000;
        Mockito.when(buns.get(0)).thenReturn(buns.get(x));
        Assert.assertEquals(burger.setBuns(buns.get(x)), burger.setBuns(buns.get(0)));
    }
    @Test
    public void testAddIngredient(){

    }
    @Test
    public void testGetPrice(){
        Burger burger = new Burger(bun, List.of(ingredients));
        Mockito.when(bun.getPrice()).thenReturn(3.14f);
        Mockito.when(ingredients.getPrice()).thenReturn(3.15f);
        Assert.assertTrue(9.43f == burger.getPrice());
    }
}
