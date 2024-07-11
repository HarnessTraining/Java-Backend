package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.virtusa.project.PgRental.model.ComplaintUpdates;

@Repository
public interface ComplaintsUpdatesRepo extends JpaRepository<ComplaintUpdates, Long> {

    
    
}
