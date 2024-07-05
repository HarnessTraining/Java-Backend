package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Arrays;

@Entity
@Data
@AllArgsConstructor
@Builder
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    @Lob
    @Column(length = 100000)
    private String base64Img;

    @Column(name="property_id")
    private long propertyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", insertable = false, updatable = false)
    private Property property;

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property= property;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", propertyId=" + (property != null ? property.getPropertyId() : "null")+
                ", data=" + Arrays.toString(data) +
                '}';
    }

    public Attachment() {
    }

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    public Attachment(byte[] data,Property property) {
        this.property = property;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}

   