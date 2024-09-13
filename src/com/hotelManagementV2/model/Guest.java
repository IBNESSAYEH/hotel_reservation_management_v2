package com.hotelManagementV2.model;

import java.math.BigDecimal;

public class Guest {
    private int guestId;
    private String fullName;
    private String cin;
    private String email;
    private String phone;
    private Double balance;

    public Guest( String fullName, String cin, String email, String phone, Double balence) {
        this.balance = balence;
        this.email = email;
        this.cin = cin;
        this.fullName = fullName;
        this.phone = phone;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
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
