import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class InvoiceFrame extends JFrame {

    JPanel mainPanel;

    JLabel productLabel;
    JPanel productPanel;
    JComboBox productCombo;

    JLabel quantityLabel;
    JTextField quantityTF;

    JPanel centerPanel;
    JTextField addressTF;
    JLabel addressLabel;

    JPanel bottomPanel;
    JButton addProductToInvoice;
    JButton getInvoice;
    Invoice invoice;
    Product product;

    public InvoiceFrame() {
        invoice = new Invoice();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        createProductPanel();
        mainPanel.add(productPanel, BorderLayout.NORTH);

        createCenterPanel();
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        createBottomPanel();
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);


        add(mainPanel);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void createCenterPanel() {
        centerPanel = new JPanel();
        addressTF = new JTextField(30);
        addressLabel = new JLabel("Address:");
        centerPanel.add(addressLabel);
        centerPanel.add(addressTF);


    }

    private void createBottomPanel() {
        bottomPanel = new JPanel();
        addProductToInvoice = new JButton("Add Product to Invoice");
        getInvoice = new JButton("Get Invoice");

        addProductToInvoice.addActionListener((ActionEvent ae) -> {
            if (productCombo.getSelectedItem().toString().equals("Hammer")) {
                product = new Product("Hammer", 12.50);
            }
            if (productCombo.getSelectedItem().toString().equals("Nail")) {
                product = new Product("Nail", .85);
            }
            if (productCombo.getSelectedItem().toString().equals("Screw")) {
                product = new Product("Screw", 1.25);
            }
            LineItem lineItem = new LineItem(Integer.parseInt(quantityTF.getText()), product);

            invoice.addLineItem(lineItem);
        });

        getInvoice.addActionListener((ActionEvent ae) -> {
            invoice.setAddress(addressTF.getText());
            double amount = 0;
            for (LineItem tempItem : invoice.getLineItems()) {
                amount += tempItem.getAmount();
            }
            invoice.setAmountDue(amount);
            System.out.println("\n\nINVOICE\n--------------------");
            System.out.println("Address: " + invoice.getAddress());
            System.out.println("======================\n");
            System.out.println("Item \t   Qty \t    Price \t   Total");
            for (LineItem tempItem : invoice.getLineItems()) {
                System.out.println(tempItem.getProduct().getProductName()
                        + "\t\t" + tempItem.getQuantity() + "\t\t" + tempItem.getProduct().getUnitPrice() + "\t\t" + tempItem.getAmount());
            }
            System.out.println("======================\n");
            System.out.println("Total: \t " + "$" + invoice.getAmountDue());
        });
        bottomPanel.add(addProductToInvoice);
        bottomPanel.add(getInvoice);
    }


    private void createProductPanel() {
        productPanel = new JPanel();
        productCombo = new JComboBox();
        productLabel = new JLabel();
        quantityLabel = new JLabel();
        productCombo.addItem("Nail");
        productCombo.addItem("Hammer");
        productCombo.addItem("Screw");

        productLabel.setText("Product:");
        quantityLabel.setText("Quantity:");
        quantityTF = new JTextField( 2);
        productPanel.add(productLabel);
        productPanel.add(productCombo);

        productPanel.add(quantityLabel);
        productPanel.add(quantityTF);
    }


}
