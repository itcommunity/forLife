package lan.home.forlife.controllers;

import lan.home.forlife.domain.Element;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.repositories.ElementRepository;
import lan.home.forlife.repositories.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yar on 27.01.15.
 */
@RestController
@RequestMapping("/api/subjects")
public class SubjectController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());


    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ElementRepository elementRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<Iterable<Subject>>(subjectRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getById(@PathVariable Long id){
        Subject subject = subjectRepository.findOne(id);
        if(subject!=null){
            return new ResponseEntity<Subject>(subject, HttpStatus.FOUND);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> addOrChange(@RequestBody Subject subject){
        Subject saveSubject = subjectRepository.save(subject);
        if(saveSubject!=null){
            return new ResponseEntity<Object>(HttpStatus.CREATED);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "{id}/elements", method = RequestMethod.GET)
    public ResponseEntity<?> getElements(@PathVariable Long id){
        Subject subject = subjectRepository.findByIdAndFetchElementsEagerly(id);
        if(subject!=null){
            return new ResponseEntity<Object>(subject.getElements(), HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(id!=null) {
            subjectRepository.delete(id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "{id}/elements/{elementId}", method = RequestMethod.PUT)
    public ResponseEntity<?> addElement(@PathVariable Long id, @PathVariable Long elementId){
        if(id!=null&&elementId!=null){
            Subject subject = subjectRepository.findByIdAndFetchElementsEagerly(id);
            Element element = elementRepository.findOne(elementId);
            if(subject!=null&&element!=null){
                element.setSubject(subject);
//                subject.getElements().add(element);
//                log.info("Add element to subject");
//                subjectRepository.save(subject);
                elementRepository.save(element);
                return new ResponseEntity<Object>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
    }
}
