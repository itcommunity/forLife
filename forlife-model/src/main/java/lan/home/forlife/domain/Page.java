package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * Created by yar on 26.01.15.
 */
@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name = "elements", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Page {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

//    @NotNull
    @Enumerated(EnumType.STRING)
    private PageType type;

    private String description;

    private String imgUrl;

    @JsonIgnore
    @ManyToOne
    private Subject subject;

    @ManyToOne
    private User owner;

    @JsonIgnore
    @ManyToMany(targetEntity=Page.class)
    @JoinTable(name="PAGE_HEADERPAGE", joinColumns=@JoinColumn(name="PAGE_ID"), inverseJoinColumns=@JoinColumn(name="HEADERPAGE_ID"))
    private List<Page> headerPages = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(targetEntity = Page.class)
    @JoinTable(name = "PAGE_FOOTERPAGE",joinColumns = @JoinColumn(name = "PAGE_ID"), inverseJoinColumns = @JoinColumn(name = "FOOTERPAGE_ID"))
    private List<Page> footerPages = new ArrayList<>();

    private Date created = new Date();

    public Page() {
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

    public PageType getType() {
        return type;
    }

    public void setType(PageType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    public List<Page> getHeaderPages() {
        return headerPages;
    }

    public void setHeaderPages(List<Page> headerPages) {
        this.headerPages = headerPages;
    }

    public List<Page> getFooterPages() {
        return footerPages;
    }

    public void setFooterPages(List<Page> footerPages) {
        this.footerPages = footerPages;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
