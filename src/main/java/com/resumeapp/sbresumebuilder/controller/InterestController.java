package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.InterestData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.InterestDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class InterestController {

	private InterestData interestdata;
	private TemplateData templatedata;

	public InterestController(InterestData interestdata, TemplateData templatedata) {
		super();
		this.interestdata = interestdata;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/interest")
	public void createInterest(@RequestBody InterestDetails interest) {
		interestdata.save(interest);
	}
	
	@PostMapping("/form/interest/{id}")
	public void createInterestbyId(@PathVariable int id, @RequestBody InterestDetails interest) {
		Optional<staticTemplate> template = templatedata.findById(id);
		interest.setTemplate(template.get());
		interestdata.save(interest);
		
	}
	@GetMapping("/form/interest")
	public List<InterestDetails> getInterest() {
		return interestdata.findAll();
	}
	
	@GetMapping("/form/interest/{id}")
	public List<InterestDetails> getInterestbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getInterest();
		
	}
	
	@DeleteMapping("/form/interest/{id}")
	public void deleteInterest(@PathVariable int id) {
		interestdata.deleteById(id);
	}
}
