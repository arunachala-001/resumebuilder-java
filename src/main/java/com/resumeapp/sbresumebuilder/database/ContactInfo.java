package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.ContactOfUser;


@Repository
public interface ContactInfo extends JpaRepository <ContactOfUser, Integer> {

}
