package HelloWorld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource ms;
	
	//GET
	//URI-> /hello-world
	//method - "Hello World"
	
	@GetMapping(path = "/hello-world")
	//@GetMapping(path = "/hello-world") --> we can also use this in place of above @RequestMapping
	
	public String helloworld() {
		return "Hello World This Is My First WebService...!";
	}
	
	//Hello-World-Bean
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World bean controller..!");
	}
	
	//Hello-World-PathVariable(to give value in browser)
		@GetMapping(path = "/hello-world/path-variable/{name}")
		public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
			return new HelloWorldBean(String.format("Hello World path variable..!, %s",name));
		}
		
	
		//Adaptable to Different Languages like French, English, Cinease etc
		
		@GetMapping(path = "/hello-int")
		public String helloInternationalized() {
			return ms.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
		}
}
