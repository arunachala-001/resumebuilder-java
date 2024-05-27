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

import com.resumeapp.sbresumebuilder.database.AwardsDataBase;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.AwardsDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class AwardsController {

	private AwardsDataBase awardData;
	private TemplateData templatedata;

	public AwardsController(AwardsDataBase awardData, TemplateData templatedata) {
		super();
		this.awardData = awardData;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/award")
	public void createAward(@RequestBody AwardsDetails awards) {
		awardData.save(awards);
	}
	
	@PostMapping("/form/award/{id}")
	public void createAwardbyId(@PathVariable int id ,@RequestBody AwardsDetails awards) {
		Optional<staticTemplate> template = templatedata.findById(id);
		awards.setTemplate(template.get());
		awardData.save(awards);
	}
	
	@GetMapping("/form/award")
	public List<AwardsDetails> getAll() {
		return awardData.findAll();
	}
	
	@GetMapping("/form/award/{id}")
	public List<AwardsDetails> getAllbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getAward();
	}
	
	@DeleteMapping("/form/award/{id}")
	public void DeleteAward(@PathVariable int id) {
		awardData.deleteById(id);
	}
	
	@PutMapping("/form/award/{id}")
	public void updateAward(@PathVariable int id, @RequestBody AwardsDetails awards) {
		AwardsDetails award = awardData.findById(id).orElse(null);
		award.setTittle(awards.getTittle());
		award.setDescription(awards.getDescription());
		
		awardData.save(award);
	}
}
