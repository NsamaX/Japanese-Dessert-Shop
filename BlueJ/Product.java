abstract class Product {
    private String name;
    private double price;
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        System.out.println("สินค้าถูกเพิ่มแล้ว");
        productInfo();
    }
    // Getters
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public abstract void productInfo();
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
