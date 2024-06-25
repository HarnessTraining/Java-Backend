package com.virtusa.project.PgRental.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDto {
    private Long id;
    private String fileName;
    private String downloadURL;
    private String fileType;
    private Long fileSize;
    private byte[] data; // Add this field if data is needed

    // Constructor without id for file upload response
    public AttachmentDto(String fileName, String downloadURL, String fileType, Long fileSize) {
        this.fileName = fileName;
        this.downloadURL = downloadURL;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }
}
