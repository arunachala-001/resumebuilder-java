package com.resumeapp.sbresumebuilder.form;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class Certification {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String courseTittle;
    @Column(nullable = false)
	private String courseDuration;
    @Column(nullable = false)
	private String description;
	
	public Certification() {
		
	}
	@ManyToOne(fetch= FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public Certification(int id, String courseTittle, String courseDuration, String description) {
		super();
		this.id = id;
		this.courseTittle = courseTittle;
		this.courseDuration = courseDuration;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTittle() {
		return courseTittle;
	}

	public void setCourseTittle(String courseTittle) {
		this.courseTittle = courseTittle;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	@Override
	public String toString() {
		return "Certification [id=" + id + ", courseTittle=" + courseTittle + ", courseDuration=" + courseDuration
				+ ", description=" + description + ", template=" + template + "]";
	}

	

	
	
	
	
	
	
	
}
