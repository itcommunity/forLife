package lan.home.forlife.controllers;

import lan.home.forlife.domain.Page;
import lan.home.forlife.domain.PageType;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.domain.User;
import lan.home.forlife.repositories.PageRepository;
import lan.home.forlife.utils.ApiVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pages")
@ApiVersion
public class PageController {


    @Autowired
    private PageRepository pageRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<Iterable<Page>>(pageRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id){
        Page element = pageRepository.findOne(id);
        if(element!=null){
            return new ResponseEntity<Page>(element, HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/subject", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getSubject(@PathVariable Long id){
        Page element = pageRepository.findOne(id);
        if(element!=null){
            return new ResponseEntity<Subject>(element.getSubject(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/{id}/owner", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getOwner(@PathVariable Long id){
        Page element = pageRepository.findOne(id);
        if(element!=null){
            return new ResponseEntity<User>(element.getOwner(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/types", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<?> getTypes(){
        return new ResponseEntity<Object>(PageType.values(), HttpStatus.OK);
    }
}