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
public class UGDetails {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String universityName;
    @Column(nullable = false)
	private String fieldName;
    @Column(nullable = false)
	private float percentage;
    @Column(nullable = false)
	private LocalDate endDate;
    @Column(nullable = false)
	private String city;
	private String description;
	
	public UGDetails() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public UGDetails(int id, String universityName, String fieldName, float percentage,
			 LocalDate endDate, String city, String description) {
		super();
		this.id = id;
		this.universityName = universityName;
		this.fieldName = fieldName;
		this.percentage = percentage;
		this.endDate = endDate;
		this.city = city;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public float getPercentage() {
		return percentage;
	}

	public void setPercentage(float percentage) {
		this.percentage = percentage;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "UGDetails [id=" + id + ", universityName=" + universityName + ", fieldName=" + fieldName
				+ ", percentage=" + percentage + ", endDate=" + endDate + ", city=" + city + ", description="
				+ description + ", template=" + template + "]";
	}
	
	

	

	

		
}
