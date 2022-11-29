package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

//DB이름이 다를 경우, @Table(name = "DB명")
@Entity
public class Member {

    //@Id는 pk임을 뜻함
    @Id
    private Long id;
    //Column(name = "컬럼명") 으로 어노테이션 처리하면 됨
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
