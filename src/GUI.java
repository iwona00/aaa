

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {
    private static final String APP_TITLE = "Test Swing App";
    private JPanel mainPanel;
    private JTable magazinesTable;
    private JSplitPane mainSplitPane;
    private JPanel buttonPanel;
    private JButton addCenterButton;
    private JButton removeFulfillmentButton;
    private JButton sortCentersByCurrentButton;
    private JButton infoAboutProductButton;
    private JButton FIlterTextboxButton;
    private JComboBox comboBox1;
    private JButton addNewProductButton;
    private JButton removeProductButton;
    private JScrollPane tablePane;
    private JTable table2;
    private JScrollPane productPane;
    private JTable infoAboutCenterTable;
    private JPanel tablePanel;
    private JTable productsTable;
    private JLabel label1;
    private JTextField textfield1;
    private JFrame frame;

    private DisplayObjectTableModel magazinesModel;
    private List<FulfillmentCenter> list;
    private DisplayInfoTableModel centerModel;

    public GUI() {
        frame = new JFrame();

        magazinesModel = new DisplayObjectTableModel(DataGenerator.getMagazinesData());
        magazinesTable = new JTable(magazinesModel);
        tablePane.setViewportView(magazinesTable);
        infoAboutCenterTable = new JTable(new DisplayObjectTableModel(DataGenerator.getMagazinesData()));

        magazinesTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        infoAboutCenterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);


        addCenterButton.addActionListener(this::addCenterButtonActionPerformed);
        removeFulfillmentButton.addActionListener(this::removeCenterButtonActionPerformed);
        addNewProductButton.addActionListener(this::addProductButtonActionPerformed);


        magazinesTable.addMouseListener
                (
                        new MouseAdapter() {
                            public void mouseClicked(MouseEvent e) {
                                magazinesTable = (JTable) e.getSource();
                                int row = magazinesTable.rowAtPoint(e.getPoint());
                                int column = magazinesTable.columnAtPoint(e.getPoint());
                                String s = "Informacje na temat magazynu: ";
                                String s1 = "NAZWA: " + infoAboutCenterTable.getModel().getValueAt(row, 0) + "";
                                String s2 = "MASA: " + infoAboutCenterTable.getModel().getValueAt(row, 1) + "";
                                //String s=infoAboutCenterTable.getModel().getValueAt(row, column)+"";

                                JOptionPane.showMessageDialog(null, s + "\n" + s1 + "\n" + s2);
                                DisplayProductTableModel model = new DisplayProductTableModel(DataGenerator.getMagazinesData());
                                productsTable = new JTable(model);
                                model.addRow(new FulfillmentCenter("i", "j", 23));
                                productPane = new JScrollPane(productsTable);
                                productPane.setViewportView(productsTable);


                            }
                        }
                );


        add(mainPanel);
        pack();
        setVisible(true);
        setMinimumSize(new Dimension(800, 600));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(APP_TITLE);
        mainPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                "List of fulfillment centers: ",
                TitledBorder.LEFT,
                TitledBorder.TOP));

    }


    private void addCenterButtonActionPerformed(ActionEvent actionEvent) {
        String tekst = JOptionPane.showInputDialog("Podaj nazwę magazynu: ");
        String tekst1 = JOptionPane.showInputDialog("Podaj maksymalną masę magazynu: ");
        String tekst2 = JOptionPane.showInputDialog("Podaj miejscowość: ");


        int a = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz dodać magazyn " + tekst + "?", "Tytuł okienka", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(a);
        JOptionPane.showMessageDialog(null, "Magazyn został dodany");
        magazinesModel.addRow(new FulfillmentCenter(tekst, tekst2, Integer.parseInt(tekst1)));
        magazinesModel.fireTableDataChanged();

    }

    private void addProductButtonActionPerformed(ActionEvent actionEvent) {
        String tekst = JOptionPane.showInputDialog("Podaj nazwę produktu: ");
        String tekst1 = JOptionPane.showInputDialog("Podaj masę produktu: ");
        String tekst2 = JOptionPane.showInputDialog("Podaj ilość produktu:  ");


        int a = JOptionPane.showConfirmDialog(null, "Czy na pewno chcesz dodać produkt " + tekst + "?", "Tytuł okienka", JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println(a);
        JOptionPane.showMessageDialog(null, "Produkt został dodany");

    }


    private static void openDialog(Frame f) {
        JPanel panel = new JPanel();
        final JTextField text = new JTextField(10);
        final JLabel label = new JLabel("NAZWA");
        final JDialog dialog = new JDialog(f, "Adding magazine", true);
        final JButton button = new JButton("Dodaj");
        panel.add(label, BorderLayout.WEST);
        panel.add(text, BorderLayout.CENTER);

        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setLabelFor(text);


        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println(button.getActionCommand());
                dialog.dispose();
            }
        });

        panel.add(button);
        panel.add(text);
        panel.add(label);


        JButton[] buttons = {button};
        JOptionPane optionPane = new JOptionPane(panel,
                JOptionPane.YES_NO_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null, buttons, button);
        dialog.getContentPane().add(optionPane);
        dialog.setSize(300, 300);
        dialog.setLocationRelativeTo(f);
        dialog.setVisible(true);
    }

    private void removeCenterButtonActionPerformed(ActionEvent actionEvent) {
        if (magazinesTable.getSelectedRow() != -1) {
            // remove selected row from the model
            magazinesModel.deleteRow(magazinesTable.getSelectedRow());
        }

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        //magazinesTable = new JTable(new DisplayObjectTableModel(DataGenerator.getMagazinesData()));
        //list = new ArrayList<>();
        //magazinesModel = new DisplayObjectTableModel(list);
        //magazinesTable = new JTable(productModel);

    }

}

