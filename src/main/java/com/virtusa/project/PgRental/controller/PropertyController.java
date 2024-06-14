package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.model.CustomUserDetails;
import com.virtusa.project.PgRental.service.CustomUserDetailsService;
import com.virtusa.project.PgRental.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    private final PropertyService propertyService;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }



    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable long propertyId) throws ChangeSetPersister.NotFoundException {
        PropertyDto propertyDto = propertyService.getPropertyById(propertyId);

        if (propertyDto != null) {
            return ResponseEntity.ok(propertyDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> propertyDtos = propertyService.getAllProperties();
        return ResponseEntity.ok(propertyDtos);
    }

    @PostMapping("/addProperty")
    public ResponseEntity<PropertyDto> createProperty(@RequestBody PropertyDto propertyDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomUserDetails userDetails = (CustomUserDetails) customUserDetailsService.loadUserByUsername(username);

        propertyDto.setUserId(userDetails.getUserId());
        PropertyDto createdPropertyDto = propertyService.createProperty(propertyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPropertyDto);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@PathVariable long propertyId, @RequestBody PropertyDto propertyDto) throws ChangeSetPersister.NotFoundException {
        propertyDto.setPropertyId(propertyId); // Ensure ID consistency
        PropertyDto updatedPropertyDto = propertyService.updateProperty(propertyDto);
        return ResponseEntity.ok(updatedPropertyDto);
    }

    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable long propertyId) throws ChangeSetPersister.NotFoundException {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.noContent().build();
    }
}
