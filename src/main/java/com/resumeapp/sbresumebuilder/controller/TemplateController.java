package com.resumeapp.sbresumebuilder.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class TemplateController {

	private TemplateData templatedata;

	public TemplateController(TemplateData templatedata) {
		super();
		this.templatedata = templatedata;
	}
	
	@GetMapping("/home/template")
	public List<staticTemplate> getAll() {
		return templatedata.findAll();
	}
}
