package Filtering;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class SomeBean {
	
	private String name;
	private int id;
	
	@JsonIgnore
	private int salary;
	
	private String address;
	
	public SomeBean() {
		super();
	}

	public SomeBean(String name, int id, int salary, String address) {
		super();
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "SomeBean [name=" + name + ", id=" + id + ", salary=" + salary + ", address=" + address + "]";
	}
}
