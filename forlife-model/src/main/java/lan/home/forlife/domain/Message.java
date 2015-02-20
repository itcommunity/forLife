package lan.home.forlife.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.Date;

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
    @Enumerated(EnumType.STRING)
    private MessageType type;

    private Date created=new Date();

    @ManyToOne
    private User sender;

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
}
