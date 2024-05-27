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
public class ProjectDetails {
	
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false)
	private String projectName;
    @Column(nullable = false)
	private String companyName;
	private String projectDescription;
	@Column(nullable = false)
	private LocalDate startDate;
	@Column(nullable = false)
	private LocalDate endDate;
	
	public ProjectDetails() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;
	
	public ProjectDetails(int id, String projectName, String companyName, String projectDescription,
			LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.companyName = companyName;
		this.projectDescription = projectDescription;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
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

	@Override
	public String toString() {
		return "ProjectDetails [id=" + id + ", projectName=" + projectName + ", companyName=" + companyName
				+ ", projectDescription=" + projectDescription + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", template=" + template + "]";
	}

	
	
	
	
}
