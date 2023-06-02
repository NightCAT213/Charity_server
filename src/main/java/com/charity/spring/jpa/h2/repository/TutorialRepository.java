package com.charity.spring.jpa.h2.repository;

import java.util.List;

import com.charity.spring.jpa.h2.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
  List<Tutorial> findByTitleContaining(String title);
}
