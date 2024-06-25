package com.virtusa.project.PgRental.service;

import org.springframework.web.multipart.MultipartFile;
import com.virtusa.project.PgRental.model.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file) throws Exception;
}
