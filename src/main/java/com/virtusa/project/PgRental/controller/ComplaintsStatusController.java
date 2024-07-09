package com.virtusa.project.PgRental.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.virtusa.project.PgRental.dto.ComplaintStatusDTO;
import com.virtusa.project.PgRental.service.ComplaintsStatusServices;

@RestController
@RequestMapping("/complaints")
public class ComplaintsStatusController {

    @Autowired
    private ComplaintsStatusServices complaintStatusService;

    @GetMapping
    public ResponseEntity<List<ComplaintStatusDTO>> getAllComplaintStatuses() {
        List<ComplaintStatusDTO> statuses = complaintStatusService.getAllComplaintStatuses();
        return ResponseEntity.ok(statuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComplaintStatusDTO> getComplaintStatusById(@PathVariable long id) {
        ComplaintStatusDTO status = complaintStatusService.getComplaintStatusById(id);
        return ResponseEntity.ok(status);
    }

    @PostMapping
    public ResponseEntity<ComplaintStatusDTO> createComplaintStatus(
            @RequestBody ComplaintStatusDTO complaintStatusDTO) {
        ComplaintStatusDTO createdStatus = complaintStatusService.createComplaintStatus(complaintStatusDTO);
        return ResponseEntity.ok(createdStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComplaintStatusDTO> updateComplaintStatus(@PathVariable long id,
            @RequestBody ComplaintStatusDTO complaintStatusDTO) {
        ComplaintStatusDTO updatedStatus = complaintStatusService.updateComplaintStatus(id, complaintStatusDTO);
        return ResponseEntity.ok(updatedStatus);
    }
}
