package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yar on 27.01.15.
 */
@Entity
public class Subject {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "subject", fetch = FetchType.LAZY)
    Set<Element> elements = new HashSet<>();

    public Subject() {
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

    public Set<Element> getElements() {
        return elements;
    }

    public void setElements(Set<Element> elements) {
        this.elements = elements;
    }
}
