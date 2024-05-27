package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.Section;

@Repository
public interface SectionData extends JpaRepository <Section, Integer> {
	
}
