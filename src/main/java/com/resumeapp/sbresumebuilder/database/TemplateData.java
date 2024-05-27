package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.staticTemplate;

@Repository
public interface TemplateData extends JpaRepository<staticTemplate, Integer> {

}
