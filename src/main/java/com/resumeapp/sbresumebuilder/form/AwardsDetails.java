package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class AwardsDetails {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
    private String tittle;
    @Column(nullable = false)
    private String description;
    
	public AwardsDetails() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public AwardsDetails(int id, String tittle, String description) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "AwardsDetails [id=" + id + ", tittle=" + tittle + ", description=" + description + ", template="
				+ template + "]";
	}

	
    
    
}
