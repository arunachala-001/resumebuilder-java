package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.ObjectData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Objective;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class ObjectController {

	private ObjectData objectdata;
	private TemplateData templatedata;

	public ObjectController(ObjectData objectdata, TemplateData templatedata) {
		super();
		this.objectdata = objectdata;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/objective")
	public void createObject(@RequestBody Objective obj) {
		objectdata.save(obj);
	}
	
	@PostMapping("/form/objective/{id}")
	public void createObjectbyId(@PathVariable int id, @RequestBody Objective obj) {
		Optional<staticTemplate> template = templatedata.findById(id);
		obj.setTemplate(template.get());
		objectdata.save(obj);
		
	}
	
	@GetMapping("/form/objective")
	public List<Objective> getObject() {
		return objectdata.findAll();
	}
	
	@GetMapping("/form/objective/{id}")
	public List<Objective> getObjectbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getObject();
		
	}
	
	@PutMapping("/form/objective/{id}")
	public void updateObject(@PathVariable int id ,@RequestBody Objective obj) {
	   Objective objective = objectdata.findById(id).orElse(null);
	   objective.setObjectives(obj.getObjectives());
	   
	   objectdata.save(objective);
	   
	}
}
