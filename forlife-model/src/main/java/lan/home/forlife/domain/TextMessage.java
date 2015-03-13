package lan.home.forlife.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yar on 20.02.15.
 */
@Entity
//@DiscriminatorValue("TEXT_MESSAGE")
public class TextMessage extends Message {
    private String text;

    @ManyToMany
    private Set<User> users = new HashSet<>();

    @ManyToMany
    private Set<Group> groups = new HashSet<>();

    public TextMessage() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
