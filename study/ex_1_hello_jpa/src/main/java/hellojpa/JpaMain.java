package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        //EntityManager는 쓰레드간 공유하지 않고, EntityManagerFactory는 하나만 생성해서 애플리케이션 전체에서 공유
        //JPA 모든 데이터 변경은 하나의 트랜잭션에서만 이뤄짐
        tx.begin();

        try {
            Member findMember = em.find(Member.class, 3L);
            findMember.setName("안유진");
            /* 삽입
            Member member = new Member();
            member.setId(4L);
            member.setName("유나짱");

            em.persist(member);
            */
            //전체 조회 같은건 jpql로.... List<Member> findMembers = em.createQuery("select m from Member as m", Member.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
