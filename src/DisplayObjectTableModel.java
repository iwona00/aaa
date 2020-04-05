

import java.util.List;

public class DisplayObjectTableModel extends CustomTableModel<FulfillmentCenter> {

    public DisplayObjectTableModel() {
        super();
    }

    public DisplayObjectTableModel(List<FulfillmentCenter> rows) {
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
        return column == 0 ? "Nazwa magazynu" : "Max masa magazynu";
    }


}