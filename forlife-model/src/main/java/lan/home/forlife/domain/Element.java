package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by yar on 26.01.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "elements", discriminatorType = DiscriminatorType.STRING)
public abstract class Element {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ElementType type;

    @JsonIgnore
    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User owner;

    private Date created = new Date();

    public Element() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ElementType getType() {
        return type;
    }

    public void setType(ElementType type) {
        this.type = type;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", type=" + type +
                ", subject=" + subject +
                ", owner=" + owner +
                ", created=" + created +
                '}';
    }
}
