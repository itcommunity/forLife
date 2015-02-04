package lan.home.forlife.services;

import lan.home.forlife.domain.Element;
import lan.home.forlife.domain.Subject;
import lan.home.forlife.dto.SubjectDTO;
import lan.home.forlife.repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yar on 28.01.15.
 */
@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    public boolean addSubject(SubjectDTO subjectDTO){
        if(subjectDTO!=null){
            Subject subject = new Subject();
            subject.setName(subjectDTO.getName());
            subjectRepository.save(subject);
            return true;
        }
        return false;
    }

    public Iterable<Subject> getAll(){
        return subjectRepository.findAll();
    }

    public List<Element> getElements(Long subjectId){
        if(subjectId!=null){
            Subject subject = subjectRepository.findOne(subjectId);
            return subject.getElements();
        }
        return null;
    }
}
