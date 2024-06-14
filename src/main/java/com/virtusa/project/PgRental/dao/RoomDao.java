package com.virtusa.project.PgRental.dao;



import com.virtusa.project.PgRental.dto.RoomDto;
import com.virtusa.project.PgRental.model.Room;
import com.virtusa.project.PgRental.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RoomDao {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private ModelMapper modelMapper;

    public RoomDto save(RoomDto roomDto) {
        Room room = modelMapper.map(roomDto, Room.class);
        Room savedRoom = roomRepository.save(room);
        return modelMapper.map(savedRoom, RoomDto.class);
    }

    public Optional<RoomDto> findById(Long id) {
        Optional<Room> room = roomRepository.findById(id);
        return room.map(value -> modelMapper.map(value, RoomDto.class));
    }

    public List<RoomDto> findAll() {
        List<Room> rooms = roomRepository.findAll();
        return rooms.stream()
                .map(room -> modelMapper.map(room, RoomDto.class))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        roomRepository.deleteById(id);
    }
}

