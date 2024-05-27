package com.resumeapp.sbresumebuilder.form;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Objective {
    @Id
    @GeneratedValue
	private int id;
    @Column(nullable = false, length=500)
	private String objectives;
	
	public Objective() {
		super();
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;

	public Objective(int id, String objectives) {
		super();
		this.id = id;
		this.objectives = objectives;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getObjectives() {
		return objectives;
	}

	public void setObjectives(String objectives) {
		this.objectives = objectives;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	@Override
	public String toString() {
		return "Objective [id=" + id + ", objectives=" + objectives + ", template=" + template + "]";
	}

	
	
	
}
