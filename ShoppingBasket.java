import java.util.*;

public class ShoppingBasket {
    private ArrayList<Shoppable> items;

    public ShoppingBasket() {
        this.items = new ArrayList<Shoppable>();
    }

    public int getSize() {
        return items.size();
    }

    // public void add(Shoppable item) {
    //     items.add(item);
    // }
}