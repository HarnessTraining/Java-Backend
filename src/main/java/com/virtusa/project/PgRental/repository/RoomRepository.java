package com.virtusa.project.PgRental.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.project.PgRental.model.Room;


public interface RoomRepository extends JpaRepository<Room,Long>{
    
}
