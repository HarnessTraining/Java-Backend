package com.virtusa.project.PgRental.controller;
import com.virtusa.project.PgRental.dto.PgFacilitiesDto;
import com.virtusa.project.PgRental.service.PgFacilitiesService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/pgfacilities")
public class PgFacilitiesController {

    @Autowired
    private PgFacilitiesService pgFacilitiesService;

    @PostMapping
    public ResponseEntity<Void> createPgFacilities(@RequestBody PgFacilitiesDto pgFacilitiesDto) {
        pgFacilitiesService.createPgFacilities(pgFacilitiesDto);
        return ResponseEntity.ok().build();
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