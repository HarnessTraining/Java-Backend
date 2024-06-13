package com.virtusa.project.PgRental.service;

import java.util.List;

import com.virtusa.project.PgRental.dto.PgFacilitiesDto;

public interface PgFacilitiesService {

    void createPgFacilities(PgFacilitiesDto pgFacilitiesDto);

    void updatePgFacilities(PgFacilitiesDto pgFacilitiesDto);

    PgFacilitiesDto getPgFacilities(long pgFacilitiesId);

    void deletePgFacilities(long pgFacilitiesId);

    List<PgFacilitiesDto> getAllPgFacilities();
}
