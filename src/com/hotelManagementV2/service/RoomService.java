package com.hotelManagementV2.service;

import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.repositorie.RoomRepository;

import java.sql.SQLException;
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
            rooms = roomRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public Optional<Room> getRoomById(Long id) {
        Optional<Room> room = Optional.empty();
        try {
            room = roomRepository.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return room;
    }

    public void createRoom(int roomId, String category, Double price, int roomNumbers, Double tarif, Integer roomSize, Long hotelId) {
        Room room = new Room(roomId, category, price, roomNumbers, tarif, roomSize, hotelId);
        try {
            roomRepository.save(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateRoom(Room room) {
        try {
            roomRepository.update(room);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(Long id) {
        try {
            roomRepository.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
