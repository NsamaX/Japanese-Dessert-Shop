public class Owner {
    Factory factory = new ProductFactory();
    public void addProduct(String type, String name, double price){
        Main.products.add(factory.createProduct(type, name, price));
    }
    public void deleteProduct(String name) {
        Main.products.remove(MenuView.getProductByName(name));
    }
}
