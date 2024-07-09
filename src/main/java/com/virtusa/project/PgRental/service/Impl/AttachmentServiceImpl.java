package com.virtusa.project.PgRental.service.impl;

import com.virtusa.project.PgRental.dao.AttachmentDao;
import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.repository.AttachmentRepository;
import com.virtusa.project.PgRental.service.AttachmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private AttachmentDao attachmentDao;

    private final AttachmentRepository attachmentRepository;


    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public AttachmentDto saveAttachment(MultipartFile file, Long propertyId) throws IOException {
        byte[] imageData = file.getBytes();
        AttachmentDto attachmentDto = new AttachmentDto();
        attachmentDto.setImage(imageData);
        attachmentDto.setBase64Img(Base64.getEncoder().encodeToString(imageData));
        attachmentDto.setPropertyId(propertyId);
        return attachmentDao.saveAttachment(attachmentDto);
    }

    @Override
    public AttachmentDto getPropImgByPropertyId(long propertyId) {
        return attachmentDao.getPropImgByPropertyId(propertyId);
    }

    @Override
    public List<AttachmentDto> saveMultipleAttachments(MultipartFile[] files, Long propertyId) throws IOException {
        List<AttachmentDto> attachmentDtos = new ArrayList<>();
        for (MultipartFile file : files) {
            byte[] imageData = file.getBytes();
            AttachmentDto attachmentDto = new AttachmentDto();
            attachmentDto.setImage(imageData);
            attachmentDto.setBase64Img(Base64.getEncoder().encodeToString(imageData));
            attachmentDto.setPropertyId(propertyId);
            attachmentDtos.add(attachmentDto);
        }
        return attachmentDao.saveMultipleAttachments(attachmentDtos);
    }

    @Override
    public List<AttachmentDto> getImagesByPropertyId(Long propertyId) {
        return attachmentDao.getImagesByPropertyId(propertyId);
    }
}