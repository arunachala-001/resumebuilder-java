package com.resumeapp.sbresumebuilder.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.LanguageData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.LanguageDetails;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class LanguageController {

	private LanguageData langdata;
	private TemplateData templatedata;

	public LanguageController(LanguageData langdata, TemplateData templatedata) {
		super();
		this.langdata = langdata;
		this.templatedata=templatedata;
	}
	
	@PostMapping("/form/language")
	public void createLang(@RequestBody LanguageDetails langdetails) {
		langdata.save(langdetails);
	}
	
	@PostMapping("/form/language/{id}")
	public void createLangbyId(@PathVariable int id, @RequestBody LanguageDetails langdetails) {
		Optional<staticTemplate> template = templatedata.findById(id);
		langdetails.setTemplate(template.get());
		langdata.save(langdetails);
	}
	
	@GetMapping("/form/language")
	public List<LanguageDetails> getLang() {
		return langdata.findAll();
	}
	
	@GetMapping("/form/language/{id}")
	public List<LanguageDetails> getLangbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getLang();
	}
	
	@DeleteMapping("/form/language/{id}")
	public void deleteLang(@PathVariable int id) {
		langdata.deleteById(id);
	}
}
