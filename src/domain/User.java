package domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User {
	@Id
	
	private int id;
	private String name;
	private String surname;
	
	public User() {
		
	}
	
	public User(String name, String surname) {
		this.name = surname;
		this.surname = surname;
	}
	
	public String toString() {
		return "User: " + this.name + " " + this.surname;
	}

}
