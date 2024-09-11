package com.hotelManagementV2;

import com.hotelManagementV2.controller.RoomController;
import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.repositorie.RoomRepository;
import com.hotelManagementV2.util.DBConnection;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        DBConnection.getConnectionInstance().getConnection();

        RoomController roomController = new RoomController();
        roomController.createRoom(1,"LUXE",10.00, 2, 2.00,2,1l);

        }
}