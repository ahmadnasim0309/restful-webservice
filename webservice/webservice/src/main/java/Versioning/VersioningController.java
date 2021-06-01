package Versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {
	
	@GetMapping("/personv1")
	public PersonV1 personv1() {
		return new PersonV1("Rohit Dhawan");
	}
	
	@GetMapping("/personv2")
	public PersonV2 personv2() {
		return new PersonV2(new Name("Rohit","Dhawan"));
	}


}
