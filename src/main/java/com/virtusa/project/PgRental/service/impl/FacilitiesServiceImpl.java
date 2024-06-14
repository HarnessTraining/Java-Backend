package com.virtusa.project.PgRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.virtusa.project.PgRental.dao.FacilitiesDao;
import com.virtusa.project.PgRental.dto.FacilitiesDto;

import com.virtusa.project.PgRental.service.FacilitiesService;

@Repository
public class FacilitiesServiceImpl implements FacilitiesService{

   @Autowired
    private FacilitiesDao facilitiesDao;

    @Override
    public void createFacility(FacilitiesDto facilitiesDto) {
        facilitiesDao.createFacility(facilitiesDto);
    }

    @Override
    public void updateFacility(FacilitiesDto facilitiesDto) {
        facilitiesDao.updateFacility(facilitiesDto);
    }

    @Override
    public FacilitiesDto getFacilityDetails(long facilityId) {
        return facilitiesDao.getFacilityDetails(facilityId);
    }

    @Override
    public void deleteFacility(long facilityId) {
        facilitiesDao.deleteFacility(facilityId);
    }

    @Override
    public List<FacilitiesDto> getAllFacilities() {
        return facilitiesDao.getAllFacilities();
    }

    
    
}
