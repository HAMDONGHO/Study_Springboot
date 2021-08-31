package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //수정이 발생하기 때문에 트랜잭션을 넣어줘야 함, 읽기에는 readonly=true 를 해줘야함
@RequiredArgsConstructor //final이 있는 필드만 가지고 생서자를 만들어줌
public class MemberService {

    //레포지토리에 해당하는 서비스라는 걸 알림(스프링 빈에 등록된 레포를 인젝션 해줌)
    //@Autowired
    //private MemberRepository memberRepository;

    private final MemberRepository memberRepository;

    //회원 가입
    @Transactional //우선권을 가져서 따로 적용
    public Long join(Member member){
        validateDuplicateMember(member);//중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }
    //중복 회원이면 문제를 만드는 메서
    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
