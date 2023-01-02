package hello.core_practice.order;

import hello.core_practice.discount.DiscountPolicy;
import hello.core_practice.discount.FixDiscountPolicy;
import hello.core_practice.member.Member;
import hello.core_practice.member.MemberRepository;
import hello.core_practice.member.MemberService;
import hello.core_practice.member.MemoryMemberRepository;

public class OrderServicelmpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice){
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
