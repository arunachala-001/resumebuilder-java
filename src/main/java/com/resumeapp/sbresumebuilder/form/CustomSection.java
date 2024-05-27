package com.resumeapp.sbresumebuilder.form;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class CustomSection {
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name="name", nullable=false)
	private String Name;
	
	public CustomSection() {
		
	}
	@OneToMany(mappedBy="customsection")
	private List<customDescription> customdescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;
	
	public CustomSection(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<customDescription> getCustomdescription() {
		return customdescription;
	}

	public void setCustomdescription(List<customDescription> customdescription) {
		this.customdescription = customdescription;
	}
	
	public void setcolumToremove(List<customDescription> customdescription) {
		this.customdescription = customdescription;
	}

	@Override
	public String toString() {
		return "CustomSection [id=" + id + ", Name=" + Name + ", customdescription=" + customdescription + ", template="
				+ template + "]";
	}

	
	
	
	
	
	
	
	

}
