package hello.core.member;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component //이거 하나만 있으면, 자동으로 스프링 빈에 등록됨.
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>(); //데이터 저장소

    @Override
    public void save(Member member) { //회원 저장 로직
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
