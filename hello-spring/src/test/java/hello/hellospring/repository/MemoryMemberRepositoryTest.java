package hello.hellospring.repository;

import hello.hellospring.domain.Member;
//Assertions은 테스트케이스 매우 중요함. 기대하는 값과 설계한 값이 동일한지
import org.assertj.core.api.Assertions;
//매 테스트 케이스마다 실행시켜주는 라이브러리
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

//Test는 순서에 종속되게 설계되면 안됨, findall에서 spring1, 2가 저장되면 findbyname 오류가 뜰거임
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //미리 설계한 클리어 호출해서 오류 해결
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        System.out.println("result =  " + (result ==member));
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(3);

    }
}
