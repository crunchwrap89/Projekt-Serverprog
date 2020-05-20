package domain;

public class User {
	
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
