import static org.junit.Assert.*;
import org.junit.*;

import org.mockito.*;
import static org.mockito.Mockito.*;

public class ShoppingBasketTest{
  ShoppingBasket basket;
  Shoppable item;

  @Before 
  public void before() {
    basket = new ShoppingBasket ();
    item = mock(Shoppable.class);
  }

  @Test
  public void addTest() {
    basket.add(item);
  }
}