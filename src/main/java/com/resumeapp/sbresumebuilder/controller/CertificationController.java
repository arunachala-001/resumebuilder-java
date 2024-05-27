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

import com.resumeapp.sbresumebuilder.database.CertificationData;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.Certification;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class CertificationController {

	private CertificationData certificationdata;
    private TemplateData templatedata;
	public CertificationController(CertificationData certificationdata, TemplateData templatedata) {
		super();
		this.certificationdata = certificationdata;
		this.templatedata=templatedata ;
	}
	
	@PostMapping("/form/certificate")
	public void createCertificate(@RequestBody Certification certification) {
		certificationdata.save(certification);
	}
	
	@PostMapping("/form/certificate/{id}")
	public void createCertificatebyId(@PathVariable int id, @RequestBody Certification certification) {
		Optional<staticTemplate> template = templatedata.findById(id);
		certification.setTemplate(template.get());
		certificationdata.save(certification);
	}
	
	@GetMapping("/form/certificate")
	public List<Certification> getCertificate() {
		return certificationdata.findAll();
	}
	
	@GetMapping("/form/certificate/{id}")
	public List<Certification> getCertificatebyId(@PathVariable int id) {
		Optional<staticTemplate> template = templatedata.findById(id);
		return template.get().getCertificate();
	}
	
	@PutMapping("/form/certificate/{id}")
	public void updateCertificate(@PathVariable int id, @RequestBody Certification certification) {
		Certification certificate = certificationdata.findById(id).orElse(null);
		certificate.setCourseTittle(certification.getCourseTittle());
	    certificate.setCourseDuration(certification.getCourseDuration());
		certificate.setDescription(certification.getDescription());
		
		certificationdata.save(certificate);
		
	}
	
	@DeleteMapping("/form/certificate/{id}")
	public void deleteCertificate(@PathVariable int id) {		
		certificationdata.deleteById(id);		
	}
}
