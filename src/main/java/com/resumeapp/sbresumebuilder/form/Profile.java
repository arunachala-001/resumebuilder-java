package com.resumeapp.sbresumebuilder.form;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

@Entity
public class Profile {
    @Id
    @GeneratedValue
	private int id;
    
    @Lob
	private byte[] profileData;

	public Profile() {
		
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private staticTemplate template;
	

	public Profile(int id, byte[] profileData) {
		super();
		this.id = id;
		this.profileData = profileData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public staticTemplate getTemplate() {
		return template;
	}

	public void setTemplate(staticTemplate template) {
		this.template = template;
	}

	public byte[] getProfileData() {
		return profileData;
	}

	public void setProfileData(byte[] profileData) {
		this.profileData = profileData;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", profileData=" + Arrays.toString(profileData) + ", template=" + template + "]";
	}

	
    
}
