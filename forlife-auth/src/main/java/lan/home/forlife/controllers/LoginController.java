package lan.home.forlife.controllers;

import lan.home.forlife.domain.Role;
import lan.home.forlife.domain.User;
import lan.home.forlife.dto.LoginRequest;
import lan.home.forlife.dto.LoginResponse;
import lan.home.forlife.dto.SignupRequest;
import lan.home.forlife.dto.UserInfo;
import lan.home.forlife.repositories.GroupRepository;
import lan.home.forlife.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by yar on 26.01.15.
 */
@Controller
public class LoginController {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private GroupRepository groupRepository;

    @RequestMapping(value = "/signup.json", method = RequestMethod.POST)
    public @ResponseBody boolean signup(@RequestBody SignupRequest signupRequest){
        User user = new User();
        if(!signupRequest.getUsername().isEmpty()&&!signupRequest.getPassword().isEmpty()) {
            user.setUsername(signupRequest.getUsername());
            user.setEmail(signupRequest.getEmail());
            user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
            user.getGroups().add(groupRepository.findByGroupname("user"));
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @RequestMapping(value="/login.json", method = RequestMethod.POST, consumes="application/json")
    public @ResponseBody
    LoginResponse mosLogin(@RequestBody LoginRequest loginRequest, HttpServletRequest request) {
        LoginResponse response = new LoginResponse();


        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
            token.setDetails(new WebAuthenticationDetails(request));

            Authentication auth = authenticationManager.authenticate(token);
            SecurityContext securityContext = SecurityContextHolder.getContext();
            securityContext.setAuthentication(auth);

            if(auth.isAuthenticated()){
                HttpSession session = request.getSession(true);
                session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);

                response.setUsername(loginRequest.getUsername());
                response.setAuthenticated(true);
            }else{
                SecurityContextHolder.getContext().setAuthentication(null);

                log.info("Login: "+loginRequest.getUsername()+" Password: "+loginRequest.getPassword());
                response.setUsername(loginRequest.getUsername());
                response.setAuthenticated(false);
            }
        } catch (Exception e) {
            response.setError(e.getMessage());
        }
        return response;
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public @ResponseBody
    UserInfo getUserInfo(@AuthenticationPrincipal User user){
        UserInfo userInfo = new UserInfo();
        if(user!=null){
            userInfo.setAuthenticated(true);
            userInfo.setUsername(user.getUsername());
        }
        return userInfo;
    }
}
