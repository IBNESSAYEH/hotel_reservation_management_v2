package com.hotelManagementV2.controller;

import com.hotelManagementV2.model.Guest;
import com.hotelManagementV2.service.GuestService;

import java.util.List;
import java.util.Optional;

public class GuestController {
    private GuestService guestService;

    public GuestController() {
        this.guestService = new GuestService();
    }

    public void createGuest(String fullName, String cin, String email, String phone, Double balence) {
        Guest guest = new Guest(fullName, cin, email, phone, balence);
            this.guestService.createGuest(guest);
    }

    public Optional<Guest> getGuestById(int id){

        return this.guestService.getGuestById(id);
    }


    public void updateGuest(int id, String fullName, String cin, String email, String phone, Double balance) {
        Optional<Guest> guestOpt = getGuestById(id);
        if (guestOpt.isPresent()) {
            Guest guest = guestOpt.get();
            guest.setFullName(fullName);
            guest.setCin(cin);
            guest.setEmail(email);
            guest.setPhone(phone);
            guest.setBalance(balance);
            guestService.updateGuest(guest);
        } else {
            System.out.println("Guest with id "+   id + " not found.");
        }
    }
    public void deleteGuest(int id) {

        guestService.deleteGuest(id);
    }

    public List<Guest> getAllGuests() {

        return guestService.getAllGuests();
    }

}

