

import java.util.ArrayList;
import java.util.List;

public class DataGenerator {
    public static List<FulfillmentCenter> getMagazinesData() {
        List<FulfillmentCenter> magazines = new ArrayList<>();
        magazines.add(new FulfillmentCenter("Mały magazyn", "Paszyn", 1500));
        magazines.add(new FulfillmentCenter("KELLY", "Londyn", 800));
        magazines.get(0).addProduct(new Item("książka", SaleState.SOLD, 20, 3));
        magazines.get(0).addProduct(new Item("plecak", SaleState.IN_THE_WAREHOUSE, 40, 3));
        magazines.get(1).addProduct(new Item("drzwi", SaleState.SOLD, 50, 10));

        return magazines;
    }

}