package com.hotelManagementV2.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Reservation {

    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int roomTypeId;
    private BigDecimal refundAmount;
    private boolean isCanceled;
    private int guestId;
    private int hotelId;

    // Constructors
    public Reservation() {}

    public Reservation(int reservationId, LocalDate startDate, LocalDate endDate, int roomTypeId,
                       BigDecimal refundAmount, boolean isCanceled, int guestId, int hotelId) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.roomTypeId = roomTypeId;
        this.refundAmount = refundAmount;
        this.isCanceled = isCanceled;
        this.guestId = guestId;
        this.hotelId = hotelId;
    }

    // Getters and Setters
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

    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
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
                ", roomTypeId=" + roomTypeId +
                ", refundAmount=" + refundAmount +
                ", isCanceled=" + isCanceled +
                ", guestId=" + guestId +
                ", hotelId=" + hotelId +
                '}';
    }
}
