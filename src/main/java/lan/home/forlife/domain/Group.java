package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yar on 21.01.15.
 */
@Entity
@Table(name = "GROUPS")
public class Group {
    @Id
    @GeneratedValue
    private Long id;
    private String groupname;

    @JsonIgnore
    @ManyToMany(
//            cascade = CascadeType.PERSIST,
            fetch = FetchType.EAGER,
            mappedBy = "groups",
            targetEntity = User.class
    )
    private List<User> users = new ArrayList<>();

    public Group() {
    }

    public Group(String groupname) {
        this.groupname = groupname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupname() {
        return groupname;
    }

    public void setGroupname(String groupname) {
        this.groupname = groupname;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupname='" + groupname + '\'' +
                '}';
    }
}
