package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.SchoolDetails;

@Repository
public interface SchoolData extends JpaRepository<SchoolDetails, Integer> {

}
