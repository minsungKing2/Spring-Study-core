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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //JAVA 코드로만 구현한 DI을 Spring으로 변경함.
//Config : 설정 정보, 구성 정보 라고 함.
//OCP, DIP 위한 설정? 클래스 -> 구현 객체를 생성과 연결하는 역할을 함. -> DIP 완성
public class AppConfig { //IoC 컨테이너, DI 컨테이너 의존관계 주입

    @Bean //@Bean을 쓰면, 이 메서드들이 Spring 컨테이너에 등록이 됨.
    public MemberService memberService(){ //생성자 주입
        return new MemberServiceImpl(memberRepository()); //객체 생성과 동시에 참조값 주입(의존 관계 주입)
    }

    @Bean
    public MemberRepository memberRepository(){ //역할
        return new MemoryMemberRepository(); //구현
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy(); //아래 코드로 변경 -> 변경이 쉬움
        return new RateDiscountPolicy();
    }
}
