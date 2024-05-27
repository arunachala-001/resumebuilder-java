package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.CustomData;
import com.resumeapp.sbresumebuilder.database.CustomDescriptionData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.CustomSection;
import com.resumeapp.sbresumebuilder.form.customDescription;
import com.resumeapp.sbresumebuilder.form.staticTemplate;
import com.resumeapp.sbresumebuilder.servicer.CustomServicer;

@RestController
public class CustomController {
    
	private CustomData custom;
	private CustomDescriptionData descriptiondata;
	private CustomServicer customservice;
	private TemplateData templatedata;
	
	public CustomController(CustomData custom, CustomDescriptionData descriptiondata, 
			CustomServicer customservice, TemplateData templatedata) {
		super();
		this.custom = custom;
		this.descriptiondata = descriptiondata;
		this.customservice = customservice;
		this.templatedata=templatedata;
	}
	
	@GetMapping("form/custom")
	public List<CustomSection> findAllCustom() {
		return custom.findAll();
	}
//	@GetMapping("form/custom/{id}")
//	public Optional<CustomSection> findAllCustombyId(@PathVariable int id) {
//		return custom.findById(id);
//	}
	
	@GetMapping("form/template/custom/{id}")
	public List<CustomSection> findByCustomId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getCustom();
	}
	
	@GetMapping("form/custom/{temp_id}/{id}")
	public CustomSection findBytemplateId(@PathVariable int temp_id ,@PathVariable int id) {
//		return custom.findById(id);
		Optional<staticTemplate> template = templatedata.findById(temp_id);
		//CustomSection customsection = new CustomSection();
		return template.get().getCustom().get(id-1);
		
	}
	
    @PostMapping("form/custom/{id}")
    public void createSection(@PathVariable int id ,@RequestBody CustomSection customsection) {
    	Optional<staticTemplate> template = templatedata.findById(id);
    	customsection.setTemplate(template.get());
    	custom.save(customsection);
    }
    
    @GetMapping("form/custom/description/{id}")
	public List<customDescription> findByIdDes( @PathVariable int id) {
		Optional<CustomSection> customsection = custom.findById(id);
		return customsection.get().getCustomdescription();
	}
	
	
	@PostMapping("form/custom/description/{id}")
	public void
	  createDescription(@PathVariable int id, @RequestBody customDescription customdesc) {
		
		  Optional<CustomSection> customsection = custom.findById(id);
		  customdesc.setCustomsection(customsection.get());
		  descriptiondata.save(customdesc);
	}
	
	@DeleteMapping("form/custom/description/{id}")
	public void
	  deleteDescription(@PathVariable int id) {
	  descriptiondata.deleteById(id);
	}
    
	@GetMapping("form/customall")
	public List<Object> getAll() {
		return customservice.addTable();
	}
}
