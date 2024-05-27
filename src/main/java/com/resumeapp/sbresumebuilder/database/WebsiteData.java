package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.Websites;

@Repository
public interface WebsiteData extends JpaRepository<Websites, Integer> {

}
