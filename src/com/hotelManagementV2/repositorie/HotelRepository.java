package com.hotelManagementV2.repositorie;

import com.hotelManagementV2.model.Hotel;
import com.hotelManagementV2.util.DBConnection;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HotelRepository {
    private Connection connection;

    public HotelRepository() {
        this.connection = DBConnection.getConnectionInstance().getConnection();
    }

    public void createHotel(Hotel hotel) {
        String sql = "INSERT INTO Hotel (name, balance) VALUES (?, ?)";
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try {
            pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, hotel.getName());
            pstmt.setBigDecimal(2, hotel.getBalance());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("creating hotel failed, no rows affected.");
            }

            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                hotel.setHotelId(generatedKeys.getInt(1));
            } else {
                throw new SQLException("creating hotel failed, no ID obtained.");
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

    public Optional<Hotel> getHotelById(int id) {
        String sql = "SELECT * FROM Hotel WHERE hotelId = ?";
        PreparedStatement pstmt = null;
        ResultSet result = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();

            if (result.next()) {
                Hotel hotel = new Hotel(
                        result.getInt("hotelId"),
                        result.getString("name"),
                        result.getBigDecimal("balance")
                );
                return Optional.of(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (pstmt != null) pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return Optional.empty();
    }

    public List<Hotel> getAllHotels() {
        String sql = "SELECT * FROM Hotel";
        List<Hotel> hotelList = new ArrayList<>();
        Statement stmt = null;
        ResultSet result = null;

        try {
            stmt = connection.createStatement();
            result = stmt.executeQuery(sql);

            while (result.next()) {
                Hotel hotel = new Hotel(
                        result.getInt("hotelId"),
                        result.getString("name"),
                        result.getBigDecimal("balance")
                );
                hotelList.add(hotel);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (result != null) result.close();
                if (stmt != null) stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return hotelList;
    }

    public void updateHotel(Hotel hotel) {
        String sql = "UPDATE Hotel SET name = ?, balance = ? WHERE hotelId = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, hotel.getName());
            pstmt.setBigDecimal(2, hotel.getBalance());
            pstmt.setInt(3, hotel.getHotelId());

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

    public void deleteHotel(int id) {
        String sql = "DELETE FROM Hotel WHERE hotelId = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
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
}
