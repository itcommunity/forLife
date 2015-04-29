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
    SubjectRepository subjectRepository;

    @Autowired
    MainPageRepository mainPageRepository;

    @PostConstruct
    public void addDefaultUsers() {
        Group admin = new Group("Admin");
        admin.getRoles().add(Role.ADMIN);
        Group user = new Group("user");
        user.getRoles().add(Role.USER);
        groupRepository.save(Arrays.asList(new Group[]{admin, user}));
        User yar = new User();
        yar.setUsername("yar");
        yar.setPassword(passwordEncoder.encode("123456"));
        yar.getGroups().add(admin);
        userRepository.save(yar);


        Subject test1 = new Subject();
        test1.setName("testSubject1");
        Subject test2 = new Subject();
        test2.setName("testSubject2");
        subjectRepository.save(Arrays.asList(new Subject[]{test1, test2}));

        Article article = new Article();
        article.setName("testArticle");
        article.setSubject(test1);
//        article.setContent("<p style=\"text-align: center;\">Test content</p>\n" +
//                "<ul>\n" +
//                "<li style=\"text-align: left;\">First</li>\n" +
//                "<li style=\"text-align: left;\">Secont</li>\n" +
//                "<li style=\"text-align: left;\">Third</li>\n" +
//                "<li style=\"text-align: left;\"><em>fsfdsfsfsdf</em></li>\n" +
//                "</ul>");
        article.setContent("<h1>Content 1</h1>");
        Article article1 = new Article();
        article1.setName("testBBB");
        article1.setContent("<h2>Content 2</h2>");
        article1.setSubject(test2);
//        articleRepository.save(Arrays.asList(new Article[]{article, article1}));
        Article article2 = new Article();
        article2.setName("New Test Article");
        article2.setSubject(test1);
        article2.setContent("<h3>Hello Article</h3>");
        article2.getFooterPages().add(article1);
        article2.getFooterPages().add(article2);
        articleRepository.save(Arrays.asList(new Article[]{article, article1, article2}));

        MainPage mainPage = new MainPage();
        mainPage.setName("Main page");
        mainPage.getFooterPages().add(article1);
        mainPage.getFooterPages().add(article);
        mainPage.getHeaderPages().add(article2);
        mainPage.setContent("<h1>Hello World</h1>");
        mainPage.getSubjectList().add(test1);
        mainPage.getSubjectList().add(test2);
        mainPageRepository.save(mainPage);
    }
}
