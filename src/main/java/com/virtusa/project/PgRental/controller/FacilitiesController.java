package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.FacilitiesDto;
import com.virtusa.project.PgRental.service.FacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilitiesController {

    @Autowired
    private FacilitiesService facilitiesService;

    @PostMapping
    public ResponseEntity<Void> createFacility(@RequestBody FacilitiesDto facilitiesDto) {
        facilitiesService.createFacility(facilitiesDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateFacility(@PathVariable long id, @RequestBody FacilitiesDto facilitiesDto) {
        facilitiesDto.setFacilityId(id);
        facilitiesService.updateFacility(facilitiesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilitiesDto> getFacilityDetails(@PathVariable long id) {
        FacilitiesDto facilitiesDto = facilitiesService.getFacilityDetails(id);
        if (facilitiesDto != null) {
            return ResponseEntity.ok(facilitiesDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacility(@PathVariable long id) {
        facilitiesService.deleteFacility(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<FacilitiesDto>> getAllFacilities() {
        List<FacilitiesDto> facilitiesDtoList = facilitiesService.getAllFacilities();
        return ResponseEntity.ok(facilitiesDtoList);
    }
}
