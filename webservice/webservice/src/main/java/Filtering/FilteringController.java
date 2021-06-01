package Filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filter")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("ajay", 101, 15000, "noida, india");
	}
	
	//Filtering List
	
	@GetMapping("/filter-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("ajay", 101, 15000, "noida, india"),
				new SomeBean("atul", 102, 18000, "mumbai, india"));
	}

}
