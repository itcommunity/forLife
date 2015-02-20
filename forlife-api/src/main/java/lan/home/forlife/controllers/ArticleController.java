package lan.home.forlife.controllers;

import lan.home.forlife.domain.Article;
import lan.home.forlife.domain.User;
import lan.home.forlife.repositories.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
public class ArticleController extends ElementController{

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleRepository articleRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> addSubject(@RequestBody Article article, @AuthenticationPrincipal User user){
        article.setOwner(user);
        log.info("Articles subj: " + article.getSubject());
        Article saveArticle = articleRepository.save(article);
        if(saveArticle!=null){
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id!=null) {
            articleRepository.delete(id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}
