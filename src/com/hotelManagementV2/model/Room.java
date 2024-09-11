package com.hotelManagementV2.model;

public class Room {

    private int roomId;
    private String category;
    private Double price;
    private int roomNumbers;
    private Double tarif;
    private Integer roomSize;
    private Long hotelId;

    public Room(int roomId, String category, Double price, int roomNumbers, Double tarif, Integer roomSize, Long hotelId) {
        this.roomId = roomId;
        this.category = category;
        this.price = price;
        this.roomNumbers = roomNumbers;
        this.tarif = tarif;
        this.roomSize = roomSize;
        this.hotelId = hotelId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getRoomNumbers() {
        return roomNumbers;
    }

    public void setRoomNumbers(int roomNumbers) {
        this.roomNumbers = roomNumbers;
    }

    public Double getTarif() {
        return tarif;
    }

    public void setTarif(Double tarif) {
        this.tarif = tarif;
    }

    public Integer getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(Integer roomSize) {
        this.roomSize = roomSize;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", roomNumbers=" + roomNumbers +
                ", tarif=" + tarif +
                ", roomSize=" + roomSize +
                ", hotelId=" + hotelId +
                '}';
    }
}
