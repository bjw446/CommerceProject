public class Product {
    private String name;
    private int price;
    private String explain;
    private int stock;
    private int count;
    private int totalPrice;

    public Product(String name, int price, String explain, int stock) {
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.stock = stock;
        this.count = count;
    }
    public int getTotalPrice() {
        return price * count;
    }
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public String getExplain() {
        return this.explain;
    }
    public int getStock() {
        return this.stock;
    }
    public int getCount() {
        return this.count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setExplain(String explain) {
        this.explain = explain;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
