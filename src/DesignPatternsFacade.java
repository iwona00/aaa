import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DesignPatternsFacade {


    public static void main(String[] args) {

        MainApi mainApi = new MainApi();
        mainApi.createListOftheProducts();
        mainApi.printListOfProducts();
        mainApi.createFulfillmentcenter();
        mainApi.addProductsToMagazine();
        mainApi.addNewMagazines();
        mainApi.displayInfoAboutMagazines();


    }


}
