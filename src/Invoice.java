import java.util.ArrayList;

public class Invoice {
    private String address;
    private double amountDue;
    private ArrayList<LineItem> lineItems;

    public Invoice(String address, double amountDue, ArrayList<LineItem> lineItems) {
        this.address = address;
        this.amountDue = amountDue;
        this.lineItems = lineItems;
    }
    public Invoice() {
        lineItems = new ArrayList<LineItem>();
    }
    public void addLineItem(LineItem item) {
        lineItems.add(item);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(ArrayList<LineItem> lineItems) {
        this.lineItems = lineItems;
    }
}
