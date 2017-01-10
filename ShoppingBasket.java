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
        return 0;
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