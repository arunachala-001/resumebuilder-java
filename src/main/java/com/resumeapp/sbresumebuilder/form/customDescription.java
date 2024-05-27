package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class customDescription {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String customDescription;
	
	public customDescription() {
		
	}
    @ManyToOne(fetch= FetchType.LAZY)
    @JsonIgnore
	private CustomSection customsection;
    
    
	
	public customDescription(int id, String customDescription) {
		super();
		this.id = id;
		this.customDescription = customDescription;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomDescription() {
		return customDescription;
	}

	public void setCustomDescription(String customDescription) {
		this.customDescription = customDescription;
	}

	public CustomSection getCustomsection() {
		return customsection;
	}

	public void setCustomsection(CustomSection customsection) {
		this.customsection = customsection;
	}
	
	public void setColumToremove(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "customDescription [id=" + id + ", customDescription=" + customDescription + "]";
	}
	
	
	

}
