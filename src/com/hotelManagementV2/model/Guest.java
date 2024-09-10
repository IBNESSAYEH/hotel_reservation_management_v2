package com.hotelManagementV2.model;

import java.math.BigDecimal;

public class Guest {
    private int guestId;
    private String fullName;
    private String cin;
    private String email;
    private String phone;
    private BigDecimal balance;

    public Guest(BigDecimal balance, String email, String cin, String fullName, int guestId, String phone) {
        this.balance = balance;
        this.email = email;
        this.cin = cin;
        this.fullName = fullName;
        this.guestId = guestId;
        this.phone = phone;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return "Guest{" +
                "guestId=" + guestId +
                ", fullName='" + fullName + '\'' +
                ", cin='" + cin + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", balance=" + balance +
                '}';
    }
}
