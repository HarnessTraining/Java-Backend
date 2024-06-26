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

    private Long propertyId;

    public Long getPropertyId() {
        return propertyId;
    }

    public void setPropertyDto(Long propertyId) {
        this.propertyId = propertyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Long getFileSize() {
        return fileSize;
    }

    public void setFileSize(Long fileSize) {
        this.fileSize = fileSize;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
