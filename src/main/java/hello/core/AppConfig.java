package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//OCP, DIP 위한 설정? 클래스 -> 구현 객체를 생성과 연결하는 역할을 함. -> DIP 완성
public class AppConfig { //IoC 컨테이너, DI 컨테이너 의존관계 주입

    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(memberRepository()); //객체 생성과 동시에 참조값 주입(의존 관계 주입)
    }

    private MemberRepository memberRepository(){ //역할
        return new MemoryMemberRepository(); //구현
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); //아래 코드로 변경 -> 변경이 쉬움
        return new RateDiscountPolicy();
    }
}
