package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dao.AttachmentDao;
import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.service.AttachmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/attach")
public class AttachmentController {

    private final AttachmentService attachmentService;
    private final AttachmentDao attachmentDao;

    public AttachmentController(AttachmentService attachmentService, AttachmentDao attachmentDao) {
        this.attachmentService = attachmentService;
        this.attachmentDao = attachmentDao;
    }

    // @PostMapping("/upload")
    // public ResponseEntity<String> uploadData(@RequestParam("file") MultipartFile file, @RequestParam("propertyId") Long propertyId) {
    //     try {
    //         AttachmentDto attachmentDto = new AttachmentDto();
    //         attachmentDto.setPropertyDto(propertyId);
    //         // Set other fields of attachmentDto if needed
    //         attachmentDao.createAttachment(file, attachmentDto);
    //         String downloadURL = "http://localhost:8080/download/" + file.getOriginalFilename();

    //         return ResponseEntity.ok("File uploaded successfully");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
    //     }
    // }
    @PostMapping(value = "/upload", consumes = { "multipart/form-data" }, produces = { "application/json" })
    public ResponseEntity<AttachmentDto> uploadData(@RequestParam("file") MultipartFile file, @RequestParam("propertyId") Long propertyId) {
        try {
            AttachmentDto attachmentDto = attachmentService.saveAttachment(file, propertyId);
            return ResponseEntity.ok(attachmentDto);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getPropImg/{propertyId}")
public ResponseEntity<AttachmentDto> getPropImgByPropertyId(@PathVariable("propertyId") long propertyId) {
    AttachmentDto attachmentDto = attachmentService.getPropImgByPropertyId(propertyId);
    if (attachmentDto != null) {
        return ResponseEntity.ok(attachmentDto);
    } else {
        return ResponseEntity.notFound().build();
    }
}
}
