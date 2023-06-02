package com.charity.spring.jpa.h2.repository;

import java.util.List;

import com.charity.spring.jpa.h2.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByTitleContaining(String title);
}
