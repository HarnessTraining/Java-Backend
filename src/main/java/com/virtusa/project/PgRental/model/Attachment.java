package com.virtusa.project.PgRental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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


    @Override
    public String toString() {
        return "Attachment{" +
                "id=" + id +
                ", propertyId=" + (property != null ? property.getPropertyId() : "null")+
                '}';
    }

    public Attachment() {
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getBase64Img() {
        return base64Img;
    }

    public void setBase64Img(String base64Img) {
        this.base64Img = base64Img;
    }

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

  
}

   