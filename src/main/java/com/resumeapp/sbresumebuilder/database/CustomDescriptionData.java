package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.customDescription;

@Repository
public interface CustomDescriptionData extends JpaRepository <customDescription, Integer>{

}
