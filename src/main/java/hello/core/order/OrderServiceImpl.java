package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository(); //멤버 받아오기
    //    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //할인율 고정 할인
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인율 차등 할인(변경 용이 but, OCP 위반! 및 DIP 위반)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy; //DIP 위반X 위해 변경

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId); //아이디 찾기
        int discountPrice = discountPolicy.discount(member, itemPrice); //할인 금액

        return new Order(memberId, itemName, itemPrice, discountPrice); //최종 주문 반환
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
