package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by yar on 26.01.15.
 */
@Entity
@DiscriminatorValue("article")
public class Article extends Element{
    private String name;
    private String title;
    @JsonIgnore
    private String content;

    public Article() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
