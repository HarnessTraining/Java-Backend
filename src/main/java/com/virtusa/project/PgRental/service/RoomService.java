package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dto.RoomDto;

import java.util.List;

public interface RoomService {
    RoomDto saveRoom(RoomDto roomDto);
    RoomDto getRoomById(Long id);
    List<RoomDto> getAllRooms();
    RoomDto updateRoom(Long id, RoomDto roomDto);
    void deleteRoom(Long id);
}
