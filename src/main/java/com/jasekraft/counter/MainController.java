package com.jasekraft.counter;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
			model.addAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.removeAttribute("count");
		return this.index(session, null);
	}
	
}
