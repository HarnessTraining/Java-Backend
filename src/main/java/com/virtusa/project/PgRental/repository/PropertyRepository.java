package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    // Add custom query methods if needed
}

