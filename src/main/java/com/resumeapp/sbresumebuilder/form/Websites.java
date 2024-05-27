package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Websites {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String link;
	
	public Websites() {
		
	}
	
	public Websites(int id, String link) {
		super();
		this.id = id;
		this.link = link;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Websites [id=" + id + ", link=" + link + ", template=" + template + "]";
	}
	
	
	
	
}
