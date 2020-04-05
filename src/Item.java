public class Item implements Comparable<Item> {
    String name;
    SaleState state;
    int mass;
    int quantity;

    public Item(String name, SaleState state, int mass, int quantity) {
        if (name == null) throw new IllegalArgumentException("name");
        if (Double.isNaN(mass)) throw new IllegalArgumentException("masa");
        if (Double.isNaN(quantity)) throw new IllegalArgumentException("ilosc");

        this.name = name;
        this.state = state;
        this.mass = mass;
        this.quantity = quantity;

    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public SaleState getState() {
        return state;
    }

    public void setState(SaleState state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void summary() {
        System.out.println();
        printNameInfo();
        printSaleStateInfo();
        printMassInfo();
        printQuantityInfo();
    }

    private void printNameInfo() {
        System.out.println("Nazwa towaru: " + name);
    }

    private void printSaleStateInfo() {
        System.out.println("Status sprzedaży: " + state);
    }

    private void printMassInfo() {
        System.out.println("Masa towaru: " + mass);
    }

    private void printQuantityInfo() {
        System.out.println("Ilość towaru: " + quantity);
    }


    @Override
    public int compareTo(Item item) {
        if (this == null && item == null) return 0;
        if (this == null && item != null) return -1;
        if (item == null && this != null) return 1;

        return this.name.compareTo(item.name);
    }
}
