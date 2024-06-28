package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file, AttachmentDto attachmentDto) throws Exception;
}
