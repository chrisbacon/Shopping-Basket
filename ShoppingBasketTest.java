import static org.junit.Assert.*;
import org.junit.*;

import org.mockito.*;
import static org.mockito.Mockito.*;

public class ShoppingBasketTest{
  ShoppingBasket basket;
  Shoppable item;
  Shoppable item2;

  @Before 
  public void before() {
    basket = new ShoppingBasket ();

    item = mock(Shoppable.class);
    when(item.getID()).thenReturn(104);
    when(item.getPrice()).thenReturn(2.50);

    item2 = mock(Shoppable.class);
    when(item2.getID()).thenReturn(223);
    when(item2.getPrice()).thenReturn(4.50);
  }

  @Test
  public void getSizeTest() {
    assertEquals(0, basket.getSize());
  }

  @Test
  public void addTest() {
    basket.add(item);
    assertEquals(1, basket.getSize());
  }

  @Test
  public void removeLastItemTest() {
    basket.add(item2);
    basket.add(item);
    Shoppable removedItem = basket.removeLastItem();
    assertEquals(104, removedItem.getID());
  }

  @Test 
  public void removeLastItemCannotRemoveWhenEmptyTest() {
    Shoppable removedItem = basket.removeLastItem();
    assertEquals(0, basket.getSize());
    assertEquals(null, removedItem);
  }

  @Test 
  public void removeItemByIDTest() {
    basket.add(item);
    basket.add(item2);

    Shoppable removedItem = basket.removeItemByID(104);
    assertEquals(104, removedItem.getID());
  }

  @Test
  public void getTotalPriceTest() {
    basket.add(item);
    basket.add(item2);

    assertEquals(7.00, basket.getTotalPrice(), 0.001);
  }

  @Test
  public void getTotalPriceTestIfLoyalTest() {
    basket.add(item);
    basket.add(item2);

    basket.setLoyal(true);

    assertEquals(6.86, basket.getTotalPrice(), 0.001);
  }

  @Test
  public void getTotalPriceIfOverTwentyTest() {
    basket.add(item);
    basket.add(item2);

    Shoppable item3 = mock(Shoppable.class);
    when(item3.getID()).thenReturn(317);
    when(item3.getPrice()).thenReturn(14.00);

    basket.add(item3);

    assertEquals(18.90, basket.getTotalPrice(), 0.001);
  }
}