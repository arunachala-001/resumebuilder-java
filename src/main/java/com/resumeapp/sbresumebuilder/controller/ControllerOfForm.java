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

import com.resumeapp.sbresumebuilder.database.ContactInfo;
import com.resumeapp.sbresumebuilder.database.TemplateData;
import com.resumeapp.sbresumebuilder.form.ContactOfUser;
import com.resumeapp.sbresumebuilder.form.staticTemplate;

@RestController
public class ControllerOfForm {
	
	private ContactInfo contactinformation;
	private TemplateData templates;
	
	public ControllerOfForm(ContactInfo contactinformation, TemplateData templates) {
		super();
		this.contactinformation = contactinformation;
		this.templates = templates;
	}

	@GetMapping("/")
	public String callWelcomePage() {
		return "Hello User Welcome to My Resume Backend";
	}
	
	@GetMapping("/form/contact")
	public List<ContactOfUser> retriveAll() {
		return contactinformation.findAll();
	}
	
	@GetMapping("/form/contact/{id}")
	public List<ContactOfUser> retrivecontactbyId(@PathVariable int id) {
		Optional<staticTemplate> template = templates.findById(id);
		return template.get().getContact();
		
	}
	
	@PostMapping("/form/contact")
	public void createContact(@RequestBody ContactOfUser contactuser) {
		 contactinformation.save(contactuser);
	}
	
	@PostMapping("/form/contact/{id}")
	public void createContact(@PathVariable int id,@RequestBody ContactOfUser contactuser) {
//		 contactinformation.save(contactuser);
		Optional<staticTemplate> template = templates.findById(id);
		contactuser.setTemplate(template.get());
		contactinformation.save(contactuser);
	}
	
	@DeleteMapping("/form/contact/{id}")
	public void DeleteContact(@PathVariable int id) {
		 contactinformation.deleteById(id);
	}
	
	@PutMapping("/form/contact/{id}")
	public void updateData(@PathVariable int id ,@RequestBody ContactOfUser contactuser) {
		ContactOfUser user = contactinformation.findById(id).orElse(null);
		user.setFirstName(contactuser.getFirstName());
		user.setLastName(contactuser.getLastName());
		user.setCity(contactuser.getCity());
		user.setCountry(contactuser.getCountry());
		user.setDateOfBirth(contactuser.getDateOfBirth());
		user.setEmail(contactuser.getEmail());
		user.setGender(contactuser.getGender());
		user.setMaritalStatus(contactuser.getMaritalStatus());
		user.setNationality(contactuser.getNationality());
		user.setPhoneNumber(contactuser.getPhoneNumber());
		user.setState(contactuser.getState());
		
		contactinformation.save(user);
	}
}
