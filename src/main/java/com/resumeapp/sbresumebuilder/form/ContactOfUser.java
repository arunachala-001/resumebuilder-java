package com.resumeapp.sbresumebuilder.form;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ContactOfUser {
	
   @Id
   @GeneratedValue
   private int id;
   @Column(nullable = false)
   private String firstName;
   @Column(nullable = false)
   private String lastName;
   private String gender;
   @Column(nullable = false)
   private LocalDate dateOfBirth;
   @Column(nullable = false)
   private String email;
   private long phoneNumber;
   private String maritalStatus;
   private String country;
   @Column(nullable = false)
   private String state;
   @Column(nullable = false)
   private String city;
   private String nationality;
   
   
   public ContactOfUser() {
	   
   }
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JsonIgnore
   private staticTemplate template;

public ContactOfUser(int id, String firstName, String lastName, String gender, LocalDate dateOfBirth, String email,
		long phoneNumber, String maritalStatus, String country, String state, String city, String nationality) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.gender = gender;
	this.dateOfBirth = dateOfBirth;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.maritalStatus = maritalStatus;
	this.country = country;
	this.state = state;
	this.city = city;
	this.nationality = nationality;
	
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getGender() {
	return gender;
}

public staticTemplate getTemplate() {
	return template;
}

public void setTemplate(staticTemplate template) {
	this.template = template;
}

public void setGender(String gender) {
	this.gender = gender;
}

public LocalDate getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(LocalDate dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public long getPhoneNumber() {
	return phoneNumber;
}

public void setPhoneNumber(long phoneNumber) {
	this.phoneNumber = phoneNumber;
}

public String getMaritalStatus() {
	return maritalStatus;
}

public void setMaritalStatus(String maritalStatus) {
	this.maritalStatus = maritalStatus;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getNationality() {
	return nationality;
}

public void setNationality(String nationality) {
	this.nationality = nationality;
}

@Override
public String toString() {
	return "ContactOfUser [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
			+ ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", phoneNumber=" + phoneNumber + ", maritalStatus="
			+ maritalStatus + ", country=" + country + ", state=" + state + ", city=" + city + ", nationality="
			+ nationality + ", template=" + template + "]";
}






   
   
   
   
   
   
}
