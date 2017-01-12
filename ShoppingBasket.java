import java.util.*;

public class ShoppingBasket {
    private ArrayList<Shoppable> items;
    private boolean loyal;

    public ShoppingBasket() {
        this.items = new ArrayList<Shoppable>();
        loyal = false;
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

    private boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    private double loyaltyDiscount() {
        double discount = 1.00;
        if (isLoyal()) {
            discount = 0.98;
        }
        return discount;
    }

    private double bogofDiscount() {

        HashMap<Shoppable,Integer> counts = new HashMap<Shoppable, Integer>();

        double discount = 0;

        for (Shoppable item : items) {
            if (counts.containsKey(item)) {
                int next = counts.get(item) + 1;

                if (next % 2 == 0) {
                    discount += item.getPrice();
                }

                counts.put(item, next);

            } else {
                counts.put(item, 1);
            }
        }

        return discount;
    }

    private double overTwentyDiscount(double total) {

        if (total > 20.00) {
            total *= 0.9;
        }

        return total;
    }

    public double getTotalPrice() {
        double total = 0;

        for (Shoppable item : items) {
            total += item.getPrice();
        }

        return loyaltyDiscount()*overTwentyDiscount(total - bogofDiscount());
    }
}