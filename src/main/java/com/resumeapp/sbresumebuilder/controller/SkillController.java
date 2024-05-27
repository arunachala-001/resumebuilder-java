package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.SkillData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Skills;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class SkillController {

	private SkillData skilldata;
	private TemplateData templatedata;

	public SkillController(SkillData skilldata, TemplateData templatedata) {
		super();
		this.skilldata = skilldata;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/skill")
	public void createSkill(@RequestBody Skills skills) {
		skilldata.save(skills);
	}
	
	@PostMapping("/form/skill/{id}")
	public void createSkillbyId(@PathVariable int id, @RequestBody Skills skills) {
		Optional<staticTemplate> template = templatedata.findById(id);
		skills.setTemplate(template.get());
		skilldata.save(skills);
	}
	
	@GetMapping("/form/skill")
	public List<Skills> getSkill() {
		return skilldata.findAll();
	}
	
	@GetMapping("/form/skill/{id}")
	public List<Skills> getSkillbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getSkill();
	}
	
	@DeleteMapping("/form/skill/{id}")
	public void deleteSkill(@PathVariable int id) {
		skilldata.deleteById(id);
	}
	
}
