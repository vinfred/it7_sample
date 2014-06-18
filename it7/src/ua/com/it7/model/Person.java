package ua.com.it7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
	@JsonProperty("Name")
	String	name;
	@JsonProperty("date of birth")
	String	dateBirth;
	@JsonProperty("Biography")
	String	bio;
	
	public Person() {
		super();
	}
	
	public Person(String name, String dateBirth, String bio) {
		super();
		this.name = name;
		this.dateBirth = dateBirth;
		this.bio = bio;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateBirth() {
		return dateBirth;
	}
	
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	
	public String getBio() {
		return bio;
	}
	
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", dateBirth=" + dateBirth + ", bio=" + bio + "]";
	}
	
}
