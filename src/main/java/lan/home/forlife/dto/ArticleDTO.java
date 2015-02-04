package lan.home.forlife.dto;

import lan.home.forlife.domain.Article;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.repositories.SubjectRepository;
import lan.home.forlife.repositories.TypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Created by yar on 28.01.15.
 */
//@Scope("prototype")
//@Component
public class ArticleDTO {
    private String name;
    private String content;
    private Long subjectId;

    public ArticleDTO() {
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

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}