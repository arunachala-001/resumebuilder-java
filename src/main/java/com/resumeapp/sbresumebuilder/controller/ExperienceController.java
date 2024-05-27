package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.ExperienceData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.ExperienceDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class ExperienceController {

	private ExperienceData expdata;
	private TemplateData templatedata;

	public ExperienceController(ExperienceData expdata, TemplateData templatedata) {
		super();
		this.expdata = expdata;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/exp")
	public void createExperience(@RequestBody ExperienceDetails expdetails) {
		expdata.save(expdetails);
	}
	
	@PostMapping("/form/exp/{id}")
	public void createExperiencebyId(@PathVariable int id, @RequestBody ExperienceDetails expdetails) {
		Optional<staticTemplate> template = templatedata.findById(id);
		expdetails.setTemplate(template.get());
		expdata.save(expdetails);
		
		
 	}
	
	@GetMapping("/form/exp")
	public List<ExperienceDetails> getExperience() {
		return expdata.findAll();
	}
	
	@GetMapping("/form/exp/{id}")
	public List<ExperienceDetails> getExperiencebyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getExp();
		
 	}
	
	@PutMapping("/form/exp/{id}")
	public void updateExperience(@PathVariable int id,@RequestBody ExperienceDetails expdetails) {
	   ExperienceDetails exp = expdata.findById(id).orElse(null);
	   exp.setJobTittle(expdetails.getJobTittle());
	   exp.setCompanyName(expdetails.getCompanyName());
	   exp.setStartDate(expdetails.getStartDate());
	   exp.setEndDate(expdetails.getEndDate());
	   exp.setCity(expdetails.getCity());
	   exp.setDescription(expdetails.getDescription());
	   
	   expdata.save(exp);
		
	}
	
	@DeleteMapping("/form/exp/{id}")
	public void deleteExperience(@PathVariable int id) {
	   expdata.deleteById(id);
		
	}
	
	
}

