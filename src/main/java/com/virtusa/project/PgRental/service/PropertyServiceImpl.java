package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dao.PropertyDao;
import com.virtusa.project.PgRental.dto.PropertyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    private final PropertyDao propertyDao;
    @Autowired
    private PropertyService propertyService;

    public PropertyServiceImpl(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
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

    @Override
    public PropertyDto approveProperty(PropertyDto propertyDto) throws ChangeSetPersister.NotFoundException {
        propertyDto.setApproved(true);
        return propertyDao.updateProperty(propertyDto);
    }

    @Override
    public void disapproveProperty(long propertyId) throws ChangeSetPersister.NotFoundException {
        propertyDao.deleteProperty(propertyId);
    }

    @Override
    public List<PropertyDto> getUnapprovedProperties() {
        return propertyDao.findUnapprovedProperties();
    }
}
