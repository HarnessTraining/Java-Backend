package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    // Attachment saveAttachment(MultipartFile file, AttachmentDto attachmentDto) throws Exception;

    AttachmentDto saveAttachment(MultipartFile file, Long propertyId) throws IOException;

    AttachmentDto getPropImgByPropertyId(long propertyId);

    List<AttachmentDto> saveMultipleAttachments(MultipartFile[] files, Long propertyId) throws IOException;
    List<AttachmentDto> getImagesByPropertyId(Long propertyId);
}

