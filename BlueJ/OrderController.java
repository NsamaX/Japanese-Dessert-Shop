import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
public class OrderController {
    private List<Product[]> orderList = new ArrayList<>();
    private List<Product> productsInCart = new ArrayList<>();
    public void addToCart(Product product, int quantity) {
        for (int i = 0; i < quantity; i++) {
            productsInCart.add(product);
        }
        System.out.println(product.getName() + ": " + quantity + " ชิ้นค่ะ");
    }
    public boolean getStatus() {
        if (productsInCart.isEmpty()) {
            System.out.println("ไม่มีสินค้าในตะกร้าคะ");
        }
        return true;
    }
    public void pay(Member member) {
        double total = 0;
        for (Product product : productsInCart) {
            System.out.println(product.getName() + " - " + product.getPrice() + " ¥");
            total += product.getPrice();
        }
        if (member != null) {
            double discount = total * 0.1;
            total -= discount;
            System.out.println("ลดราคา: - " + String.format("%.2f", discount) + " ¥");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        System.out.println("ราคารวมสุทธิ: " + decimalFormat.format(total) + " ¥");
        orderList.add(productsInCart.toArray(new Product[0]));
        productsInCart.clear();
    }
    public List<Product[]> getOrderList() {
        return orderList;
    }
    public void cancel() {
        productsInCart.clear();
        System.out.println("รายการสินค้าถูกยกเลิกแล้วค่ะ");
    }
}
