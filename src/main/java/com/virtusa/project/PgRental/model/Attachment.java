package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;
    private String fileType;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property= property;
    }

    public Attachment() {
    }

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    public Attachment( String fileName, String fileType, byte[] data,Property property) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.property = property;
        this.data = data;
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

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
