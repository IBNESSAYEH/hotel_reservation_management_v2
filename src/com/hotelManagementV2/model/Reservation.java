package com.hotelManagementV2.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Reservation {

    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomId;
    private Double refundAmount;
    private boolean isCanceled;
    private int guestId;
    private int hotelId;
    private double seasonPercentage;

    // Constructors


    public Reservation( LocalDate startDate, LocalDate endDate, int roomId,
                       Double refundAmount, boolean isCanceled,Double seasonPercentage, int guestId, int hotelId) {

        this.startDate = startDate;
        this.endDate = endDate;
        this.roomId = roomId;
        this.refundAmount = refundAmount;
        this.isCanceled = isCanceled;
        this.guestId = guestId;
        this.hotelId = hotelId;
        this.seasonPercentage = seasonPercentage;
    }

    // Getters and Setters

    public double getSeasonPercentage() {
        return seasonPercentage;
    }

    public void setSeasonPercentage(double seasonPercentage) {
        this.seasonPercentage = seasonPercentage;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public Double getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Double refundAmount) {
        this.refundAmount = refundAmount;
    }

    public boolean isCanceled() {
        return isCanceled;
    }

    public void setCanceled(boolean canceled) {
        isCanceled = canceled;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    // Optional: Override toString() for better logging/visualization
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", roomTypeId=" + roomId +
                ", refundAmount=" + refundAmount +
                ", isCanceled=" + isCanceled +
                ", guestId=" + guestId +
                ", hotelId=" + hotelId +
                '}';
    }
}
