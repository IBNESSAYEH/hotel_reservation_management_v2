package com.hotelManagementV2.controller;


import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.service.RoomService;

import java.util.List;
import java.util.Optional;

public class RoomController {
    private RoomService roomService;

    public RoomController() {
        this.roomService = new RoomService();
    }

    public void displayAllRooms() {
        try {
            List<Room> rooms = roomService.getAllRooms();
            for (Room room : rooms) {
                System.out.println("Room ID: " + room.getRoomId() +
                        ", Category: " + room.getCategory() +
                        ", Price: " + room.getPrice() +
                        ", Room Numbers: " + room.getRoomNumbers() +
                        ", Tarif: " + room.getTarif() +
                        ", Room Size: " + room.getRoomSize() +
                        ", Hotel ID: " + room.getHotelId());
            }
        } catch (Exception e) {
            System.out.println("Error retrieving rooms: " + e.getMessage());
        }
    }

    public void displayRoom(Long id) {
        try {
            Optional<Room> roomOpt = roomService.getRoomById(id);
            if (roomOpt.isPresent()) {
                Room room = roomOpt.get();
                System.out.println("Room ID: " + room.getRoomId() +
                        ", Category: " + room.getCategory() +
                        ", Price: " + room.getPrice() +
                        ", Room Numbers: " + room.getRoomNumbers() +
                        ", Tarif: " + room.getTarif() +
                        ", Room Size: " + room.getRoomSize() +
                        ", Hotel ID: " + room.getHotelId());
            } else {
                System.out.println("Room not found with id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving room: " + e.getMessage());
        }
    }

    public void createRoom(int roomId, String category, Double price, int roomNumbers, Double tarif, Integer roomSize, Long hotelId) {
        try {
            roomService.createRoom(roomId, category, price, roomNumbers, tarif, roomSize, hotelId);
            System.out.println("Room created successfully.");
        } catch (Exception e) {
            System.out.println("Error creating room: " + e.getMessage());
        }
    }

    public void updateRoom(Room room) {
        try {
            roomService.updateRoom(room);
            System.out.println("Room updated successfully.");
        } catch (Exception e) {
            System.out.println("Error updating room: " + e.getMessage());
        }
    }

    public void deleteRoom(Long id) {
        try {
            roomService.deleteRoom(id);
            System.out.println("Room deleted successfully.");
        } catch (Exception e) {
            System.out.println("Error deleting room: " + e.getMessage());
        }
    }

}
