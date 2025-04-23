package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.jwt.JwtUtils;
import com.virtusa.project.PgRental.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/properties")
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {
    
    @Autowired
    private JwtUtils jwtUtils;
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @GetMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable long propertyId)
            throws ChangeSetPersister.NotFoundException {
        PropertyDto propertyDto = propertyService.getPropertyById(propertyId);

        if (propertyDto != null) {
            return ResponseEntity.ok(propertyDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> propertyDtos = propertyService.getAllProperties();
        return ResponseEntity.ok(propertyDtos);
    }

    @GetMapping("/approved")
    public ResponseEntity<List<PropertyDto>> getApprovedProperties() {
        List<PropertyDto> approvedProperties = propertyService.getApprovedProperties();
        return ResponseEntity.ok(approvedProperties);
    }


    @PostMapping("/addProperty")
    public ResponseEntity<PropertyDto> createProperty(@RequestHeader("Authorization") String token,@RequestBody PropertyDto propertyDto) {
        String jwtToken = token.substring(7);
        Long userId = jwtUtils.getUserIdFromJwtToken(jwtToken);
        System.out.println(userId);
        propertyDto.setUserId(userId);
        PropertyDto createdPropertyDto = propertyService.createProperty(propertyDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPropertyDto);
    }

    @PutMapping("/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@PathVariable long propertyId,
            @RequestBody PropertyDto propertyDto) throws ChangeSetPersister.NotFoundException {
        propertyDto.setPropertyId(propertyId);
        PropertyDto updatedPropertyDto = propertyService.updateProperty(propertyDto);
        return ResponseEntity.ok(updatedPropertyDto);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PropertyDto>> getPropertiesBgyyyUserId(@PathVariable long userId) {
        List<PropertyDto> properties = propertyService.getPropertiesByUserId(userId);
        return ResponseEntity.ok(properties);
    }
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable long propertyId)
            throws ChangeSetPersister.NotFoundException {
        propertyService.deleteProperty(propertyId);
        return ResponseEntity.noContent().build();
    }
}
