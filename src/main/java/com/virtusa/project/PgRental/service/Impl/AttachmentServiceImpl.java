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



//    @Override
//    public AttachmentDto saveAttachment(MultipartFile file, Long propertyId) throws IOException {
//        byte[] imageData = file.getBytes();
//        AttachmentDto attachmentDto = new AttachmentDto();
//        attachmentDto.setImage(imageData);
//        attachmentDto.setBase64Img(Base64.getEncoder().encodeToString(imageData));
//        attachmentDto.setPropertyId(propertyId);
//        return attachmentDao.saveAttachment(attachmentDto);
//    }

    @Override
    public AttachmentDto saveAttachment(MultipartFile file, Long propertyId) throws IOException {
        return null;
    }

    @Override
    public AttachmentDto getPropImgByPropertyId(long propertyId) {
//        return attachmentDao.getPropImgByPropertyId(propertyId);
        return null;
    }


}
