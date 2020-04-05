import java.util.ArrayList;
import java.util.List;


public class MainApi {

    // creating a list of the products
    Item item1 = new Item("ksiazka", SaleState.ORDERED, 5, 1);
    Item item2 = new Item("plecak", SaleState.IN_THE_WAREHOUSE, 12, 4);
    Item item3 = new Item("walizka", SaleState.SOLD, 30, 15);
    Item item4 = new Item("deskorolka", SaleState.SOLD, 15, 3);
    Item item5 = new Item("rower", SaleState.ORDERED, 20, 7);

    ArrayList<Item> avalaibleProducts = new ArrayList<Item>();
    FulfillmentCenterContainer centrumMagazynowe = new FulfillmentCenterContainer();
    FulfillmentCenter magazyn = new FulfillmentCenter("Mały Magazyn", "Wrocław", 500);


    public void createListOftheProducts() {
        avalaibleProducts.add(item1);
        avalaibleProducts.add(item2);
        avalaibleProducts.add(item3);
        avalaibleProducts.add(item4);
        avalaibleProducts.add(item5);
    }


    // wyświetlenie listy dostępnych przedmiotów

    public void printListOfProducts() {
        System.out.println("Lista dostępnych przedmiotów: ");
        for (Item item : avalaibleProducts) System.out.println(item.name);
    }


    public void createFulfillmentcenter() {

        centrumMagazynowe.store.put(magazyn.nameOfMagazine, magazyn);
    }

    public void addProductsToMagazine() {
        magazyn.addProduct(item1);
        magazyn.addProduct(item2);
        magazyn.addProduct(item3);
    }

    public void addNewMagazines() {
        centrumMagazynowe.addCenter("Stary Magazyn", "Kraków", 30);
        centrumMagazynowe.addCenter("Magazyn Oli", "Dębica", 23);
        centrumMagazynowe.addCenter("Random", "Nowy Sącz", 23);
    }

    public void displayInfoAboutMagazines() {
        System.out.println("Informacje na temat magazynów: ");
        centrumMagazynowe.summary();
    }


}
