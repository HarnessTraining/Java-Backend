package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.AttachmentDto;
import com.virtusa.project.PgRental.model.Attachment;
import com.virtusa.project.PgRental.repository.AttachmentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttachmentDao {

    @Autowired
    private AttachmentRepository attachmentRepository;


    @Autowired
    private ModelMapper modelMapper;

//     public void createAttachment(MultipartFile file, AttachmentDto attachmentDto) throws Exception {
//         Attachment attachment = new Attachment();
//         attachment.setFileName(file.getOriginalFilename());
//         attachment.setFileType(file.getContentType());
//         attachment.setData(file.getBytes());
//         attachment.setProperty(propertyRepository.findById(attachmentDto.getPropertyId()).get());
//         attachmentRepository.save(attachment);
//     }

//     public void updateAttachment(AttachmentDto attachmentDto) throws Exception {
//         Optional<Attachment> optionalAttachment = attachmentRepository.findById(attachmentDto.getId());
//         if (optionalAttachment.isPresent()) {
//             Attachment attachment = optionalAttachment.get();
//             attachment.setFileName(attachmentDto.getFileName());
//             attachment.setFileType(attachmentDto.getFileType());
//             attachment.setData(attachmentDto.getData());
//             attachmentRepository.save(attachment);
//         } else {
//             throw new Exception("Attachment not found");
//         }
//     }

//     public AttachmentDto getAttachmentDetails(Long id) {
//         Optional<Attachment> attachment = attachmentRepository.findById(id);
//         return attachment.map(a -> modelMapper.map(a, AttachmentDto.class)).orElse(null);
//     }
//
//     public void deleteAttachment(Long id) {
//         attachmentRepository.deleteById(id);
//     }
//
//     public List<AttachmentDto> getAllAttachments() {
//         List<Attachment> attachmentList = attachmentRepository.findAll();
//         List<AttachmentDto> attachmentDtoList = new ArrayList<>();
//         for (Attachment attachment : attachmentList) {
//             AttachmentDto attachmentDto = modelMapper.map(attachment, AttachmentDto.class);
//             attachmentDtoList.add(attachmentDto);
//         }
//         return attachmentDtoList;
//     }


/////
//    public AttachmentDto getPropImgByPropertyId(long propertyId) {
//        Attachment propImgModel = attachmentRepository.findPropByPropertyId(propertyId);
//        System.out.println("model: "+propImgModel.toString());
//        AttachmentDto attachDto = new AttachmentDto();
//        attachDto.setBase64Img(propImgModel.getBase64Img());
//        attachDto.setId(propImgModel.getId());
//        attachDto.setImage(propImgModel.getImage());
//        attachDto.setPropertyId(propImgModel.getPropertyId());;
//        return attachDto;
//    }

    public AttachmentDto saveAttachment(AttachmentDto attachmentDto) {
        Attachment attachment = new Attachment();
        attachment.setId(attachment.getId());
        attachment.setImage(attachmentDto.getImage());
        attachment.setBase64Img(attachmentDto.getBase64Img());
        attachment.setPropertyId(attachmentDto.getPropertyId());
        attachmentRepository.save(attachment);
        AttachmentDto attachDto = modelMapper.map(attachment, AttachmentDto.class);
        return attachDto;
    }

    public AttachmentDto getPropImgByPropertyId(long propertyId) {
        Attachment propImgModel = attachmentRepository.findPropByPropertyId(propertyId);
        System.out.println("model: "+propImgModel.toString());
        AttachmentDto attachDto = new AttachmentDto();
        attachDto.setBase64Img(propImgModel.getBase64Img());
        attachDto.setId(propImgModel.getId());
        attachDto.setImage(propImgModel.getImage());
        attachDto.setPropertyId(propImgModel.getPropertyId());;

        return attachDto;
    }

    //multipleimages
    public List<AttachmentDto> saveMultipleAttachments(List<AttachmentDto> attachmentDtos) {
    List<AttachmentDto> savedAttachments = new ArrayList<>();
    for (AttachmentDto attachmentDto : attachmentDtos) {
        Attachment attachment = new Attachment();
        attachment.setImage(attachmentDto.getImage());
        attachment.setBase64Img(attachmentDto.getBase64Img());
        attachment.setPropertyId(attachmentDto.getPropertyId());
        attachmentRepository.save(attachment);
        savedAttachments.add(modelMapper.map(attachment, AttachmentDto.class));
    }
    return savedAttachments;
}
  //multiple images
  public List<AttachmentDto> getImagesByPropertyId(Long propertyId) {
        List<Attachment> attachments = attachmentRepository.findByPropertyId(propertyId);
        return attachments.stream()
                .map(attachment -> modelMapper.map(attachment, AttachmentDto.class))
                .collect(Collectors.toList());
    }
}
