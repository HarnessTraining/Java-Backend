package com.virtusa.project.PgRental.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.virtusa.project.PgRental.dto.ComplaintUpdatesDTO;
import com.virtusa.project.PgRental.service.ComplaintsUpdatesService;

import java.util.List;

@RestController
@RequestMapping("/complaintUpdates")
public class ComplaintUpdatesController {
    
    @Autowired
    private ComplaintsUpdatesService complaintsService;

    @PostMapping
    public ResponseEntity<ComplaintUpdatesDTO> createComplaintUpdate(@RequestBody ComplaintUpdatesDTO complaintUpdateDTO) {
        System.out.println("controller: " + complaintUpdateDTO);
        ComplaintUpdatesDTO savedUpdate = complaintsService.saveComplaintUpdate(complaintUpdateDTO);
        return new ResponseEntity<>(savedUpdate, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ComplaintUpdatesDTO>> getAllComplaintUpdates() {
        List<ComplaintUpdatesDTO> updates = complaintsService.getAllComplaintUpdates();
        return new ResponseEntity<>(updates, HttpStatus.OK);
    }
}
