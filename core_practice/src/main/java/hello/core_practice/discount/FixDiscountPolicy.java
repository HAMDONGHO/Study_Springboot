package hello.core_practice.discount;

import hello.core_practice.member.Grade;
import hello.core_practice.member.Member;

import static hello.core_practice.member.Grade.VIP;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
