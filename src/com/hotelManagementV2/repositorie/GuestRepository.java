package com.hotelManagementV2.repositorie;

import com.hotelManagementV2.model.Guest;
import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GuestRepository {
    private Connection connection ;

    public GuestRepository() {
        this.connection = DBConnection.getConnectionInstance().getConnection();
    }

    public void createGuest(Guest guest) {
        String Sql = "INSERT INTO Guest (fullName, cin, email, phone, balance) values (?,?,?,?,?)";
        PreparedStatement pstmt = null;
        ResultSet generatedKeys = null;

        try{
            pstmt = connection.prepareStatement(Sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getCin());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPhone());
            if(guest.getBalance() != null){
                pstmt.setDouble(5, guest.getBalance());
            }else{
                pstmt.setDouble(5, Types.DOUBLE);
            }
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating room failed, no rows affected.");
            }
            generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                guest.setGuestId(generatedKeys.getInt(1));
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

    public Optional<Guest> getGuestById(int id){

        String Sql = "SELECT * FROM Guest WHERE guestid = ?";
        PreparedStatement pstmt = null;
        ResultSet result = null;

        try{


            pstmt = connection.prepareStatement(Sql);
            pstmt.setInt(1, id);
            result = pstmt.executeQuery();

            if(result.next()){
                Guest guest = new Guest(
                        result.getString("fullName"),
                        result.getString("cin"),
                        result.getString("email"),
                        result.getString("phone"),
                        result.getDouble("balance")
                );

                return Optional.of(guest);
            }
        }catch (SQLException e) {
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

    public void updateGuest(Guest guest) {
        String Sql = "UPDATE Guest SET fullName = ?, cin = ?, email = ?, phone = ?, balance = ? WHERE guestid = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(Sql);
            pstmt.setString(1, guest.getFullName());
            pstmt.setString(2, guest.getCin());
            pstmt.setString(3, guest.getEmail());
            pstmt.setString(4, guest.getPhone());
            pstmt.setDouble(5, guest.getBalance());
            pstmt.setInt(6, guest.getGuestId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating guest failed, no rows affected.");
            }

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
    public void deleteGuest(int id) {
        String Sql = "DELETE FROM Guest WHERE guestid = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(Sql);
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("deleting     guest  failed, no rows affected.");
            }

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
    public List<Guest> getAllGuests() {
        String Sql = "SELECT * FROM Guest";
        List<Guest> guestList = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet result = null;
        try {
            pstmt = connection.prepareStatement(Sql);
            result = pstmt.executeQuery();

            while (result.next()) {
                Guest guest = new Guest(
                        result.getString("fullName"),
                        result.getString("cin"),
                        result.getString("email"),
                        result.getString("phone"),
                        result.getDouble("balance")
                );
                guest.setGuestId(result.getInt("id"));
                guestList.add(guest);
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
        return guestList;
    }


    public void updateGuestBalance(Guest guest) {
        String Sql = "UPDATE Guest SET  balance = ? WHERE guestid = ?";
        PreparedStatement pstmt = null;

        try {
            pstmt = connection.prepareStatement(Sql);
            pstmt.setDouble(1, guest.getBalance());
            pstmt.setInt(2, guest.getGuestId());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Updating guest failed, no rows affected.");
            }else{
                System.out.println("Updating guest balance");
            }

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
