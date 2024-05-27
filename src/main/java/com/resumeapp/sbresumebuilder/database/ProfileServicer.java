package com.resumeapp.sbresumebuilder.database;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.resumeapp.sbresumebuilder.form.Profile;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@Service
public class ProfileServicer {

	private ProfileData profiledata;
	private TemplateData templatedata;
	
	
	public ProfileServicer(ProfileData profiledata, TemplateData templatedata) {
		super();
		this.profiledata = profiledata;
		this.templatedata=templatedata;
	}


	public void storeImage(int id, MultipartFile image) throws IOException {
//		byte[] profileData = image.getBytes();
//		//Profile profile = new Profile();
//		Optional<staticTemplate> template = templatedata.findById(id);
//		Profile profile = new Profile();
//		profile.setTemplate(template.get());
//		//profile.setProfileData(profileData);
//		
//		profiledata.save(profile);
		Optional<staticTemplate> template = templatedata.findById(id);
		byte[] profileData = image.getBytes();
		Profile profile = new Profile();
		profile.setProfileData(profileData);
		profile.setTemplate(template.get());
		profiledata.save(profile);
	}
	
	public void updateImage(MultipartFile image, int id) throws IOException {
		byte[] profileData = image.getBytes();
		Profile profile = profiledata.findById(id).orElse(null);
		
		profile.setProfileData(profileData);
		
		//profile.setProfileData(profileData);
		
		profiledata.save(profile);
	}
}
