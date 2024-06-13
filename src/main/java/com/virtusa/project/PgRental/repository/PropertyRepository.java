package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.project.PgRental.model.Property;

public interface PropertyRepository extends JpaRepository<Property,Long> {
    
}
