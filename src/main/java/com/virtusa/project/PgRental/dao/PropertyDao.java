package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.model.Property;
import com.virtusa.project.PgRental.repository.PropertyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PropertyDao {
    private final PropertyRepository propertyRepository;
    private final ModelMapper modelMapper;

    public PropertyDao(PropertyRepository propertyRepository, ModelMapper modelMapper) {
        this.propertyRepository = propertyRepository;
        this.modelMapper = modelMapper;
    }

    public PropertyDto getPropertyById(long propertyId) throws NotFoundException {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new NotFoundException());
        return modelMapper.map(property, PropertyDto.class);
    }

    public List<PropertyDto> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        System.out.println(properties);
        return properties.stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }

    public PropertyDto saveProperty(PropertyDto propertyDto) {
        Property property = modelMapper.map(propertyDto, Property.class);
        property = propertyRepository.save(property);
        return modelMapper.map(property, PropertyDto.class);
    }

    public PropertyDto updateProperty(PropertyDto propertyDto) throws NotFoundException {
        Property existingProperty = propertyRepository.findById(propertyDto.getPropertyId())
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        modelMapper.map(propertyDto, existingProperty);
        existingProperty = propertyRepository.save(existingProperty);
        return modelMapper.map(existingProperty, PropertyDto.class);
    }

    public void deleteProperty(long propertyId) throws NotFoundException {
        Property existingProperty = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new NotFoundException());
        propertyRepository.delete(existingProperty);
    }

    public List<PropertyDto> findUnapprovedProperties() {
        List<Property> unapprovedProperties = propertyRepository.findByIsApproved(false);
        return unapprovedProperties.stream()
                .map(property -> modelMapper.map(property, PropertyDto.class))
                .collect(Collectors.toList());
    }
}


