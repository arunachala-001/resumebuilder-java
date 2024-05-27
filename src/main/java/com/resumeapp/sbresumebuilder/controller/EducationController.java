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

import com.resumeapp.sbresumebuilder.database.Degree_Servicer;
import com.resumeapp.sbresumebuilder.database.SchoolData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.database.UgData;
import com.resumeapp.sbresumebuilder.form.Degree_Static;
import com.resumeapp.sbresumebuilder.form.SchoolDetails;
import com.resumeapp.sbresumebuilder.form.UGDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class EducationController {

	private Degree_Servicer degreeservice;
	private SchoolData schooldata;
	private UgData ugdata;
	private TemplateData templatedata;

	public EducationController(Degree_Servicer degreeservice, SchoolData schooldata, UgData ugdata, TemplateData templatedata) {
		super();
		this.degreeservice = degreeservice;
		this.schooldata = schooldata;
		this.ugdata = ugdata;
		this.templatedata=templatedata;
	}

    @GetMapping("/degree")
	public List<Degree_Static> getAll() {
		return degreeservice.retrieveAll();
	}
	
	@PostMapping("/form/school")
	public void createSchool(@RequestBody SchoolDetails school) {
		schooldata.save(school);
	}
	
	@PostMapping("/form/school/{id}")
	public void createSchoolbyId(@PathVariable int id, @RequestBody SchoolDetails school  ) {
		Optional<staticTemplate> template = templatedata.findById(id);
		school.setTemplate(template.get());
	    schooldata.save(school);
	}
	
	@GetMapping("/form/school")
	public List<SchoolDetails> getSchool() {
		return schooldata.findAll();
	}
	
	@GetMapping("/form/school/{id}")
	public List<SchoolDetails> getSchoolbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getSchool();
		
	}
	
	@PutMapping("/form/school/{id}")
	public void updateSchool(@PathVariable int id ,@RequestBody SchoolDetails school) {
		SchoolDetails details = schooldata.findById(id).orElse(null);
		
		details.setSchoolName(school.getSchoolName());
		details.setBoardName(school.getBoardName());
		details.setFieldName(school.getFieldName());
		details.setPercentage(school.getPercentage());
		details.setEndDate(school.getEndDate());
		details.setCityName(school.getCityName());
		details.setDescription(school.getDescription());
		
		schooldata.save(details);
	}

	@DeleteMapping("/form/school/{id}")
	public void deleteSchool(@PathVariable int id) {
		schooldata.deleteById(id);
	}
	
	//Ug Controller
	
	@PostMapping("/form/ug")
	public void createUG(@RequestBody UGDetails ugdetails) {
		ugdata.save(ugdetails);
	}
	
	@PostMapping("/form/ug/{id}")
	public void createUGbyId(@PathVariable int id, @RequestBody UGDetails ugdetails ) {
		Optional<staticTemplate> template = templatedata.findById(id);
		ugdetails.setTemplate(template.get());
	    ugdata.save(ugdetails);
	}
	
	@GetMapping("/form/ug")
	public List<UGDetails> getUG() {
		return ugdata.findAll();
	}
	
	@GetMapping("/form/ug/{id}")
	public List<UGDetails> getUGbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getUg();
	}
	
	@PutMapping("/form/ug/{id}")
	public void updateUG(@PathVariable int id ,@RequestBody UGDetails ug) {
		UGDetails details = ugdata.findById(id).orElse(null);
		
		details.setUniversityName(ug.getUniversityName());
		details.setFieldName(ug.getFieldName());
		details.setPercentage(ug.getPercentage());
		details.setEndDate(ug.getEndDate());
		details.setCity(ug.getCity());
		details.setDescription(ug.getDescription());
		
		ugdata.save(details);
	}

	@DeleteMapping("/form/ug/{id}")
	public void deleteUG(@PathVariable int id) {
		ugdata.deleteById(id);
	}

}
