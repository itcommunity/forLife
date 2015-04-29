package lan.home.forlife.controllers;

import lan.home.forlife.domain.MainPage;
import lan.home.forlife.domain.Page;
import lan.home.forlife.domain.User;
import lan.home.forlife.repositories.MainPageRepository;
import lan.home.forlife.utils.ApiVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mainpages")
@ApiVersion
public class MainPageController extends PageController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MainPageRepository mainPageRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<?> add(@RequestBody MainPage mainPage, @AuthenticationPrincipal User user) {
        mainPage.setOwner(user);
        Page savedPage = mainPageRepository.save(mainPage);
        if (savedPage != null) {
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        if (id != null) {
            mainPageRepository.delete(id);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
    }
}
