package booth.main;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainPageController {
	@RequestMapping("/")
	public String main(HttpSession session) {
		String result = null;
		if (session.getAttribute("loginStatus") == "true")
		{
			result = "afterLogin.jsp";
		}
		else
		{
			result = "login.jsp";
		}
		return result;
	}
}
