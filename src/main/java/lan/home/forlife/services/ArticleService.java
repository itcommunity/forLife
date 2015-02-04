package lan.home.forlife.services;

import lan.home.forlife.domain.Article;
import lan.home.forlife.domain.User;
import lan.home.forlife.dto.ArticleDTO;
import lan.home.forlife.repositories.ArticleRepository;
import lan.home.forlife.repositories.SubjectRepository;
import lan.home.forlife.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yar on 28.01.15.
 */
@Service
public class ArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    TypeRepository typeRepository;

    public boolean addArticle(ArticleDTO articleDTO, User user){
        Article article = new Article();
        article.setName(articleDTO.getName());
        article.setContent(articleDTO.getContent());
        article.setType(typeRepository.findTypeByName("article"));
        article.setSubject(subjectRepository.findOne(articleDTO.getSubjectId()));
        article.setUser(user);
        articleRepository.save(article);
        return true;
    }
}
