package hello.core_practice;

import hello.core_practice.member.*;
import hello.core_practice.order.Order;
import hello.core_practice.order.OrderService;
import hello.core_practice.order.OrderServicelmpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServicelmpl();
        OrderService orderService = new OrderServicelmpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
