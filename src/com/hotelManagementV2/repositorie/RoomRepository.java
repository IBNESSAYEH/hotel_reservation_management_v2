package com.hotelManagementV2.repositorie;

import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RoomRepository {
    private Connection connection;

    public RoomRepository() {
        this.connection = DBConnection.getConnectionInstance().getConnection();
    }

    public List<Room> findAllRooms() {
        List<Room> rooms = new ArrayList<>();
        String sql = "SELECT * FROM room";
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("roomID"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("roomNumbers"),
                        rs.getDouble("Tarif"),
                        rs.getObject("roomSize") != null ? rs.getInt("roomSize") : null,
                        rs.getLong("hotelId")
                );
                rooms.add(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rooms;
    }

    public Optional<Room> findRoomById(Long id) {
        String sql = "SELECT * FROM room WHERE roomID = ?";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                Room room = new Room(
                        rs.getInt("roomID"),
                        rs.getString("category"),
                        rs.getDouble("price"),
                        rs.getInt("roomNumbers"),
                        rs.getDouble("Tarif"),
                        rs.getObject("roomSize") != null ? rs.getInt("roomSize") : null,
                        rs.getLong("hotelId")
                );
                return Optional.of(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    public void createRoom(Room room) {
        String sql = "INSERT INTO room (category, price, roomNumbers, Tarif, roomSize, hotelId) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;
        try {
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, room.getCategory());
            pstmt.setDouble(2, room.getPrice());
            pstmt.setInt(3, room.getRoomNumbers());
            pstmt.setDouble(4, room.getTarif());
            if (room.getRoomSize() != null) {
                pstmt.setInt(5, room.getRoomSize());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }
            pstmt.setLong(6, room.getHotelId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating room failed, no rows affected.");
            }
            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                room.setRoomId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("Creating room failed, no ID obtained.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateRoom(Room room) {
        String sql = "UPDATE room SET category = ?, price = ?, roomNumbers = ?, Tarif = ?, roomSize = ?, hotelId = ? WHERE roomID = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, room.getCategory());
            pstmt.setDouble(2, room.getPrice());
            pstmt.setInt(3, room.getRoomNumbers());
            pstmt.setDouble(4, room.getTarif());
            if (room.getRoomSize() != null) {
                pstmt.setInt(5, room.getRoomSize());
            } else {
                pstmt.setNull(5, Types.INTEGER);
            }
            pstmt.setLong(6, room.getHotelId());
            pstmt.setLong(7, room.getRoomId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteRoom(Long id) {
        String sql = "DELETE FROM room WHERE roomID = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public HashMap<String, Room> isAvailable(){
        //
        return null;
    }
}
