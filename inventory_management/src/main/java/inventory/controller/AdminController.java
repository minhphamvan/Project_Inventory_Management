package inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@RequestMapping("/dashboard")
	public String dashboard() {
		return "admin/dashboard";
	}
}
