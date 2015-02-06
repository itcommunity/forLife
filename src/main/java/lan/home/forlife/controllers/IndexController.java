package lan.home.forlife.controllers;

import lan.home.forlife.domain.*;
import lan.home.forlife.dto.LoginRequest;
import lan.home.forlife.dto.LoginResponse;
import lan.home.forlife.dto.SignupRequest;
import lan.home.forlife.dto.UserInfo;
import lan.home.forlife.repositories.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by yar on 20.01.15.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    TypeRepository typeRepository;

    @Autowired
    ElementRepository elementRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    SubjectRepository subjectRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@AuthenticationPrincipal User user){
        return "redirect:/static/test.html";
    }


    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public @ResponseBody Iterable<Subject> getSubjects(){
        return subjectRepository.findAll();
    }

    @RequestMapping(value = "/elements/{subjectId}", method = RequestMethod.GET)
    public @ResponseBody
    Set<Element> getElements(@PathVariable("subjectId") Long subjectId){
        Subject subject = subjectRepository.findOne(subjectId);
        if(subject!=null){
            return subject.getElements();
        }
        return null;
    }

    @RequestMapping(value = "/element/{elementId}", method = RequestMethod.GET)
    public @ResponseBody Element getElement(@PathVariable("elementId") Long elementId){
        Element element = elementRepository.findOne(elementId);
        if(element!=null){
            return element;
        }
        return null;
    }


}
