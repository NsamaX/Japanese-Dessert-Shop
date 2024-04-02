import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    static List<Product> products = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // สร้างสินค้า
        Owner vijusksama = new Owner();
        vijusksama.addProduct("dessert", "มัทฉะ โดรายากิ", 4.00);
        vijusksama.addProduct("dessert", "ไอศกรีมโมจิ", 4.00);
        vijusksama.addProduct("dessert", "อันมิทสึ", 5.00);
        vijusksama.addProduct("dessert", "ไทยากิ", 5.15);
        vijusksama.addProduct("drink", "มัทฉะ ลาเต้", 6.50);
        vijusksama.addProduct("drink", "ชานมโฮจิชะ", 7.50);
        vijusksama.addProduct("drink", "โยซุโดะ", 3.75);
        vijusksama.addProduct("drink", "สมูทตี้ชีระ", 5.00);
        vijusksama.addProduct("drink", "ไวน์อูเมะชู", 10.00);
        // ความสามารถของระบบ
        MenuView menu = new MenuView();
        OrderController order = new OrderController();
        MemberManagement member = new MemberManagement();
        // เริ่มการทำงานของโปรแกรม
        System.out.println("ขอบคุณที่เยี่ยมชมร้านของเราค่ะ");
        System.out.println("มีบริการอะไรที่จะช่วยคุณได้บ้างคะ?");
        boolean running = true;
        while (running) {
            displayOptions();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("ขอบคุณที่ใช้บริการค่ะ >///<");
                    running = false;
                    break;
                case 1:
                    System.out.println("[1] ขนม");
                    System.out.println("[2] เครื่องดื่ม");
                    choice = scanner.nextInt();
                    menu.displayMenu(choice);
                    break;
                case 2:
                    System.out.println("คุณต้องการสินค้าอะไรหรอคะ?");
                    String productName = scanner.nextLine();
                    Product p = menu.getProductByName(productName);
                    if (p == null) {
                        break;
                    }
                    System.out.println("คุณต้องการจำนวนเท่าไรคะ?");
                    int quantity = scanner.nextInt();
                    if (quantity < 1) {
                        System.out.println("ทางร้านเราไม่สามารถทำได้ค่ะ");
                        break;
                    }
                    order.addToCart(p, quantity);
                    break;
                case 3:
                    if (order.getStatus() == false) {
                        break;
                    }
                    Member m;
                    System.out.println("คุณมีสมาชิกมั้ยคะ?");
                    System.out.println("[1] มี");
                    System.out.println("[2] ไม่มี");
                    int answer = scanner.nextInt();
                    scanner.nextLine();
                    if (answer == 2) {
                        System.out.println("คุณต้องการสมัครสมาชิกไหมคะ?");
                        System.out.println("[1] ต้องการ");
                        System.out.println("[2] ไม่ต้องการ");
                        int registerChoice = scanner.nextInt();
                        scanner.nextLine();
                        if (registerChoice == 1) {
                            m = registMember(member);
                        } else {
                            m = null;
                        }
                    } else {
                        System.out.println("โปรดระบุชื่อสมาชิกของคุณค่ะ");
                        String name = scanner.nextLine();
                        m = member.findMember(name);
                    }
                    System.out.println("กำลังชำระเงินค่ะ...");
                    order.pay(m);
                    break;
                case 4:
                    System.out.println("กำลังยกเลิกการสั่งซื้อค่ะ...");
                    order.cancel();
                    break;
                case 5:
                    registMember(member);
                    break;
                default:
                    System.out.println("กรุณาเลือกตัวเลือกที่ถูกต้องค่ะ");
            }
        }
        scanner.close();
    }
    private static void displayOptions() {
        System.out.println("*****************");
        System.out.println("[0] ออกจากโปรแกรม");
        System.out.println("[1] ดูเมนู");
        System.out.println("[2] เลือกสินค้า");
        System.out.println("[3] ชำระเงิน");
        System.out.println("[4] ยกเลิกการสั่งซื้อ");
        System.out.println("[5] สมัครสมาชิก");
        System.out.println("*****************");
    }
    private static Member registMember(MemberManagement member) {
        System.out.println("โปรดระบุชื่อของคุณค่ะ:");
        String name = scanner.nextLine();
        member.addMember(name);
        System.out.println("สมัครสมาชิกเรียบร้อยค่ะ!");
        return member.findMember(name);
    }
}
