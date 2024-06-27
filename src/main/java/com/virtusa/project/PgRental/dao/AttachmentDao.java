package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;
import com.virtusa.project.PgRental.repository.AttachmentRepository;
import com.virtusa.project.PgRental.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AttachmentDao {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createAttachment(MultipartFile file,AttachmentDto attachmentDto) throws Exception {
        Attachment attachment = new Attachment();
        attachment.setFileName(file.getOriginalFilename());
        attachment.setFileType(file.getContentType());
        attachment.setData(file.getBytes());
        attachment.setProperty(propertyRepository.findById(attachmentDto.getPropertyId()).get());
        attachmentRepository.save(attachment);
    }

    public void updateAttachment(AttachmentDto attachmentDto) throws Exception {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentDto.getId());
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();
            attachment.setFileName(attachmentDto.getFileName());
            attachment.setFileType(attachmentDto.getFileType());
            attachment.setData(attachmentDto.getData());
            attachmentRepository.save(attachment);
        } else {
            throw new Exception("Attachment not found");
        }
    }

    public AttachmentDto getAttachmentDetails(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        return attachment.map(a -> modelMapper.map(a, AttachmentDto.class)).orElse(null);
    }

    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
    }

    public List<AttachmentDto> getAllAttachments() {
        List<Attachment> attachmentList = attachmentRepository.findAll();
        List<AttachmentDto> attachmentDtoList = new ArrayList<>();
        for (Attachment attachment : attachmentList) {
            AttachmentDto attachmentDto = modelMapper.map(attachment, AttachmentDto.class);
            attachmentDtoList.add(attachmentDto);
        }
        return attachmentDtoList;
    }
}
