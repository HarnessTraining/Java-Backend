package com.virtusa.project.PgRental.controller;

import com.virtusa.project.PgRental.dto.PropertyDto;
import com.virtusa.project.PgRental.dto.RoomDto;
import com.virtusa.project.PgRental.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/{id}")
    public ResponseEntity<RoomDto> createRoom(@RequestBody RoomDto roomDto,@PathVariable long id) {
        System.out.println(roomDto);
        PropertyDto propertyDto = new PropertyDto();
        propertyDto.setPropertyId(id);
        roomDto.setProperty(propertyDto);
        RoomDto savedRoom = roomService.saveRoom(roomDto);
        return ResponseEntity.ok(savedRoom);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoomDto> getRoomById(@PathVariable Long id) {
        RoomDto roomDto = roomService.getRoomById(id);
        return ResponseEntity.ok(roomDto);
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getAllRooms() {
        List<RoomDto> rooms = roomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomDto> updateRoom(@PathVariable Long id, @RequestBody RoomDto roomDto) {
        RoomDto updatedRoom = roomService.updateRoom(id, roomDto);
        return ResponseEntity.ok(updatedRoom);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
