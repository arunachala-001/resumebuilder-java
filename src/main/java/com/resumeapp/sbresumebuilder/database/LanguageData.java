package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.LanguageDetails;

@Repository
public interface LanguageData extends JpaRepository<LanguageDetails, Integer> {

}
