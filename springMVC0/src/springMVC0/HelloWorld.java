package springMVC0;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/welcome")
@RequestMapping("/")
public class HelloWorld {
	
	//@RequestMapping("/welcome")
	public ModelAndView helloWorld()
	{
		String message = "<br><div stylr='text-align:center;'>"
				+ "<h3> ****Hello world!</h3>";
		return new ModelAndView("welcome","message",message); //this will return the model (name is "message") with view name "welcome" ==>welcome.jsp
	}

}
