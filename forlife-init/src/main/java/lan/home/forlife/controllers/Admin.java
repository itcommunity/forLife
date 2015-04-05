package lan.home.forlife.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/admin")
public class Admin {
	
	private static final String START_PAGE="/admin/start";
	
	@RequestMapping(value = "start", method = RequestMethod.GET)
	public String index(){
		System.out.println("admin start");
		return START_PAGE;
	}
	
}
