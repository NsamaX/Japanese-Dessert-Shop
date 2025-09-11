public class ProductFactory implements Factory {
    @Override
    public Product createProduct(String type, String name, double price) {
        if (type.equalsIgnoreCase("dessert")) {
            return new Dessert(name, price);
        } else if (type.equalsIgnoreCase("drink")) {
            return new Drink(name, price);
        } else {
            return null;
        }
    }
}
