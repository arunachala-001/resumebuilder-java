package com.resumeapp.sbresumebuilder.database;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.resumeapp.sbresumebuilder.form.Degree_Static;

@Service
public class Degree_Servicer {

	private static List<Degree_Static> degree = new ArrayList<>();
	
	static {
		degree.add(new Degree_Static(1, "BE - Bachelor of Engineering"));
		degree.add(new Degree_Static(2, "BTech - Bachelor of Technology"));
		degree.add(new Degree_Static(3, "ME - Master of Engineering"));
		degree.add(new Degree_Static(4, "MTech - Master of Technology"));
		degree.add(new Degree_Static(5, "PhD - Doctor of Philosophy"));
		degree.add(new Degree_Static(6, "MS - Master of Science"));
		degree.add(new Degree_Static(7, "MSc - Master of Science"));
		degree.add(new Degree_Static(8, "MBA - Master of Business Administration"));
		degree.add(new Degree_Static(9, "MCA - Master of Computer Applications"));
		degree.add(new Degree_Static(10, "BArch - Bachelor of Architecture"));
		degree.add(new Degree_Static(11, "MArch - Master of Architecture"));
		degree.add(new Degree_Static(12, "BSc - Bachelor of Science"));
		degree.add(new Degree_Static(13, "MSc - Master of Science"));
		degree.add(new Degree_Static(14, "BBA - Bachelor of Business Administration"));
		degree.add(new Degree_Static(15, "LLB - Bachelor of Laws"));
		degree.add(new Degree_Static(16, "LLM - Master of Laws"));
		degree.add(new Degree_Static(17, "BPharm - Bachelor of Pharmacy"));
		degree.add(new Degree_Static(18, "MPharm - Master of Pharmacy"));
		degree.add(new Degree_Static(19, "BDS - Bachelor of Dental Surgery"));
		degree.add(new Degree_Static(20, "MD - Doctor of Medicine"));

		
	}
	
	public List<Degree_Static> retrieveAll() {
		return degree;
	}
}
