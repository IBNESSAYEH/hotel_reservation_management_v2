package com.hotelManagementV2.model;

public class Room {

    private int roomId;
    private int roomTypeId;

    public Room(int roomId, int roomTypeId) {
        this.roomId = roomId;
        this.roomTypeId = roomTypeId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", roomTypeId=" + roomTypeId +
                '}';
    }
}
