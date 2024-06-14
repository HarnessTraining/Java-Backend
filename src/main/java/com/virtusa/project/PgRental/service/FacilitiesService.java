package com.virtusa.project.PgRental.service;

import java.util.List;

import com.virtusa.project.PgRental.dto.FacilitiesDto;

public interface FacilitiesService {
     void createFacility(FacilitiesDto facilitiesDto);
    void updateFacility(FacilitiesDto facilitiesDto);
    FacilitiesDto getFacilityDetails(long facilityId);
    void deleteFacility(long facilityId);
    List<FacilitiesDto> getAllFacilities();
    
}   

