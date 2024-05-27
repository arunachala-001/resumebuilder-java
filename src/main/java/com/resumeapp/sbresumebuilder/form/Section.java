package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Section {
    @Id
    @GeneratedValue
	private int id;
    
    @Column(unique = true)
	private String sectionName;
	
	public Section() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;
	
	public Section(int id, String sectionName) {
		super();
		this.id = id;
		this.sectionName = sectionName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Section [id=" + id + ", sectionName=" + sectionName + ", template=" + template + "]";
	}

	
	
	
}
