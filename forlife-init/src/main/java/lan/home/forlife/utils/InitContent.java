package lan.home.forlife.utils;

import lan.home.forlife.domain.*;
import lan.home.forlife.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * Created by yar on 20.01.15.
 */
@Component
public class InitContent {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    ElementTypeRepository typeRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @PostConstruct
    public void addDefaultUsers(){
        Group admin = new Group("Test");
        groupRepository.save(admin);
        User yar = new User();
        yar.setUsername("yar");
        yar.setPassword(passwordEncoder.encode("123456"));
        yar.getGroups().add(admin);
        yar.getRoles().add(Role.ADMIN);
        yar.getRoles().add(Role.USER);
        userRepository.save(yar);


        ElementType articleType = new ElementType();
        articleType.setName("article");
        ElementType blogType = new ElementType();
        blogType.setName("blog");
        typeRepository.save(Arrays.asList(new ElementType[]{articleType, blogType}));

        Subject test1 = new Subject();
        test1.setName("testSubject1");
        Subject test2 = new Subject();
        test2.setName("testSubject2");
        subjectRepository.save(Arrays.asList(new Subject[]{test1, test2}));

        Article article = new Article();
        article.setName("testArticle");
        article.setType(articleType);
        article.setSubject(test1);
        article.setContent("<p style=\"text-align: center;\">Test content</p>\n" +
                "<ul>\n" +
                "<li style=\"text-align: left;\">First</li>\n" +
                "<li style=\"text-align: left;\">Secont</li>\n" +
                "<li style=\"text-align: left;\">Third</li>\n" +
                "<li style=\"text-align: left;\"><em>fsfdsfsfsdf</em></li>\n" +
                "</ul>");
        Article article1 = new Article();
        article1.setType(articleType);
        article1.setName("testBBB");
        articleRepository.save(Arrays.asList(new Article[]{article, article1}));
    }
}
