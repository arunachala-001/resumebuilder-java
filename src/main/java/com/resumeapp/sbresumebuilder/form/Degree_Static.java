package com.resumeapp.sbresumebuilder.form;

import org.springframework.stereotype.Component;

@Component
public class Degree_Static {

	private int id;
	private String degreeName;
	
	
	
	public Degree_Static() {
		
	}

	public Degree_Static(int id, String degreeName) {
		super();
		this.id = id;
		this.degreeName = degreeName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDegreeName() {
		return degreeName;
	}

	public void setDegreeName(String degreeName) {
		this.degreeName = degreeName;
	}

	@Override
	public String toString() {
		return "Degree_Static [id=" + id + ", degreeName=" + degreeName + "]";
	}
	
	
}
