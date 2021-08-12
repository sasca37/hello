package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    //1. 자기 자신을 static 영역으로 가지면 객체가 하나만 존재
    private static final MemberRepository instance = new MemberRepository();

    //2. public 으로 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회되도록 한다.
    public static MemberRepository getInstance() {
        return instance;
    }
    //3. 외부에서 new 연산자로 객체 생성하는 것을 막는다.
    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
