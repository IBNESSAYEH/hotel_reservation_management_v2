package com.hotelManagementV2.model;

import java.math.BigDecimal;

public class Hotel {
    private int hotelId ;
    private String name ;
    private BigDecimal balance;

    public Hotel(int hotelId, String name, BigDecimal balance) {
        this.hotelId = hotelId;
        this.name = name;
        this.balance = balance;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelId=" + hotelId +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
