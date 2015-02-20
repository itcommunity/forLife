package lan.home.forlife.domain;

import lan.home.forlife.domain.Group;
import lan.home.forlife.domain.Message;
import lan.home.forlife.domain.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yar on 20.02.15.
 */
@Entity
@DiscriminatorValue("group_text_message")
public class TextMessage extends Message{
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
