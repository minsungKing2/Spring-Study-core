package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy") //빈이 두 개이상 조회될 시 이름 지어주는 것(명시적으로 사용) Qualifier가 Primary보다 우선순위가 높다.
//@Primary //조회 빈 우선순위(메인으로 사용)
@MainDiscountPolicy //직접 만든 애노테이션
public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * discountPercent / 100;
        }else{
            return 0;
        }
    }
}
