package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dao.PropertyDao;
import com.virtusa.project.PgRental.dto.PropertyDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyDao propertyDao;
    private final ModelMapper modelMapper;

    public PropertyServiceImpl(PropertyDao propertyDao, ModelMapper modelMapper) {
        this.propertyDao = propertyDao;
        this.modelMapper = modelMapper;
    }

    @Override
    public PropertyDto getPropertyById(long propertyId) throws ChangeSetPersister.NotFoundException {
        return propertyDao.getPropertyById(propertyId);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return propertyDao.getAllProperties();
    }

    @Override
    public PropertyDto createProperty(PropertyDto propertyDto) {
        return propertyDao.saveProperty(propertyDto);
    }

    @Override
    public PropertyDto updateProperty(PropertyDto propertyDto) throws ChangeSetPersister.NotFoundException {
        return propertyDao.updateProperty(propertyDto);
    }

    @Override
    public void deleteProperty(long propertyId) throws ChangeSetPersister.NotFoundException {

            propertyDao.deleteProperty(propertyId);
    }
}
