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

    item2 = mock(Shoppable.class);
    when(item2.getID()).thenReturn(223);
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
}