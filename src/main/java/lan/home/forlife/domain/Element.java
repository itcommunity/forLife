package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yar on 26.01.15.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "element", discriminatorType = DiscriminatorType.STRING)
public abstract class Element {

    @Id
    @GeneratedValue
    private Long id;

//    @JsonIgnore
    @ManyToOne
    private Type type;

    @JsonIgnore
    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User user;

    private Date added=new Date();

    public Element() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
