package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.SectionData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Section;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class sectionController {
	
	private SectionData sectionData;
	private TemplateData templatedata;
	
	
    
	public sectionController(SectionData sectionData, TemplateData templatedata) {
		super();
		this.sectionData = sectionData;
		this.templatedata=templatedata;
	}


    @GetMapping("/form")
	public List <Section> getAll() {
		return sectionData.findAll();
	}
    
    @GetMapping("/form/{id}")
	public List<Section> getbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getSection();
	}
    
//    @PostMapping("/form")
//    public void createSection(@RequestBody Section section) {
//    	sectionData.save(section);
//    }
    
    @PostMapping("/form/{id}")
    public void createSectionById(@PathVariable int id ,@RequestBody Section section) {
    	Optional<staticTemplate> template = templatedata.findById(id);
    	section.setTemplate(template.get());
    	sectionData.save(section);
    	
    }
    
    
    @PutMapping("/form/{id}")
    public void updateSection(@PathVariable int id ,@RequestBody Section section) {
    	Section sections = sectionData.findById(id).orElse(null);
    	
    	sections.setSectionName(section.getSectionName());
    	
    	sectionData.save(sections);
    	
    }
    
    @DeleteMapping("/form/{id}")
    public void deleteSection(@PathVariable int id) {
    	sectionData.deleteById(id);
    }
}
