package lan.home.forlife.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lan.home.forlife.domain.Article;
import lan.home.forlife.domain.Element;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yar on 27.01.15.
 */
@Controller
@RequestMapping("/api/elements")
public class ElementController {


    @Autowired
    private ElementRepository elementRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<Iterable<Element>>(elementRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id){
        Element element = elementRepository.findOne(id);
        if(element!=null){
            return new ResponseEntity<Element>(element, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/subject", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getSubject(@PathVariable Long id){
        Element element = elementRepository.findOne(id);
        if(element!=null){
            return new ResponseEntity<Subject>(element.getSubject(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}