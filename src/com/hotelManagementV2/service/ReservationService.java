package com.hotelManagementV2.service;

import com.hotelManagementV2.model.Guest;
import com.hotelManagementV2.model.Reservation;
import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.repositorie.ReservationRepository;
import com.hotelManagementV2.util.DateUtils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class ReservationService {
    private ReservationRepository reservationRepository;
    private RoomService roomService;
    private GuestService guestService;


    public ReservationService() {
        this.reservationRepository = new ReservationRepository();
        this.roomService = new RoomService();
        this.guestService = new GuestService();
    }


    public void createReservation(Reservation reservation) {
        try{
            boolean validateNewReservationDate = DateUtils.formattingDate(reservation.getStartDate(), reservation.getEndDate());

            Optional<Room> roomOptional =  this.roomService.getRoomById((long)  reservation.getRoomId());
            Room room = null;
            if (roomOptional.isPresent()) {
                 room = roomOptional.get();
            } else {
                System.out.println("Room not found for iid: " + reservation.getRoomId());
            }
            double roomPrice = room.getPrice() ;
            // LocalDate now = LocalDate.now();
            if (reservation.getStartDate().getMonth() == Month.DECEMBER || reservation.getStartDate().getMonth() == Month.JANUARY || reservation.getStartDate().getMonth()  == Month.JUNE || reservation.getStartDate().getMonth()  == Month.JULY || reservation.getStartDate().getMonth()  == Month.AUGUST) {
                reservation.setSeasonPercentage(roomPrice + (roomPrice * 20 / 100));
            } else {
                reservation.setSeasonPercentage(roomPrice);
            }


            if (validateNewReservationDate )
                reservationRepository.createReservation(reservation);
            else
                System.out.println("start date    should be between current date and end  date of reservation");
        }catch(Exception e){
            System.out.println("the reservation creation was failed"+ e.getMessage());
        }
    }

    public void updateReservation(int reservationId, LocalDate startDate, LocalDate endDate) {
        try {
            Reservation reservation = reservationRepository.findReservationById(reservationId);
            if (reservation == null) {
                System.out.println("Reservation not found for ID: " + reservationId);
                return;
            }

            boolean validateUpdatedReservationDate = DateUtils.formattingDate(startDate, endDate);
            if (!validateUpdatedReservationDate) {
                System.out.println("Start date should be between current date and end date of reservation");
                return;
            }

            reservation.setStartDate(startDate);
            reservation.setEndDate(endDate);

            Optional<Room> roomOptional = this.roomService.getRoomById((long) reservation.getRoomId());
            if (roomOptional.isPresent()) {
                Room room = roomOptional.get();
                double roomPrice = room.getPrice();

                if ( startDate.getMonth() == Month.DECEMBER ||  startDate.getMonth() == Month.JANUARY ||  startDate.getMonth() == Month.JUNE ||  startDate.getMonth() == Month.JULY ||  startDate.getMonth() == Month.AUGUST) {
                    reservation.setSeasonPercentage(roomPrice + (roomPrice * 20 / 100));

                } else {


                    reservation.setSeasonPercentage(roomPrice);
                }
            } else {
                System.out.println("Room not found for ID: " + reservation.getRoomId());
                return;
            }

            reservationRepository.updateReservation(reservation);
            System.out.println("Reservation updated successfully.");
        } catch (Exception e) {
            System.out.println("The reservation update failed: " + e.getMessage());
        }
    }

    public void cancelReservation(int reservationId) {
        try {
            Reservation reservation = reservationRepository.findReservationById(reservationId);
            if (reservation == null) {
                System.out.println("Reservation not found for ID: " + reservationId);
                return;
            }

            reservation.setCanceled(true);

            Month month = reservation.getStartDate().getMonth();
            if (month == Month.JUNE || month == Month.JULY || month == Month.AUGUST || month == Month.DECEMBER || month == Month.JANUARY) {
                double reducedPercentage = reservation.getSeasonPercentage() * 0.8;
                reservation.setSeasonPercentage(reducedPercentage);
            }

            reservationRepository.updateReservation(reservation);

            System.out.println("Reservation canceled success.");
        } catch (Exception e) {
            System.out.println("cancelation failed: " + e.getMessage());
        }
    }
    public Reservation getReservationDetails(int reservationId) {
        try {
            return reservationRepository.findReservationById(reservationId);
        } catch (Exception e) {
            System.out.println("error retrieving reservation details: " + e.getMessage());
            return null;
        }
    }


    public void reservationStatistics() {
        List<Reservation> reservations = reservationRepository.getAllReservations();
        long totalRooms = roomService.getAllRooms().size();
        long totalDays = reservations.stream()
                .mapToLong(r -> ChronoUnit.DAYS.between(r.getStartDate(), r.getEndDate()))
                .sum();

        double occupancyRate = reservations.stream()
                .filter(r -> !r.isCanceled())
                .mapToLong(r -> ChronoUnit.DAYS.between(r.getStartDate(), r.getEndDate()))
                .sum() / (double) (totalRooms * totalDays) * 100;

        double totalRevenue = reservations.stream()
                .filter(r -> !r.isCanceled())
                .mapToDouble(Reservation::getSeasonPercentage)
                .sum();

        long canceledReservations = reservations.stream()
                .filter(Reservation::isCanceled)
                .count();

        System.out.println("=================Rapport de Réservation=================");
        System.out.println("Taux d'occupation: " + occupancyRate);
        System.out.println("Revenus générés: " + totalRevenue);
        System.out.println("Réservations annulées: " + canceledReservations);
        System.out.println("=========================================================");
    }

}
