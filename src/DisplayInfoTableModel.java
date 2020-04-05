

import java.util.List;

public class DisplayInfoTableModel extends CustomTableModel<FulfillmentCenter> {

    public DisplayInfoTableModel() {
        super();
    }

    public DisplayInfoTableModel(List<FulfillmentCenter> rows) {
        super(rows);
    }

    @Override
    protected Object getValueAt(FulfillmentCenter fulfillmentCenter, int columnIndex) {
        Object tmp;
        if (columnIndex == 0) {
            tmp = fulfillmentCenter.getNameOfMagazine();
        } else if (columnIndex == 1) {
            tmp = fulfillmentCenter.getMaxMassOfMagazine();
        } else if (columnIndex == 2) tmp = fulfillmentCenter.getPlace();
        return fulfillmentCenter.getNameOfMagazine();
    }


    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) return "Nazwa magazynu";
        else if (column == 1) return "Max masa magazynu";
        else return "Miejscowość";

    }


}
