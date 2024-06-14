package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.FacilitiesDto;
import com.virtusa.project.PgRental.model.Facilities;
import com.virtusa.project.PgRental.repository.FacilitiesRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FacilitiesDao {

    @Autowired
    private FacilitiesRepository facilitiesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createFacility(FacilitiesDto facilitiesDto) {
        Facilities facility = modelMapper.map(facilitiesDto, Facilities.class);
        facilitiesRepository.save(facility);
    }

    public void updateFacility(FacilitiesDto facilitiesDto) {
        Facilities facility = modelMapper.map(facilitiesDto, Facilities.class);
        facilitiesRepository.save(facility);
    }

    public FacilitiesDto getFacilityDetails(long facilityId) {
        Optional<Facilities> facility = facilitiesRepository.findById(facilityId);
        return facility.map(f -> modelMapper.map(f, FacilitiesDto.class)).orElse(null);
    }

    public void deleteFacility(long facilityId) {
        facilitiesRepository.deleteById(facilityId);
    }

    public List<FacilitiesDto> getAllFacilities() {
        List<Facilities> facilitiesList = facilitiesRepository.findAll();
        List<FacilitiesDto> facilitiesDtoList = new ArrayList<>();
        for (Facilities facility : facilitiesList) {
            FacilitiesDto facilitiesDto = modelMapper.map(facility, FacilitiesDto.class);
            facilitiesDtoList.add(facilitiesDto);
        }
        return facilitiesDtoList;
    }
}
