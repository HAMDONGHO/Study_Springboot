package hello.core_practice;

import hello.core_practice.member.Grade;
import hello.core_practice.member.Member;
import hello.core_practice.member.MemberService;
import hello.core_practice.member.MemberServicelmpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServicelmpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
