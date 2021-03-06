package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

/**
 * Created by yar on 20.01.15.
 */
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id

    @GeneratedValue
    private Long id;

    private String username;
    private String firstname;
    private String lastname;
    @JsonIgnore
    private String password;
    private String email;
    private boolean enabled = true;
    private boolean locked = false;
    private Date registrationDate;
    private Date expirationDate;

    {
        registrationDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        expirationDate = cal.getTime();
    }

    @ManyToMany(
            targetEntity = Group.class,
//            cascade={CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "GROUP_ID")
    )
    private List<Group> groups = new ArrayList<>();

//    @ElementCollection(fetch = FetchType.EAGER)
//    @Enumerated(EnumType.STRING)
//    private List<Role> roles = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    private List<Page> pages = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sender")
    private List<Message> outgoingMessages = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
//            mappedBy = "recipients",
//            targetEntity = Message.class
    )
    private List<Message> incomingMessages = new ArrayList<>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public List<Message> getOutgoingMessages() {
        return outgoingMessages;
    }

    public void setOutgoingMessages(List<Message> outgoingMessages) {
        this.outgoingMessages = outgoingMessages;
    }

    public List<Message> getIncomingMessages() {
        return incomingMessages;
    }

    public void setIncomingMessages(List<Message> incomingMessages) {
        this.incomingMessages = incomingMessages;
    }

    //    public List<Role> getRoles() {
//        return roles;
//    }
//
//    public void setRoles(List<Role> roles) {
//        this.roles = roles;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = new HashSet<>();
        for (Group group : groups) {
            roles.addAll(group.getRoles());
        }
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        Date now = new Date();
        return now.before(expirationDate);
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
