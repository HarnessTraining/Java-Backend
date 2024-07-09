package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.PgFacilitiesDto;
import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.service.PgFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pgfacilities")
@CrossOrigin(origins = "http://localhost:3000")
public class PgFacilitiesController {

    @Autowired
    private PgFacilitiesService pgFacilitiesService;

    @PostMapping("/{id}")
    public ResponseEntity<PgFacilitiesDto> createPgFacilities(@RequestBody PgFacilitiesDto pgFacilitiesDto,@PathVariable long id) {
        System.out.println(pgFacilitiesDto);
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setPropertyId(id);
        pgFacilitiesDto.setProperty(propertyDto);
        pgFacilitiesService.createPgFacilities(pgFacilitiesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pgFacilitiesDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updatePgFacilities(@PathVariable long id, @RequestBody PgFacilitiesDto pgFacilitiesDto) {
        pgFacilitiesDto.setPgFacilitiesId(id);
        pgFacilitiesService.updatePgFacilities(pgFacilitiesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PgFacilitiesDto> getPgFacilities(@PathVariable long id) {
        PgFacilitiesDto pgFacilitiesDto = pgFacilitiesService.getPgFacilities(id);
        if (pgFacilitiesDto != null) {
            return ResponseEntity.ok(pgFacilitiesDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePgFacilities(@PathVariable long id) {
        pgFacilitiesService.deletePgFacilities(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<PgFacilitiesDto>> getAllPgFacilities() {
        List<PgFacilitiesDto> pgFacilitiesDtoList = pgFacilitiesService.getAllPgFacilities();
        return ResponseEntity.ok(pgFacilitiesDtoList);
    }
}