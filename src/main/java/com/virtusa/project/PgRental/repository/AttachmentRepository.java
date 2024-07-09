package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.virtusa.project.PgRental.model.Attachment;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    @Query(value = "Select * from attachment where property_id= :propertyId LIMIT 1",nativeQuery = true)
    Attachment findPropByPropertyId(@RequestParam("propertyId") long propertyId);

    List<Attachment> findByPropertyId(Long propertyId);
}
