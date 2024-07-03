package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.virtusa.project.PgRental.model.Attachment;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    @Query("Select a from Attachment a where a.propertyId= :propertyId")
    Attachment findPropByPropertyId(long propertyId);
}
