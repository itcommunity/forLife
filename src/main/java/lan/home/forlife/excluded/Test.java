package lan.home.forlife.excluded;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by yar on 05.02.15.
 */
@Entity
public class Test {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Test() {
    }

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
