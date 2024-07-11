package com.virtusa.project.PgRental.service;

import com.virtusa.project.PgRental.dao.RoomDao;
import com.virtusa.project.PgRental.dto.RoomAvailabilityUpdateDto;
import com.virtusa.project.PgRental.dto.RoomDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public RoomDto saveRoom(RoomDto roomDto) {
        return roomDao.save(roomDto);
    }

    @Override
    public RoomDto getRoomById(Long id) {
        return roomDao.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
    }

    @Override
    public List<RoomDto> getAllRooms() {
        return roomDao.findAll();
    }

    @Override
    public RoomDto updateRoom(Long id, RoomDto roomDto) {
        RoomDto existingRoom = roomDao.findById(id).orElseThrow(() -> new RuntimeException("Room not found"));
        roomDto.setRoomId(existingRoom.getRoomId()); // Ensure the ID remains the same
        return roomDao.save(roomDto);
    }

    @Override
    public void deleteRoom(Long id) {
        roomDao.delete(id);
    }

    @Override
    public RoomDto updateRoomAvailability(RoomAvailabilityUpdateDto roomAvailabilityUpdateDto) {
       return roomDao.updateRoomAvailability(roomAvailabilityUpdateDto);
    }


}
