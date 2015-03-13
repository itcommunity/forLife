package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;


@Entity
public class MainPage extends Page {
    private String content;

    public MainPage() {
        setType(PageType.MAIN_PAGE);
    }

    @JsonIgnore
    @ManyToMany(targetEntity = Subject.class)
    @JoinTable(name="MAINPAGE_SUBJECTS", joinColumns=@JoinColumn(name="MAINPAGE_ID"), inverseJoinColumns=@JoinColumn(name="SUBJECT_ID"))
    private List<Subject> subjectList = new ArrayList<>();

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
