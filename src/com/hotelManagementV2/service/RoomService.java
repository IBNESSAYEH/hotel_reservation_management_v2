package com.hotelManagementV2.service;

import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.repositorie.RoomRepository;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RoomService {
    private RoomRepository roomRepository;

    public RoomService() {
        this.roomRepository = new RoomRepository();
    }

    public List<Room> getAllRooms() {
        List<Room> rooms = null;
        try {
            rooms = roomRepository.findAllRooms();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Optional<Room> getRoomById(Long id) {
        Optional<Room> room = Optional.empty();
        try {
            room = roomRepository.findRoomById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    public void createRoom(Room room) {

        try {
            roomRepository.createRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(Room room) {
        try {
            roomRepository.updateRoom(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(Long id) {
        try {
            roomRepository.deleteRoom(  id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int isAvailableRooms(LocalDate startDate, LocalDate endDate, String category){
        return roomRepository.isAvailableRooms(startDate, endDate, category);
    }
}
