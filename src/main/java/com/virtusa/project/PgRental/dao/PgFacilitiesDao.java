package com.virtusa.project.PgRental.dao;

import com.virtusa.project.PgRental.dto.FacilitiesDto;
import com.virtusa.project.PgRental.dto.PgFacilitiesDto;
import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.model.PgFacilities;
import com.virtusa.project.PgRental.repository.PgFacilitiesRepository;
import com.virtusa.project.PgRental.repository.PropertyRepository;
import com.virtusa.project.PgRental.repository.FacilitiesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PgFacilitiesDao {

    @Autowired
    private PgFacilitiesRepository pgFacilitiesRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    @Autowired
    private FacilitiesRepository facilitiesRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createPgFacilities(PgFacilitiesDto pgFacilitiesDto) {
    PgFacilities pgFacilities = modelMapper.map(pgFacilitiesDto, PgFacilities.class);
    // Set the property directly from the property object in the DTO
    pgFacilitiesRepository.save(pgFacilities);
}
    public void updatePgFacilities(PgFacilitiesDto pgFacilitiesDto) {
        PgFacilities pgFacilities = pgFacilitiesRepository.findById(pgFacilitiesDto.getPgFacilitiesId()).orElse(null);
        if (pgFacilities != null) {
            pgFacilities = modelMapper.map(pgFacilitiesDto, PgFacilities.class);
            pgFacilities.setProperty(propertyRepository.findById(pgFacilitiesDto.getProperty().getPropertyId()).orElse(null));
            pgFacilities.setFacilities(facilitiesRepository.findById(pgFacilitiesDto.getFacilities().getFacilityId()).orElse(null));
            pgFacilitiesRepository.save(pgFacilities);
        }
    }

    public PgFacilitiesDto getPgFacilities(long pgFacilitiesId) {
        Optional<PgFacilities> pgFacilities = pgFacilitiesRepository.findById(pgFacilitiesId);
        return pgFacilities.map(f -> {
            PgFacilitiesDto pgFacilitiesDto = modelMapper.map(f, PgFacilitiesDto.class);
            pgFacilitiesDto.setProperty(modelMapper.map(f.getProperty(), PropertyDto.class));
            pgFacilitiesDto.setFacilities(modelMapper.map(f.getFacilities(), FacilitiesDto.class));
            return pgFacilitiesDto;
        }).orElse(null);
    }

    public void deletePgFacilities(long pgFacilitiesId) {
        pgFacilitiesRepository.deleteById(pgFacilitiesId);
    }

    public List<PgFacilitiesDto> getAllPgFacilities() {
        List<PgFacilities> pgFacilitiesList = pgFacilitiesRepository.findAll();
        List<PgFacilitiesDto> pgFacilitiesDtoList = new ArrayList<>();
        for (PgFacilities pgFacilities : pgFacilitiesList) {
            PgFacilitiesDto pgFacilitiesDto = modelMapper.map(pgFacilities, PgFacilitiesDto.class);
            pgFacilitiesDto.setProperty(modelMapper.map(pgFacilities.getProperty(), PropertyDto.class));
            pgFacilitiesDto.setFacilities(modelMapper.map(pgFacilities.getFacilities(), FacilitiesDto.class));
            pgFacilitiesDtoList.add(pgFacilitiesDto);
        }
        return pgFacilitiesDtoList;
    }
}
