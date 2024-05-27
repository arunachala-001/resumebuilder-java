package com.resumeapp.sbresumebuilder.servicer;

import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.resumeapp.sbresumebuilder.database.CustomData;
import com.resumeapp.sbresumebuilder.database.CustomDescriptionData;
import com.resumeapp.sbresumebuilder.form.CustomSection;
import com.resumeapp.sbresumebuilder.form.customDescription;

@Service
public class CustomServicer {

	private CustomData custdata;
	private CustomDescriptionData custdescription;
	
	
	public CustomServicer(CustomData custdata, CustomDescriptionData custdescription) {
		super();
		this.custdata = custdata;
		this.custdescription = custdescription;
	}
	
	public List<Object> addTable() {
		List<CustomSection> table_1= custdata.findAll();
		
		
		List<customDescription> table_2 = custdescription.findAll();
		
//		for(customDescription description: table_2) {
//			description.setColumToremove(0);
//		}
//		
		for(CustomSection section: table_1) {
			section.setcolumToremove(null);
		}
		
		List<Object> combinedList = new ArrayList<>();
		combinedList.addAll(table_1);
		combinedList.addAll(table_2);
		
		return combinedList;
	}
	
}
