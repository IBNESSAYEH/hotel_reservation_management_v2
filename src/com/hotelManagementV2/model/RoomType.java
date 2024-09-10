package com.hotelManagementV2.model;

import java.math.BigDecimal;

public class RoomType {

    private int roomTypeId;
    private String category;
    private BigDecimal price;
    private int roomNumbers;
    private BigDecimal tarif;
    private int roomSize;


    public RoomType() {}

    public RoomType(int roomTypeId, String category, BigDecimal price, int roomNumbers, BigDecimal tarif, int roomSize) {
        this.roomTypeId = roomTypeId;
        this.category = category;
        this.price = price;
        this.roomNumbers = roomNumbers;
        this.tarif = tarif;
        this.roomSize = roomSize;
    }


    public int getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(int roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public BigDecimal getTarif() {
        return tarif;
    }

    public void setTarif(BigDecimal tarif) {
        this.tarif = tarif;
    }

    public int getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(int roomSize) {
        this.roomSize = roomSize;
    }


    @Override
    public String toString() {
        return "RoomType{" +
                "roomTypeId=" + roomTypeId +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", roomNumbers=" + roomNumbers +
                ", tarif=" + tarif +
                ", roomSize=" + roomSize +
                '}';
    }
}
