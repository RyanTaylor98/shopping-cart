package shoppingbasket;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;


public class gui extends javax.swing.JFrame {

  // variables
  private JButton Add;
  private JButton Close;
  private JTextField itemsTotals;
  private JButton removeButton;
  private JButton SaveButton;
  private JTextField totalField;
  private JButton clearButton;
  private JButton editButton;
  private JFrame jFrame1;
  private JLabel jLabel1;
  private JLabel jLabel2;
  private JLabel jLabel3;
  private JLabel jLabel4;
  private JLabel jLabel5;
  private JList<String> jList1;
  private JScrollPane jScrollBar1;
  private JScrollPane jScrollBar2;
  private JTextPane nameField;
  private JTextField priceField;
  private JSpinner quantityField;

  public ShoppingBasket shoppingCart;

  /**
   * Creates new form UI
   */
  public gui() {
    shoppingCart = new ShoppingBasket();
    Boolean valid = shoppingCart.ValidateMember("1154");
    initComponents();
  }


  private void initComponents() {

    // declaring components
    jFrame1 = new JFrame();
    jLabel1 = new JLabel();
    nameField = new JTextPane();
    quantityField = new JSpinner();
    jLabel2 = new JLabel();
    jLabel3 = new JLabel();
    priceField = new JTextField();
    Add = new JButton();
    removeButton = new JButton();
    editButton = new JButton();
    clearButton = new JButton();
    SaveButton = new JButton();
    Close = new JButton();
    jLabel4 = new JLabel();
    jLabel5 = new JLabel();
    jScrollBar1 = new JScrollPane();
    jScrollBar2 = new JScrollPane();
    jList1 = new JList(new DefaultListModel());
    itemsTotals = new JTextField();
    totalField = new JTextField();

    GroupLayout jFrame1Layout = new GroupLayout(jFrame1.getContentPane());
    jFrame1.getContentPane().setLayout(jFrame1Layout);
    //TODO: pull products from datbase
    jFrame1Layout.setHorizontalGroup(
        jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
    );
    jFrame1Layout.setVerticalGroup(
        jFrame1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
    );

    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setTitle("Shopping Basket");
    setPreferredSize(new Dimension(550, 400));
    setResizable(false);

    jLabel1.setText("Product Name");

    Add.setText("Add");
    Add.setMaximumSize(new Dimension(100, 28));
    Add.setMinimumSize(new Dimension(100, 28));
    Add.setPreferredSize(new Dimension(90, 28));
    Add.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        AddActionPerformed(event);
      }
    });

    // Setting fields and layout
    nameField.setFont(new Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
    jScrollBar1.setViewportView(nameField);

    quantityField.setFont(new Font("Arial Rounded MT Bold", 0, 13)); // NOI18N

    jLabel2.setText("Qty");

    jLabel3.setText("Latest Price");

    priceField.setFont(new Font("DejaVu Sans Mono", 0, 13)); // NOI18N

    // remove listener
    removeButton.setText("Remove");
    removeButton.setMaximumSize(new Dimension(90, 28));
    removeButton.setMinimumSize(new Dimension(90, 28));
    removeButton.setPreferredSize(new Dimension(90, 28));
    removeButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        RemoveButtonActionPerformed(event);
      }
    });

    // edit listener
    editButton.setText("Edit");
    editButton.setMaximumSize(new Dimension(90, 28));
    editButton.setMinimumSize(new Dimension(90, 28));
    editButton.setPreferredSize(new Dimension(90, 28));
    editButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        editButtonActionPerformed(event);
      }
    });

    // clear listener
    clearButton.setText("Clear");
    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        clearButtonActionPerformed(event);
      }
    });

    // save listener
    SaveButton.setText("Save here");
    SaveButton.setPreferredSize(new Dimension(90, 28));
    SaveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        SaveButtonActionPerformed(event);
      }
    });

    // exit listener
    Close.setText("Exit");
    Close.setMaximumSize(new Dimension(90, 28));
    Close.setMinimumSize(new Dimension(90, 28));
    Close.setPreferredSize(new Dimension(90, 28));
    Close.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        CloseActionPerformed(event);
      }
    });

    jLabel4.setText("No Items:");

    jLabel5.setText("Total:");

    jList1.setLayoutOrientation(jList1.VERTICAL);
    jList1.setVisibleRowCount(1);
    jList1.setSelectionMode(1);

    jList1.setFont(new Font("Arial Rounded MT Bold", 0, 13));
    jList1.setModel(jList1.getModel());
    jScrollBar2.setViewportView(jList1);

    itemsTotals.setFont(new Font("Arial Rounded MT Bold", 0, 13));
    itemsTotals.setText("0");

    totalField.setFont(new Font("Arial Rounded MT Bold", 0, 13));
    totalField.setText("�0.00");

    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollBar1)
                            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 86,
                                GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(priceField, GroupLayout.PREFERRED_SIZE, 82,
                                GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollBar2, GroupLayout.PREFERRED_SIZE, 372,
                                GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(itemsTotals, GroupLayout.PREFERRED_SIZE, 40,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalField, GroupLayout.PREFERRED_SIZE, 100,
                                    GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(Add, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(removeButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(editButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(SaveButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(Close, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                        Short.MAX_VALUE)
                    .addComponent(clearButton, GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addContainerGap())
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(Add, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(removeButton, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(editButton, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearButton)
                        .addGap(18, 18, 18)
                        .addComponent(SaveButton, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(Close, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING,
                        layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(totalField, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout
                                            .createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(quantityField, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priceField, GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollBar1, GroupLayout.PREFERRED_SIZE,
                                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollBar2, GroupLayout.PREFERRED_SIZE, 200,
                                    GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(
                                        layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                    .addComponent(itemsTotals, GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))))
    );

    pack();
  }

  // update functionality
  public void updateList(JList list) {
    DefaultListModel listModel = (DefaultListModel) list.getModel();
    listModel.clear();
    ArrayList Basket = new ArrayList();
    shoppingCart.getShoppingItems().forEach((shoppingbasket.OrderItem item) -> {
      if (item.getQuantity() != 0) {
        Basket.add(String.format("%1$-18s|%2$-6s|%3$-8s|%4$-8s|",
            (item.getProductName()),
            (item.getQuantity()),
            (String.format("�%.2f", (item.getLatestPrice()))),
            (String.format("�%.2f", ((item.getQuantity() * item.getLatestPrice()))))));
      }
    });

    for (int i = 0; i < Basket.size(); i++) {
      listModel.addElement((String) Basket.get(i));
    }
    shoppingCart.calcBill();
    totalField.setText(String.valueOf((String.format("�%.2f", shoppingCart.BillTotal()))));
    itemsTotals.setText(String.valueOf(Basket.size()));
  }

  // remove functionality
  public void removeList(JList list, int index) {
    if (index == -1 && !shoppingCart.getShoppingItems().isEmpty()) {
    } else if (!shoppingCart.getShoppingItems().isEmpty()) {
      shoppingCart.getShoppingItems().remove(index);
    }
    updateList(list);
  }

  // edit functionality
  public void editList(JList list, int index) {
    try {
      if (index >= 0) {
        int Quantity = (Integer) quantityField.getValue();
        String sPrice = priceField.getText();
        Double.parseDouble(sPrice);
        double Price = Double.parseDouble(sPrice);
        if (Quantity >= 0) {
          shoppingCart.getShoppingItems().get(index).setLatestPrice(Price);
          shoppingCart.getShoppingItems().get(index).setQuantity(Quantity);
          updateList(list);
        } else {
          JOptionPane
              .showMessageDialog(jFrame1, "Please check you are entering valid data.", "Input",
                  JOptionPane.WARNING_MESSAGE);
        }
      }
    } catch (NumberFormatException e) {
      JOptionPane.showMessageDialog(jFrame1, "Please check you are entering valid data.", "Input",
          JOptionPane.WARNING_MESSAGE);
    }
  }


  // Add performer
  private void AddActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_AddActionPerformed
    String Name = nameField.getText();
    if (!Name.isEmpty()) {
      try {
        int Quantity = (Integer) quantityField.getValue();
        String sPrice = priceField.getText();
        Double.parseDouble(sPrice);
        double Price = Double.parseDouble(sPrice);
        if (Quantity > 0) {
          // TODO: set the ref to come from db or interface
          OrderItem orderItem = new OrderItem(Name, Quantity, Price, "F001");
          shoppingCart.addShoppingItem(orderItem);
          updateList(jList1);
        }
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(jFrame1, "Please check you are entering valid data.", "Input",
            JOptionPane.WARNING_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(jFrame1, "Please check you are entering valid data.", "Input",
          JOptionPane.WARNING_MESSAGE);
    }
  }

  // close performer
  private void CloseActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_CloseActionPerformed
    System.exit(0);
  }

  // edit button performer
  private void editButtonActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_editButtonActionPerformed
    editList(jList1, jList1.getSelectedIndex());
  }

  // clear button performer
  private void clearButtonActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_clearButtonActionPerformed
    //shoppingCart.clear();
    updateList(jList1);
  }

  // remove button performer
  private void RemoveButtonActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_RemoveButtonActionPerformed
    removeList(jList1, jList1.getSelectedIndex());
  }

  private void SaveButtonActionPerformed(
      java.awt.event.ActionEvent event) {//GEN-FIRST:event_SaveButtonActionPerformed
//    try {
//      //shoppingCart.file();
//    } catch (IOException ex) {
//      Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
//    }
  }

  public static void main(String args[]) {

    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
      Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
    }

    EventQueue.invokeLater(() -> {
      new gui().setVisible(true);
    });
  }

}