package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.UGDetails;

@Repository
public interface UgData extends JpaRepository<UGDetails, Integer> {

}
