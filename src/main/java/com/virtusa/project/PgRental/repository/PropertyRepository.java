package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    // Add custom query methods if needed
    List<Property> findByIsApproved(boolean isApproved);
}

