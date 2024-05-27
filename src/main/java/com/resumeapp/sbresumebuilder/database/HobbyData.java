package com.resumeapp.sbresumebuilder.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resumeapp.sbresumebuilder.form.Hobbies;

@Repository
public interface HobbyData extends JpaRepository<Hobbies, Integer> {

}
