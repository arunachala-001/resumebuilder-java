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
public class ExperienceDetails {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String jobTittle;
    @Column(nullable = false)
	private String companyName;
    @Column(nullable = false)
	private LocalDate startDate;
    @Column(nullable = false)
	private LocalDate endDate;
    @Column(nullable = false)
	private String city;
	private String description;
	
	public ExperienceDetails() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public ExperienceDetails(int id, String jobTittle, String companyName, LocalDate startDate, LocalDate endDate,
			String city, String description) {
		super();
		this.id = id;
		this.jobTittle = jobTittle;
		this.companyName = companyName;
		this.startDate = startDate;
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

	public String getJobTittle() {
		return jobTittle;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public void setJobTittle(String jobTittle) {
		this.jobTittle = jobTittle;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
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
		return "ExperienceDetails [id=" + id + ", jobTittle=" + jobTittle + ", companyName=" + companyName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", city=" + city + ", description="
				+ description + ", template=" + template + "]";
	}

	
	
	
	
}
