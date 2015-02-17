package lan.home.forlife.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yar on 17.02.15.
 */
@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name = "message", discriminatorType = DiscriminatorType.STRING)
public abstract class Message {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @ManyToOne
    private MessageType type;

    private Date created=new Date();

    @ManyToOne
    private User sender;

    @ManyToMany(
            targetEntity=User.class
//            cascade={CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name="MESSAGE_RECIPIENTS",
            joinColumns=@JoinColumn(name="MESSAGE_ID"),
            inverseJoinColumns=@JoinColumn(name="USER_ID")
    )
    private List<User> recipients = new ArrayList<>();

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<User> recipients) {
        this.recipients = recipients;
    }
}
