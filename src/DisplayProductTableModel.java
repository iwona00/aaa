

import java.util.List;

public class DisplayProductTableModel extends CustomTableModel<FulfillmentCenter> {

    public DisplayProductTableModel() {
        super();
    }

    public DisplayProductTableModel(List<FulfillmentCenter> rows) {
        super(rows);
    }

    @Override
    protected Object getValueAt(FulfillmentCenter fulfillmentCenter, int columnIndex) {
        Object tmp;
        if (columnIndex == 0) {
            tmp = fulfillmentCenter.getNameOfMagazine();
        } else
            tmp = fulfillmentCenter.getMaxMassOfMagazine();
        return tmp;
    }


    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        return column == 0 ? "Lista produktów w wybranym magazynie" : "Nazwa magazynu";
    }


}
