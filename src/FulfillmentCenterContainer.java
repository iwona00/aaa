import java.util.*;

public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> store = new HashMap<>();

    public Map<String, FulfillmentCenter> getStore() {
        return store;
    }

    public void addCenter(String name, String place, int maxMass) {
        if (name == null) throw new IllegalArgumentException();
        if (Double.isNaN(maxMass)) throw new IllegalArgumentException();
        if (place == null) throw new IllegalArgumentException();
        store.put(name, new FulfillmentCenter(name, place, maxMass));
    }

    public void removeCenter(String storeName) {
        if (storeName == null) throw new IllegalArgumentException("fulfillmentCenter");

        if (!storeName.contains(storeName)) System.err.println("Brak magazynu o podanej nazwie.");
        store.remove(storeName);
    }


    public void summary() {
        for (Map.Entry<String, FulfillmentCenter> fulfillmentCenterKeyValuePair : store.entrySet()) {
            FulfillmentCenter center = fulfillmentCenterKeyValuePair.getValue();
            center.summary();
            System.out.println();
        }
    }


    private void sort() {
        List<Map.Entry<String, FulfillmentCenter>> list = new ArrayList<Map.Entry<String, FulfillmentCenter>>(store.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, FulfillmentCenter>>() {
            @Override
            public int compare(Map.Entry<String, FulfillmentCenter> stringFulfillmentCenterEntry, Map.Entry<String, FulfillmentCenter> t1) {
                return 0;
            }
        });

    }


}
