package user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	//GET ("/users")
	//retrieveAllUsers
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//GET ("/users/{id}")
	//retrieveSingleUser(int id)
	
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUser(@PathVariable int id) {
		
		User user = service.findOne(id);
		
		//If the given userid is not available then it says user not found[404 NOT FOUND]
		
        if(user==null) 
        	
        	throw new UserNotFoundException("id->"+id);
        	
        	EntityModel<User> model = EntityModel.of(user);
        	
        	WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers());
        	
        	model.add(linkToUsers.withRel("all-users"));
		     return model;
	}
	
	
	//To delete a particular User
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		
		User user = service.deleteById(id);
        if(user==null)
        	throw new UserNotFoundException("id-"+id);
		}
	

	//FOR CREATING USER
	//input - details of user
	//output - CREATED & Return the created URI
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
     User savedUser = service.save(user);
     
     
	//Response back(User Created)
	//savedUser.getId() == ("/user/{id}")
     
       URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser.getId()).toUri();
	
	return ResponseEntity.created(location).build();
}
}