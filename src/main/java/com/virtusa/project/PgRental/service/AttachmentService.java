package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    // Attachment saveAttachment(MultipartFile file, AttachmentDto attachmentDto) throws Exception;

    AttachmentDto saveAttachment(MultipartFile file, Long propertyId) throws IOException;

    AttachmentDto getPropImgByPropertyId(long propertyId);
}
