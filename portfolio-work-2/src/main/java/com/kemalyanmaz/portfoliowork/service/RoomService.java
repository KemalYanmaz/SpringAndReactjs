package com.kemalyanmaz.portfoliowork.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kemalyanmaz.portfoliowork.data.RoomRepository;
import com.kemalyanmaz.portfoliowork.models.Room;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    
    public RoomService(RoomRepository roomRepository) {
    	this.roomRepository = roomRepository;
    }


    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    
    public Room getById(long id) {
    	return roomRepository.findById(id).orElse(new Room());
    }
    
    public Room addRoom(Room room) {
    	return roomRepository.save(room);
    }
}