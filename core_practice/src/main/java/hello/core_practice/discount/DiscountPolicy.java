package hello.core_practice.discount;

import hello.core_practice.member.Member;

public interface DiscountPolicy {

    /* @return 할인 대상 금액
    * */
    int discount(Member member, int price);
}
