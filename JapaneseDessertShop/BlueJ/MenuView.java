import java.util.List;
public class MenuView {
    public void displayMenu(int type) {
        System.out.println("=================");
        System.out.println("เมนู");
        switch (type) {
            case 1:
                System.out.println("ขนม [");
                for (Product product : Main.products) {
                    if (product instanceof Dessert) {
                        System.out.println("     " + product.getName() + " - $" + product.getPrice());
                    }
                }
                System.out.println("]");
                break;
            case 2:
                System.out.println("เครื่องดื่ม [");
                for (Product product : Main.products) {
                    if (product instanceof Drink) {
                        System.out.println("     " + product.getName() + " - $" + product.getPrice());
                    }
                }
                System.out.println("]");
                break;
            default:
                System.out.println("กรุณาเลือกตัวเลือกที่ถูกต้องค่ะ");
                break;
        }
        System.out.println("=================");
    }
    static public Product getProductByName(String productName) {
        for (Product product : Main.products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                return product;
            }
        }
        System.out.println("ชื่อสินค้าไม่ถูกต้องค่ะ");
        return null; 
    }
}
