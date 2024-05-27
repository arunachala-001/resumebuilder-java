package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Hobbies {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String hobby;
	
	public Hobbies() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public Hobbies(int id, String hobby) {
		super();
		this.id = id;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Hobbies [id=" + id + ", hobby=" + hobby + ", template=" + template + "]";
	}

	
	
	
}
