package com.virtusa.project.PgRental.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.virtusa.project.PgRental.model.Attachment;
import com.virtusa.project.PgRental.repository.AttachmentRepository;
import com.virtusa.project.PgRental.service.AttachmentService;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file) throws Exception {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new Exception("Filename contains invalid sequence: " + fileName);
            }
            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes());
            return attachmentRepository.save(attachment);
        } catch (Exception e) {
            throw new Exception("Could not save file: " + fileName, e);
        }
    }
}
