package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttachmentDto {    
    private Long id;
    private byte[] image;
    private String base64Img;
    private long propertyId;
    
}
