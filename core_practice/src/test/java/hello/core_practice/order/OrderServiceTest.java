package hello.core_practice.order;
import hello.core_practice.member.Grade;
import hello.core_practice.member.Member;
import hello.core_practice.member.MemberService;
import hello.core_practice.member.MemberServicelmpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServicelmpl();
    OrderService orderService = new OrderServicelmpl();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
