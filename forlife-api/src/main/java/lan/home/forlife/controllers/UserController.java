package lan.home.forlife.controllers;

import lan.home.forlife.domain.User;
import lan.home.forlife.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by yar on 04.02.15.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{id}")
    public HttpEntity<User> getById(@PathVariable("id")Long id){
        User user = userRepository.findOne(id);
        if(user!=null) {
            HttpHeaders headers = new HttpHeaders();
            headers.set("ForLife", "ItsOk");
            return new ResponseEntity<User>(user, headers, HttpStatus.OK);
        }
        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }
}