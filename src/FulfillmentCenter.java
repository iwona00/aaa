import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FulfillmentCenter {
    String nameOfMagazine;
    String place;
    int maxMassOfMagazine;
    ;
    List<Item> listOfTheProducts = new ArrayList<Item>();


    public FulfillmentCenter(String nameOfMagazine, String place, int maxMassOfMagazine) {
        if (nameOfMagazine == null) throw new IllegalArgumentException();
        if (place == null) throw new IllegalArgumentException();
        if (Double.isNaN(maxMassOfMagazine)) throw new IllegalArgumentException();

        this.nameOfMagazine = nameOfMagazine;
        this.place = place;
        this.maxMassOfMagazine = maxMassOfMagazine;

    }

    public String getNameOfMagazine() {
        return nameOfMagazine;
    }

    public void setNameOfMagazine(String nameOfMagazine) {
        this.nameOfMagazine = nameOfMagazine;
    }

    public List<Item> getListOfTheProducts() {
        return listOfTheProducts;
    }

    public void setListOfTheProducts(List<Item> listOfTheProducts) {
        this.listOfTheProducts = listOfTheProducts;
    }

    public int getMaxMassOfMagazine() {
        return maxMassOfMagazine;
    }

    public void setMaxMassOfMagazine(int maxMassOfMagazine) {
        this.maxMassOfMagazine = maxMassOfMagazine;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void addProduct(Item item) {
        if (item == null) throw new IllegalArgumentException("item");

        if (isMassExceeded(item)) {
            System.setErr(System.out);
            System.err.println("Nie można dodać towaru: " + item.name);
            System.err.println("Została przekroczona maksymalna pojemność magazynu.");
            System.out.println();
            return;
        } else {
            listOfTheProducts.add(item);
            System.out.println("Pomyślnie dodano towar: " + item.name);
        }
    }

    public void removeProduct(Item item) {
        if (item == null) throw new IllegalArgumentException("item");
        if (!listOfTheProducts.contains(item)) {
            System.err.println("Nie można usunąć nieistniejącego produktu.");
            return;
        }

        int index = listOfTheProducts.indexOf(item);
        Item currentItem = listOfTheProducts.get(index);
        listOfTheProducts.remove(index);
    }


    public long filterByState(SaleState state) {
        return listOfTheProducts
                .stream()
                .filter(item -> item.state == state)
                .map(item -> item.quantity)
                .reduce(0, Integer::sum);
    }

    public void filterByProduct() {
        Collections.sort(listOfTheProducts);
        System.out.println("\nPoszukiwane produkty:  ");
        for (Item item : listOfTheProducts) {
            System.out.println(item.name);
        }
    }

    public int actualFulfillment(int maxMassOfMagazine) {
        if (maxMassOfMagazine <= 0) throw new ArithmeticException();
        return (getCurrentProductMass() / maxMassOfMagazine) * 100;
    }


    public void summary() {
        System.out.println();
        printNameInfo();
        printPlaceInfo();
        printMaxMassInfo();
        printActualFulfillmentInfo();
    }

    private void printNameInfo() {
        System.out.println("Nazwa magazynu: " + nameOfMagazine);
    }

    private void printPlaceInfo() {
        System.out.println("Miejscowość: " + place);
    }

    private void printMaxMassInfo() {
        System.out.println("Maksymalne obciążenie magazynu: " + maxMassOfMagazine);
    }

    private void printActualFulfillmentInfo() {
        System.out.println("Aktualne wypełnienie: " + actualFulfillment(maxMassOfMagazine) + "%");
    }


    public int getCurrentProductMass() {
        if (listOfTheProducts != null) {
            return listOfTheProducts
                    .stream()
                    .map(item -> item.mass * item.quantity)
                    .reduce(0, Integer::sum);
        } else return 0;
    }

    private boolean isMassExceeded(Item item) {
        return getCurrentProductMass() + (item.mass * item.quantity) > maxMassOfMagazine;
    }


}
