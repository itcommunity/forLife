package lan.home.forlife.controllers;

import lan.home.forlife.domain.Element;
import lan.home.forlife.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yar on 27.01.15.
 */
@Controller
@RequestMapping("/element")
public class ElementController {


    @Autowired
    private ElementRepository elementRepository;


    @RequestMapping(value = "/{elementId}", method = RequestMethod.GET)
    public @ResponseBody Element getElement(@PathVariable("elementId") Long elementId){
        return elementRepository.findOne(elementId);
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public @ResponseBody Iterable<Element> getNew(){
        return elementRepository.findAll();
    }
}