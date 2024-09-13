package com.hotelManagementV2.controller;

import com.hotelManagementV2.model.Reservation;
import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.service.ReservationService;
import com.hotelManagementV2.service.RoomService;
import com.hotelManagementV2.util.DateUtils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Optional;

public class ReservationController {
    private ReservationService reservationService;
    private RoomService roomService;



    public ReservationController() {
        this.reservationService = new ReservationService();
        this.roomService = new RoomService();

    }

    public void createReservation( LocalDate startDate, LocalDate endDate,
                                  boolean isCanceled, Double seasonPercentage, int guestId, int hotelId, String category) {
        int roomid = roomService.isAvailableRooms(startDate, endDate, category);
        Reservation reservation = null;
        if(roomid > 0) {
            reservation = new Reservation( startDate, endDate, roomid, 0.00,
                    isCanceled,0.00, guestId, hotelId);
        }else{
            System.out.println("no room   available");
            return;
        }

        try{
            reservationService.createReservation(reservation);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void viewReservationDetails(int reservationId) {
        Reservation reservation = reservationService.getReservationDetails(reservationId);
        if (reservation != null) {
            System.out.println("Reservation Details:");
            System.out.println("iD:"+ reservation.getReservationId());
            System.out.println("start date: " + reservation.getStartDate());
            System.out.println("end date: "+ reservation.getEndDate());
            System.out.println("room Id:" +   reservation.getRoomId());
            System.out.println("refund Amount: " + reservation.getRefundAmount());
            System.out.println("is Canceled: "+ reservation.isCanceled());
            System.out.println("season Percentage: " + reservation.getSeasonPercentage());
            System.out.println("guest id:"   + reservation.getGuestId());
            System.out.println("hotel iD: " + reservation.getHotelId());
        } else {
            System.out.println("Reservationnot found.");
        }
    }

    public void generateReservationStatistics() {
        reservationService.reservationStatistics();
    }

    public void updateReservation(int reservationId, LocalDate startDate, LocalDate endDate) {
        reservationService.updateReservation(reservationId, startDate, endDate);
    }

    public void cancelReservation(int reservationId) {
        reservationService.cancelReservation(reservationId);
    }


}
