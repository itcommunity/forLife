package lan.home.forlife.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class Admin {

	private static final String START_PAGE = "/admin/start";

	@RequestMapping()
	public String index() {
		return START_PAGE;
	}

}
