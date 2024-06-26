package com.virtusa.project.PgRental.service.impl;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;
import com.virtusa.project.PgRental.repository.AttachmentRepository;
import com.virtusa.project.PgRental.service.AttachmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    ModelMapper modelMapper;

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public Attachment saveAttachment(MultipartFile file, AttachmentDto attachmentDto) throws Exception {
        return null;
    }

//    public Attachment saveAttachment(MultipartFile file,AttachmentDto attachmentDto) throws Exception {
//        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//        try {
//            if (fileName.contains("..")) {
//                throw new Exception("Filename contains invalid sequence: " + fileName);
//            }
//            Attachment attachment = new Attachment(fileName, file.getContentType(), file.getBytes(),attachmentDto);
//            return attachmentRepository.save(attachment);
//        } catch (Exception e) {
//            throw new Exception("Could not save file: " + fileName, e);
//        }
//    }
}
