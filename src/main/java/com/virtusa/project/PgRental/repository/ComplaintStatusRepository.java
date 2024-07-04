package com.virtusa.project.PgRental.repository;

import com.virtusa.project.PgRental.model.ComplaintStatuses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintStatusRepository extends JpaRepository<ComplaintStatuses, Long> {
}
