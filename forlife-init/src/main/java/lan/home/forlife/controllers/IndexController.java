package lan.home.forlife.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yar on 10.02.15.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index(){
        return "redirect:/static/test.html";
    }
}
