package com.charity.spring.jpa.h2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.charity.spring.jpa.h2.model.Helper;
import com.charity.spring.jpa.h2.repository.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class HelperController {

    @Autowired
    HelperRepository helperRepository;

    @GetMapping("/chelpers")
    public ResponseEntity<List<Helper>> getAllHelpers(@RequestParam(required = false) String title) {
        try {
            List<Helper> helpers = new ArrayList<Helper>();

            if (title == null)
                helperRepository.findAll().forEach(helpers::add);
            else
                helperRepository.findByTitleContaining(title).forEach(helpers::add);

            if (helpers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(helpers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    }