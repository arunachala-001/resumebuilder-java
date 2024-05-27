package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.CustomSection;

@Repository
public interface CustomData extends JpaRepository<CustomSection, Integer> {

}
