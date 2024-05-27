package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.database.WebsiteData;
import com.resumeapp.sbresumebuilder.form.Websites;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class WebController {

	private TemplateData templatedata;
	private WebsiteData webdata;
	
	public WebController(TemplateData templatedata, WebsiteData webdata) {
		super();
		this.templatedata =templatedata;
		this.webdata = webdata;
	}
	
	@PostMapping("/form/web/{id}")
	public void createWeb(@PathVariable int id, @RequestBody Websites website) {
		Optional<staticTemplate> template = templatedata.findById(id);
		website.setTemplate(template.get());
		webdata.save(website);
		
	}
	
	@GetMapping("/form/web/{id}")
	public List<Websites> getAllweb(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getWebsite();
	}
	
	@DeleteMapping("/form/web/{id}")
	public void Deleteweb(@PathVariable int id) {
		webdata.deleteById(id);
	}
}
