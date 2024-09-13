package com.hotelManagementV2.controller;

import com.hotelManagementV2.model.Hotel;
import com.hotelManagementV2.service.HotelService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class HotelController {
    private HotelService hotelService;

    public HotelController() {
        this.hotelService = new HotelService();
    }

    public void createHotel(String name, BigDecimal balance) {
        Hotel hotel = new Hotel(0, name, balance);
        hotelService.createHotel(hotel);
    }

    public Optional<Hotel> getHotelById(int id) {
        return hotelService.getHotelById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    public void updateHotel(int hotelId, String name, BigDecimal balance) {
        Optional<Hotel> hotelOpt = hotelService.getHotelById(hotelId);
        if (hotelOpt.isPresent()) {
            Hotel hotel = hotelOpt.get();
            hotel.setName(name);
            hotel.setBalance(balance);
            hotelService.updateHotel(hotel);
        } else {
            System.out.println("Hotel with ID "+ hotelId   + " not found.");
        }
    }

    public void deleteHotel(int id) {
        hotelService.deleteHotel(id);
    }
}
