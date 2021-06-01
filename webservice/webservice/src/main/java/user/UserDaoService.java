package user;

import java.util.Date;
import java.util.*;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"Ahmad",new Date()));
		users.add(new User(2,"Arjun",new Date()));
		users.add(new User(3,"Bipin",new Date()));
	}
	
	//CRUD repo methods
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;
			}
		}
		return null;
	}


public User deleteById(int id) {
 Iterator<User> it = users.iterator();
 while(it.hasNext()) {
	 User user = it.next();
		if(user.getId()==id) {
			it.remove();
			return user;
		}
	}
	return null;
}

}

