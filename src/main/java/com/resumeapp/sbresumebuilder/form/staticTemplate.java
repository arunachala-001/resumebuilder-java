package com.resumeapp.sbresumebuilder.form;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class staticTemplate {
    @Id
    @GeneratedValue
	private int id;
	private String templateName;
	
	@Lob
	private byte[] imageData;
	
	
	public staticTemplate() {
	
	}
	
	public staticTemplate(int id, String templateName, byte[] imageData) {
		super();
		this.id = id;
		this.templateName = templateName;
		this.imageData = imageData;
	}
	
	@OneToMany(mappedBy="template")
	private List<ContactOfUser> contact;
	@OneToMany(mappedBy="template")
	private List<Objective> object;
	@OneToMany(mappedBy="template")
	private List<AwardsDetails> award;
	@OneToMany(mappedBy="template")
	private List<ExperienceDetails> exp;
	@OneToMany(mappedBy="template")
	private List<Hobbies> hobby;
	@OneToMany(mappedBy="template")
	private List<InterestDetails> interest;
	@OneToMany(mappedBy="template")
	private List<LanguageDetails> lang;
	@OneToMany(mappedBy="template")
	private List<Profile> profile;
	@OneToMany(mappedBy="template")
	private List<ProjectDetails> project;
	@OneToMany(mappedBy="template")
	private List<SchoolDetails> school;
	@OneToMany(mappedBy="template")
	private List<Section> section;
	@OneToMany(mappedBy="template")
	private List<Skills> skill;
	@OneToMany(mappedBy="template")
	private List<UGDetails> ug;
	@OneToMany(mappedBy="template")
	private List<Certification> certificate;
	@OneToMany(mappedBy="template")
	private List<CustomSection> custom;
	@OneToMany(mappedBy="template")
	private List<Websites> website;


	public List<Objective> getObject() {
		return object;
	}


	public List<Certification> getCertificate() {
		return certificate;
	}


	public void setCertificate(List<Certification> certificate) {
		this.certificate = certificate;
	}


	public void setObject(List<Objective> object) {
		this.object = object;
	}


	public List<AwardsDetails> getAward() {
		return award;
	}


	public List<Websites> getWebsite() {
		return website;
	}


	public void setWebsite(List<Websites> website) {
		this.website = website;
	}


	public void setAward(List<AwardsDetails> award) {
		this.award = award;
	}


	public List<ExperienceDetails> getExp() {
		return exp;
	}


	public void setExp(List<ExperienceDetails> exp) {
		this.exp = exp;
	}


	public List<Hobbies> getHobby() {
		return hobby;
	}


	public void setHobby(List<Hobbies> hobby) {
		this.hobby = hobby;
	}


	public List<InterestDetails> getInterest() {
		return interest;
	}


	public void setInterest(List<InterestDetails> interest) {
		this.interest = interest;
	}


	public List<LanguageDetails> getLang() {
		return lang;
	}


	public void setLang(List<LanguageDetails> lang) {
		this.lang = lang;
	}


	public List<Profile> getProfile() {
		return profile;
	}


	public void setProfile(List<Profile> profile) {
		this.profile = profile;
	}


	public List<ProjectDetails> getProject() {
		return project;
	}


	public void setProject(List<ProjectDetails> project) {
		this.project = project;
	}


	public List<SchoolDetails> getSchool() {
		return school;
	}


	public void setSchool(List<SchoolDetails> school) {
		this.school = school;
	}


	public List<Section> getSection() {
		return section;
	}


	public void setSection(List<Section> section) {
		this.section = section;
	}


	public List<Skills> getSkill() {
		return skill;
	}


	public void setSkill(List<Skills> skill) {
		this.skill = skill;
	}


	public List<UGDetails> getUg() {
		return ug;
	}


	public void setUg(List<UGDetails> ug) {
		this.ug = ug;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTemplateName() {
		return templateName;
	}


	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}


	public byte[] getImageData() {
		return imageData;
	}


	public void setImageData(byte[] imageData) {
		this.imageData = imageData;
	}

	

	public List<ContactOfUser> getContact() {
		return contact;
	}


	public void setContact(List<ContactOfUser> contact) {
		this.contact = contact;
	}


	public List<CustomSection> getCustom() {
		return custom;
	}


	public void setCustom(List<CustomSection> custom) {
		this.custom = custom;
	}


	@Override
	public String toString() {
		return "staticTemplate [id=" + id + ", templateName=" + templateName + ", imageData="
				+ Arrays.toString(imageData) + ", contact=" + contact + ", object=" + object + ", award=" + award
				+ ", exp=" + exp + ", hobby=" + hobby + ", interest=" + interest + ", lang=" + lang + ", profile="
				+ profile + ", project=" + project + ", school=" + school + ", section=" + section + ", skill=" + skill
				+ ", ug=" + ug + ", certificate=" + certificate + ", custom=" + custom + "]";
	}


	




	


	
	

			
	
}
