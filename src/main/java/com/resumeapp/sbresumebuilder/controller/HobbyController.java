package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.HobbyData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Hobbies;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class HobbyController {

	private HobbyData hobbydata;
	private TemplateData templatedata;

	public HobbyController(HobbyData hobbydata, TemplateData templatedata) {
		super();
		this.hobbydata = hobbydata;
		this. templatedata =  templatedata;
	}
	
	@PostMapping("/form/hobby")
	public void createHobby(@RequestBody Hobbies hobby) {
		hobbydata.save(hobby);
	}
	
	@PostMapping("/form/hobby/{id}")
	public void createHobbybyId(@PathVariable int id, @RequestBody Hobbies hobby) {
	  Optional<staticTemplate> template = templatedata.findById(id);
	  hobby.setTemplate(template.get());
	  hobbydata.save(hobby);
	  
	}
	
	@GetMapping("/form/hobby")
	public List<Hobbies> getHobby() {
	   return hobbydata.findAll();
	}
	
	@GetMapping("/form/hobby/{id}")
	public List<Hobbies> getHobbybyId(@PathVariable int id) {
	  Optional<staticTemplate> template = templatedata.findById(id);
	  return template.get().getHobby();
	  
	}
	
	@DeleteMapping("/form/hobby/{id}")
	public void deleteHobby(@PathVariable int id) {
		hobbydata.deleteById(id);
	}
}
