package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.Certification;

@Repository
public interface CertificationData extends JpaRepository<Certification, Integer> {

}
