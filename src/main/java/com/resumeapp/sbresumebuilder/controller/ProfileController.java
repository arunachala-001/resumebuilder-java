package com.resumeapp.sbresumebuilder.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.resumeapp.sbresumebuilder.database.ProfileData;
import com.resumeapp.sbresumebuilder.database.ProfileServicer;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Profile;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
@RequestMapping("/image")
public class ProfileController {

	private ProfileServicer service;
	private ProfileData profiledata;
	private TemplateData templatedata;
	

	public ProfileController(ProfileServicer service, ProfileData profiledata, TemplateData templatedata) {
		super();
		this.service = service;
		this.profiledata = profiledata;
		this.templatedata=templatedata;
	}
	
	@PostMapping(value="/{id}",consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImage(@PathVariable int id,@RequestParam("image") MultipartFile image) {
		try {
			service.storeImage(id, image);
			return ResponseEntity.ok().build();
		} catch(IOException e) {
			return ResponseEntity.badRequest().body("Error in uploading Image");
		}
	}
	
	@PutMapping(value="/{id}",consumes = "multipart/form-data")
	public ResponseEntity<?> updateProfile(@PathVariable int id ,@RequestParam("image") MultipartFile image
			 ) {
		try {
			service.updateImage(image, id);
			return ResponseEntity.ok().build();
		} catch(IOException e) {
			return ResponseEntity.badRequest().body("Error in uploading Image");
		}
	}
	
	@GetMapping("/{id}")
	public List<Profile> getAll(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getProfile();
	}
}
