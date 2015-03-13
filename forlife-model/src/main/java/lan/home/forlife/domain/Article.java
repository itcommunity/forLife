package lan.home.forlife.domain;

import javax.persistence.Entity;

/**
 * Created by yar on 26.01.15.
 */
@Entity
//@DiscriminatorValue("ARTICLE")
//@DiscriminatorValue("")
public class Article extends Page {
//    @JsonIgnore
    private String content;

    public Article() {
        setType(PageType.ARTICLE);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                ", content='" + content + '\'' +
                '}';
    }
}
