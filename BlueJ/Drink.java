public class Drink extends Product {
    public Drink(String name, double price) {
        super(name, price);
    }
    @Override
    public void productInfo() {
        System.out.println("=================");
        System.out.println("ประเภท : เครื่องดื่ม");
        System.out.println("ข้อมูล [");
        System.out.println("     ชื่อ: " + getName());
        System.out.println("     ราคา: " + getPrice());
        System.out.println("]");
        System.out.println("=================");
    }
}
