package com.virtusa.project.PgRental.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.virtusa.project.PgRental.dao.PgFacilitiesDao;
import com.virtusa.project.PgRental.dto.PgFacilitiesDto;
import com.virtusa.project.PgRental.service.PgFacilitiesService;

@Service
public class PgFacilitiesServiceImpl implements PgFacilitiesService {

  @Autowired
    private PgFacilitiesDao pgFacilitiesDao;

    @Override
    public void createPgFacilities(PgFacilitiesDto pgFacilitiesDto) {
        pgFacilitiesDao.createPgFacilities(pgFacilitiesDto);
    }

    @Override
    public void updatePgFacilities(PgFacilitiesDto pgFacilitiesDto) {
        pgFacilitiesDao.updatePgFacilities(pgFacilitiesDto);
    }

    @Override
    public PgFacilitiesDto getPgFacilities(long pgFacilitiesId) {
        return pgFacilitiesDao.getPgFacilities(pgFacilitiesId);
    }

    @Override
    public void deletePgFacilities(long pgFacilitiesId) {
        pgFacilitiesDao.deletePgFacilities(pgFacilitiesId);
    }

    @Override
    public List<PgFacilitiesDto> getAllPgFacilities() {
        return pgFacilitiesDao.getAllPgFacilities();
    }
    
}
