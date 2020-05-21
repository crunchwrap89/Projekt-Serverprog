package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class User implements java.io.Serializable {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setFirstName(String firstName) {
		this.name = firstName;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
