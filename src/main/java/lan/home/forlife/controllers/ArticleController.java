package lan.home.forlife.controllers;

import lan.home.forlife.domain.User;
import lan.home.forlife.dto.ArticleDTO;
import lan.home.forlife.services.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/article")
public class ArticleController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody boolean addArticle(@RequestBody ArticleDTO articleDTO, @AuthenticationPrincipal User user){
        if(articleDTO!=null&&user!=null){
            articleService.addArticle(articleDTO, user);
            return true;
        }
        return false;
    }
}
