package lan.home.forlife.services;

import lan.home.forlife.domain.Element;
import lan.home.forlife.repositories.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yar on 28.01.15.
 */
@Service
public class ElementService {

    @Autowired
    ElementRepository elementRepository;

    public Element getElement(Long elementId){
        if(elementId!=null) {
         return elementRepository.findOne(elementId);
        }
        return null;
    }

    public List<Element> getNew(){
        Page<Element>  page = elementRepository.findAll(new PageRequest(0, 20));
        return page.getContent();
    }
}
