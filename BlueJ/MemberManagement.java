import java.util.List;
import java.util.ArrayList;
public class MemberManagement {
    private List<Member> members;
    public MemberManagement() {
        this.members = new ArrayList<>();
    }
    public void addMember(String name) {
        Member newMember = new Member(name);
        members.add(newMember);
    }
    public Member findMember(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        System.out.println("ทางเราไม่เจอสมาชิกของคุณลูกค้าค่ะ");
        return null;
    }
}
