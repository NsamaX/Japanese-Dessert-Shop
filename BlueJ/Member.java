import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Member {
    private String name;
    private String registDate;
    private int point = 0;

    public Member(String name) {
        this.name = name;
        this.registDate = getCurrentDate();
        memberInfo();
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getRegistDate() {
        return registDate;
    }
    public int getPoint() {
        return point;
    }
    public void memberInfo() {
        System.out.println("=================");
        System.out.println("ชื่อสมาชิก : " + getName());
        System.out.println("ข้อมูล [");
        System.out.println("     วันที่สมัคร: " + getRegistDate());
        System.out.println("     คะแนน: " + getPoint());
        System.out.println("]");
        System.out.println("=================");
    }
    // Setters
    public void setPoint(double bill) {
        double pointsToAdd;
        if (bill >= 5.0)
            pointsToAdd = (int) (bill / 5);
        else
            pointsToAdd = bill * 0.1;
        point += pointsToAdd;
    }
    // Helper method to get the current date
    private String getCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return currentDate.format(formatter);
    }
}
