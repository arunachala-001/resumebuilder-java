package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class LanguageDetails {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String language;
	
	public LanguageDetails() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public LanguageDetails(int id, String language) {
		super();
		this.id = id;
		this.language = language;
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

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "LanguageDetails [id=" + id + ", language=" + language + ", template=" + template + "]";
	}

	
	
	
}
