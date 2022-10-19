public class LineItem {
    private double amount;
    private int quantity;
    private Product product;

    public LineItem(int quantity, Product product) {
        this.amount = amount;
        this.quantity = quantity;
        this.product = product;
    }

    public double getAmount() {
        return quantity * product.getUnitPrice();
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
