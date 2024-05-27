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

import com.resumeapp.sbresumebuilder.database.ProjectDatabase;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.ProjectDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;


@RestController
public class ProjectController {
	
	private ProjectDatabase projectdata;
	private TemplateData templatedata;
	
	
	
	public ProjectController(ProjectDatabase projectdata, TemplateData templatedata) {
		super();
		this.projectdata = projectdata;
		this.templatedata=templatedata;
	}

	@GetMapping("/form/project")
	public List<ProjectDetails> getAllProject() {
		return projectdata.findAll();
	}
	
	@GetMapping("/form/project/{id}")
	public List<ProjectDetails> getAllProjectbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getProject();
	}
	
	@PostMapping("/form/project")
	public void createNew(@RequestBody ProjectDetails projectdetails) {
		projectdata.save(projectdetails);
		
	}
	
	@PostMapping("/form/project/{id}")
	public void createAllProjectbyId(@PathVariable int id, @RequestBody ProjectDetails projectdetails) {
		Optional<staticTemplate> template = templatedata.findById(id);
		projectdetails.setTemplate(template.get());
		projectdata.save(projectdetails);
	}
	
	@PutMapping("/form/project/{id}")
	public void updateData(@PathVariable int id, @RequestBody ProjectDetails projectupdate  ) {
		ProjectDetails data = projectdata.findById(id).orElse(null);
		data.setCompanyName(projectupdate.getCompanyName());
		data.setProjectName(projectupdate.getProjectName());
		data.setStartDate(projectupdate.getStartDate());
		data.setEndDate(projectupdate.getEndDate());
		data.setProjectDescription(projectupdate.getProjectDescription());
		
		projectdata.save(data);
	}
	@PutMapping("/form/project")
	public void updateAll(@RequestBody ProjectDetails dataAll) {
		projectdata.save(dataAll);
	}
	
	@DeleteMapping("/form/project/{id}")
	public void deleteById(@PathVariable int id) {
		projectdata.deleteById(id);
	}

}
