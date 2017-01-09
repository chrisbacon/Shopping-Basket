import java.util.*;

public class ShoppingBasket {
    private ArrayList<Shoppable> items;

    public ShoppingBasket() {
        this.items = new ArrayList<Shoppable>();
    }

    public int getSize() {
        return items.size();
    }

    public void add(Shoppable item) {
        items.add(item);
    }

    public Shoppable removeLastItem() {
        Shoppable foundItem = null;
        if (getSize()-1 >= 0) {
            foundItem = items.remove(getSize() - 1);
        }
        return foundItem;
    }

    public Shoppable removeItemByID(int id) {
        Shoppable foundItem = null;
        for (Shoppable item : items) {
            if (item.getID() == id) {
                items.remove(item);
                foundItem = item;
            }
        }
        return foundItem;
    }
}