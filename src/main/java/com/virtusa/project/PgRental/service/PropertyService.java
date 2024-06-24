package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.PropertyDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface PropertyService {
    PropertyDto getPropertyById(long propertyId) throws ChangeSetPersister.NotFoundException;
    List<PropertyDto> getAllProperties();
    PropertyDto createProperty(PropertyDto propertyDto);
    PropertyDto updateProperty(PropertyDto propertyDto) throws ChangeSetPersister.NotFoundException;
    void deleteProperty(long propertyId) throws ChangeSetPersister.NotFoundException;
    PropertyDto approveProperty(long propertyId) throws ChangeSetPersister.NotFoundException;
    void disapproveProperty(long propertyId) throws ChangeSetPersister.NotFoundException;
}
