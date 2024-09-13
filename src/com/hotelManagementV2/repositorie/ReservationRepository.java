package com.hotelManagementV2.repositorie;

import com.hotelManagementV2.model.Reservation;
import com.hotelManagementV2.util.DBConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private Connection connection;

    public ReservationRepository() {
        this.connection = DBConnection.getConnectionInstance().getConnection();
    }

    public void createReservation(Reservation reservation) {
        String sqlQuery = "insert into reservation (startdate, enddate, roomid, refundamount," +
                            " iscanceled,seasonpercentage, guestid, hotelid) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pStatement = null;
        ResultSet generatedKeys = null;
        try{
            pStatement = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS );
            pStatement.setDate(1, Date.valueOf(reservation.getStartDate()));
            pStatement.setDate(2, Date.valueOf(reservation.getEndDate()));
            pStatement.setInt(3,reservation.getRoomId());
            pStatement.setDouble(4,reservation.getRefundAmount());
            pStatement.setBoolean(5,reservation.isCanceled());
            pStatement.setDouble(6,reservation.getSeasonPercentage());
            pStatement.setInt(7,reservation.getGuestId());
            pStatement.setInt(8,reservation.getHotelId());

            int affectedRow = pStatement.executeUpdate();
            if (affectedRow == 0) throw new SQLException("guest insertion failed");

            generatedKeys = pStatement.getGeneratedKeys();
            if (generatedKeys.next()) reservation.setReservationId(generatedKeys.getInt(1));
             else throw new SQLException("creating room failed, no ID obtained.");

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                if (generatedKeys != null) generatedKeys.close();
                if (pStatement != null) pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public void updateReservation(Reservation reservation) {
        String sqlQuery = "UPDATE reservation SET startdate = ?, enddate = ?, roomid = ?, refundamount = ?, iscanceled = ?, seasonpercentage = ?, guestid = ?, hotelid = ? WHERE reservationid = ?";
        PreparedStatement pStatement = null;
        try {
            pStatement = connection.prepareStatement(sqlQuery);
            pStatement.setDate(1, Date.valueOf(reservation.getStartDate()));
            pStatement.setDate(2, Date.valueOf(reservation.getEndDate()));
            pStatement.setInt(3, reservation.getRoomId());
            pStatement.setDouble(4, reservation.getRefundAmount());
            pStatement.setBoolean(5, reservation.isCanceled());
            pStatement.setDouble(6, reservation.getSeasonPercentage());
            pStatement.setInt(7, reservation.getGuestId());
            pStatement.setInt(8, reservation.getHotelId());
            pStatement.setInt(9, reservation.getReservationId());

            int affectedRow = pStatement.executeUpdate();
            if (affectedRow == 0) throw new SQLException("updating reservation failed");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pStatement != null) pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Reservation findReservationById(int reservationId) {
        String sqlQuery = "SELECT * FROM reservation WHERE reservationid = ?";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        Reservation reservation = null;
        try {
            pStatement = connection.prepareStatement(sqlQuery);
            pStatement.setInt(1, reservationId);

            resultSet = pStatement.executeQuery();
            if (resultSet.next()) {
                reservation = new Reservation(
                        resultSet.getDate("startdate").toLocalDate(),
                        resultSet.getDate("enddate").toLocalDate(),
                        resultSet.getInt("roomid"),
                        resultSet.getDouble("refundamount"),
                        resultSet.getBoolean("iscanceled"),
                        resultSet.getDouble("seasonpercentage"),
                        resultSet.getInt("guestid"),
                        resultSet.getInt("hotelid")
                );
                reservation.setReservationId(reservationId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pStatement != null) pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        String sqlQuery = "SELECT * FROM reservation";
        PreparedStatement pStatement = null;
        ResultSet resultSet = null;
        List<Reservation> reservations = new ArrayList<>();

        try {
            pStatement = connection.prepareStatement(sqlQuery);
            resultSet = pStatement.executeQuery();

            while (resultSet.next()) {
                Reservation reservation = new Reservation(
                        resultSet.getDate("startdate").toLocalDate(),
                        resultSet.getDate("enddate").toLocalDate(),
                        resultSet.getInt("roomid"),
                        resultSet.getDouble("refundamount"),
                        resultSet.getBoolean("iscanceled"),
                        resultSet.getDouble("seasonpercentage"),
                        resultSet.getInt("guestid"),
                        resultSet.getInt("hotelid")
                );
                reservation.setReservationId(resultSet.getInt("reservationid"));
                reservations.add(reservation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (pStatement != null) pStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return reservations;
    }

}
