package lan.home.forlife.controllers;

import lan.home.forlife.domain.Element;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.dto.SubjectDTO;
import lan.home.forlife.repositories.SubjectRepository;
import lan.home.forlife.services.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by yar on 27.01.15.
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<Subject> getSubjects(){
        return subjectService.getAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody boolean addSubject(@RequestBody SubjectDTO subjectDTO){
        return subjectService.addSubject(subjectDTO);
    }

    @RequestMapping(value = "/elements/{subjectId}", method = RequestMethod.GET)
    public @ResponseBody List<Element> getElementsById(@PathVariable("subjectId")Long subjectId){
        if(subjectId!=null) {
           return subjectService.getElements(subjectId);
        }
        return null;
    }



}
