package user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id                      //TO MAKE IT PRIMARY KEY
	@GeneratedValue         //TO GENERATE VALUE IN DB  
	private Integer id;
	
	@Size(min=3, message="name must have 2 charachters..!")
	private String name;
	
	@Past
	private Date birthdate;
	
	protected User() {
		super();
	}

	public User(Integer id, String name, Date birthdate) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return birthdate;
	}
	public void setDate(Date date) {
		this.birthdate = date;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + birthdate + "]";
	}
	
	

}
