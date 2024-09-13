package com.hotelManagementV2.service;

import com.hotelManagementV2.model.Guest;
import com.hotelManagementV2.repositorie.GuestRepository;

import java.util.List;
import java.util.Optional;

public class GuestService {
    private GuestRepository guestRepository;
    public GuestService() {
        this.guestRepository = new GuestRepository();
    }

    public void createGuest(Guest guest) {

        try{
            this.guestRepository.createGuest(guest);
        } catch (Exception e) {

            System.out.println("the guest creation was failed" + e.getMessage());
        }

    }

    public Optional<Guest> getGuestById(int id) {
        return this.guestRepository.getGuestById(id);
    }

    public void updateGuest(Guest guest) {
        try {
            guestRepository.updateGuest(guest);
        } catch (Exception e) {
            System.out.println("Guest updatefailed: "   + e.getMessage());
        }
    }
    public void deleteGuest(int id) {
        try {
            guestRepository.deleteGuest(id);
        } catch (Exception e) {
            System.out.println("Guest deletion failed: "+ e.getMessage());
        }
    }
    public List<Guest> getAllGuests() {
        return guestRepository.getAllGuests();
    }

    public void updateGuestBalance(Guest guest) {
            guestRepository.updateGuestBalance(guest);
    }

}
