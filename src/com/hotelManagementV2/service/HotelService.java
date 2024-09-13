package com.hotelManagementV2.service;

import com.hotelManagementV2.model.Hotel;
import com.hotelManagementV2.repositorie.HotelRepository;

import java.util.List;
import java.util.Optional;

public class HotelService {
    private HotelRepository hotelRepository;

    public HotelService() {
        this.hotelRepository = new HotelRepository();
    }

    public void createHotel(Hotel hotel) {
        try {
            hotelRepository.createHotel(hotel);
        } catch (Exception e) {
            System.out.println("Hotel  creation failed: "+ e.getMessage());
        }
    }

    public Optional<Hotel> getHotelById(int id) {
        return hotelRepository.getHotelById(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelRepository.getAllHotels();
    }

    public void updateHotel(Hotel hotel) {
        try {
            hotelRepository.updateHotel(hotel);
        } catch (Exception e) {
            System.out.println("Hotel update failed: " + e.getMessage());
        }
    }

    public void deleteHotel(int id) {
        try {
            hotelRepository.deleteHotel(id);
        } catch (Exception e) {
            System.out.println("Hotel deletion failed: " + e.getMessage());
        }
    }
}
