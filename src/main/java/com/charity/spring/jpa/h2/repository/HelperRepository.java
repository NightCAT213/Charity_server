package com.charity.spring.jpa.h2.repository;

import java.util.List;

import com.charity.spring.jpa.h2.model.Helper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelperRepository extends JpaRepository<Helper, Long> {
    List<Helper> findByTitleContaining(String title);
}
