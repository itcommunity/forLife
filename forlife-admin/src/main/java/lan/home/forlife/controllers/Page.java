package lan.home.forlife.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin/page")
public class Page {

	private static final String START_PAGE = "/admin/page/view";
	private static final String ADD_PAGE = "/admin/page/add";
	private static final String EDIT_PAGE = "/admin/page/edit";

	@RequestMapping()
	public String index() {
		return START_PAGE;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addForm() {
		return ADD_PAGE;
	}

	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editForm(@PathVariable String id) {
		return EDIT_PAGE;
	}
}
