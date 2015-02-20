package lan.home.forlife.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lan.home.forlife.domain.Element;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by yar on 26.01.15.
 */
@Entity
@DiscriminatorValue("ARTICLE")
public class Article extends Element {
    private String title;
    @JsonIgnore
    private String content;

    public Article() {
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
                ", content='" + content + '\'' +
                '}';
    }
}
