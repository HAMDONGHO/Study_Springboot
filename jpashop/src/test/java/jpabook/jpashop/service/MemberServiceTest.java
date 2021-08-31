package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //스프링을 포함해서 테스트를 진행하므로 SpringRunner를 넣어줌
@SpringBootTest//Spring 컨테이너에서 돌려줌을 의미
@Transactional //commit이 아니라 rollback을 해버림 그래서 insert를 안해줌! 그래서 rollback을 false로 해놓으면 됨
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    //@Rollback(false)
    public void 회원가입() throws Exception{
        //given(이러한 값을 던졌을때 라는 의미)
        Member member = new Member();
        member.setName("kim");

        //when(저장했을때)
        Long saveId = memberService.join(member);

        //Then(일케 된다)
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)//예외가 터져서 나간애를 잡아줌
    public void 중복_회원_예약() throws Exception{
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");
        //when
        memberService.join(member1);
        memberService.join(member2); //여기서 예외가 터져야함!

        //then
        fail("예외가 발생해야 한다.");
    }

}