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
public class SchoolDetails {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String schoolName;
	private String boardName;
	@Column(nullable = false)
	private String fieldName;
	@Column(nullable = false)
	private float percentage;
	@Column(nullable = false)
	private LocalDate endDate;
	@Column(nullable = false)
	private String cityName;
	private String description;
	
	public SchoolDetails() {
		
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public SchoolDetails(int id, String schoolName, String boardName, String fieldName, float percentage, LocalDate endDate, String cityName, String description) {
		super();
		this.id = id;
		this.schoolName = schoolName;
		this.boardName = boardName;
		this.fieldName = fieldName;
		this.percentage = percentage;
		this.endDate = endDate;
		this.cityName = cityName;
		this.description = description;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public staticTemplate getTemplate() {
		return template;
	}


	public void setTemplate(staticTemplate template) {
		this.template = template;
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


	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "SchoolDetails [id=" + id + ", schoolName=" + schoolName + ", boardName=" + boardName + ", fieldName="
				+ fieldName + ", percentage=" + percentage + ", endDate=" + endDate + ", cityName=" + cityName
				+ ", description=" + description + ", template=" + template + "]";
	}


	

	

	
	
	
	
}
