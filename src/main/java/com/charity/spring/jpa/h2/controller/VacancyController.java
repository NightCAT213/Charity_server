package com.charity.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;

import com.charity.spring.jpa.h2.model.Vacancy;
import com.charity.spring.jpa.h2.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")

public class VacancyController {

    @Autowired
    VacancyRepository vacancyRepository;

    @GetMapping("/vacancies")
    public ResponseEntity<List<Vacancy>> getAllVacancies(@RequestParam(required = false) String title) {
        try {
            List<Vacancy> vacancies = new ArrayList<Vacancy>();

            if (title == null)
                vacancyRepository.findAll().forEach(vacancies::add);
            else
                vacancyRepository.findByTitleContaining(title).forEach(vacancies::add);

            if (vacancies.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(vacancies, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
