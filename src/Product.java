public class Product {
    private String name;
    private int price;
    private String explain;
    private int stock;

    public Product(String name, int price, String explain, int stock) {
        this.name = name;
        this.price = price;
        this.explain = explain;
        this.stock = stock;
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

}
