package com.virtusa.project.PgRental.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.service.AttachmentService;
import com.virtusa.project.PgRental.dao.AttachmentDao;

@RestController
public class AttachmentController {

    private final AttachmentService attachmentService;
    private final AttachmentDao attachmentDao;

    public AttachmentController(AttachmentService attachmentService, AttachmentDao attachmentDao) {
        this.attachmentService = attachmentService;
        this.attachmentDao = attachmentDao;
    }

    @PostMapping("/upload")
    public AttachmentDto uploadData(@RequestParam("file") MultipartFile file) {
        try {
            attachmentDao.createAttachment(file);
            String downloadURL = "http://localhost:8080/download/" + file.getOriginalFilename();
            return new AttachmentDto(file.getOriginalFilename(), downloadURL, file.getContentType(), file.getSize());
        } catch (Exception e) {
            e.printStackTrace();
            return new AttachmentDto(null, null, null, 0L);
        }
    }
}
