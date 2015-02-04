package lan.home.forlife.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yar on 20.01.15.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

//    @Secured("ADMIN")
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody String admin(){
        return "<h2>Accepted</h2>";
    }
}
