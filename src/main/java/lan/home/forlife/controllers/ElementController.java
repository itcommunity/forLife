package lan.home.forlife.controllers;

import lan.home.forlife.domain.Element;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.repositories.ElementRepository;
import lan.home.forlife.repositories.SubjectRepository;
import lan.home.forlife.services.ElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yar on 27.01.15.
 */
@Controller
@RequestMapping("/element")
public class ElementController {

    @Autowired
    ElementService elementService;

    @RequestMapping(value = "/{elementId}", method = RequestMethod.GET)
    public @ResponseBody Element getElement(@PathVariable("elementId") Long elementId){
        return elementService.getElement(elementId);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public @ResponseBody List<Element> getNew(){
        return elementService.getNew();
    }
}