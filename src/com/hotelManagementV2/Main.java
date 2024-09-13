package com.hotelManagementV2;

import com.hotelManagementV2.controller.GuestController;
import com.hotelManagementV2.controller.ReservationController;
import com.hotelManagementV2.controller.RoomController;
import com.hotelManagementV2.model.Guest;
import com.hotelManagementV2.model.Room;
import com.hotelManagementV2.repositorie.GuestRepository;
import com.hotelManagementV2.repositorie.RoomRepository;
import com.hotelManagementV2.util.DBConnection;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choix = 0;
        do{
            System.out.println("==========================Main Menu=================================");
            System.out.println("1/ guest management : \n" +
                    "2/ hotel Management : \n" +
                    "3/ room management : \n" +
                    "4/ reservation Management : \n" +
                    "5/ exit : ");
            System.out.println("===================================================================");
            System.out.println("enter your choice");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1: guestManagement();
                    break;
                case 4: reservationManagement();
                    break;
                case 5:
                    System.out.println("see you soon !");
                    break;
                default:
                    System.out.println("invalid choice");
            }

        } while(choix != 5);

    }





    public static void guestManagement() {
     GuestController guestController = new GuestController();

        Scanner sc = new Scanner(System.in);

        int choix = 0;
        do {
            System.out.println("==========================guest Menu=================================");
            System.out.println("1/ create guest : \n" +
                    "2/ upadte guest : \n" +
                    "3/ delete guest : \n" +
                    "4/ retrieve all guests : \n" +
                    "5/ exit : ");
            System.out.println("===================================================================");
            System.out.println("enter your choice");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:{
                    System.out.println("enter the guest fullName");
                    String fullName = sc.nextLine();
                    System.out.println("enter the guest cin");
                    String cin = sc.nextLine();
                    System.out.println("enter the guest email");
                    String email = sc.nextLine();
                    System.out.println("enter the guest phone");
                    String phone = sc.nextLine();

                    guestController.createGuest(fullName, cin, email, phone,0.00);
                }
                break;
                case 2:{
                    System.out.println("enter the new guest fullName");
                    String fullName = sc.nextLine();
                    System.out.println("enter the  new guest cin");
                    String cin = sc.nextLine();
                    System.out.println("enter the  new guest email");
                    String email = sc.nextLine();
                    System.out.println("enter the  new guest phone");
                    String phone = sc.nextLine();
                    System.out.println("enter the guest id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    guestController.updateGuest(id,fullName, cin, email, phone,0.00);
                }
                break;
                case 3:{
                    System.out.println("enter the new guest id");
                    int id = sc.nextInt();
                    sc.nextLine();
                    guestController.deleteGuest(id);
                    System.out.println("guest was deleted successfully");
                }

                case 5:
                    System.out.println("you are back to main menu");
                    break;
                default:
                    System.out.println("invalid choice");
            }

        } while (choix != 5);
    }

    public static void reservationManagement() {
        ReservationController reservationController = new ReservationController();
        GuestController guestController = new GuestController();

        Scanner sc = new Scanner(System.in);

        int choix = 0;
        do {
            System.out.println("==========================reservation Menu=================================");
            System.out.println("1/ create reservation : \n" +
                    "2/ upadte reservation : \n" +
                    "3/ delete reservation : \n" +
                    "4/ retrieve all reservation : \n" +
                    "5/ generate reservations statistics : \n" +
                    "6/ Quitter");
            System.out.println("===================================================================");
            System.out.println("enter your choice");
            choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:{
                    System.out.println("enter the reservation startDate");
                    String startDateInput = sc.nextLine();
                    LocalDate startDate = LocalDate.parse(startDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    System.out.println("enter the reservation endDate");
                    String endDateinput = sc.nextLine();
                    LocalDate endDate = LocalDate.parse(endDateinput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    System.out.println("enter the room category");
                    String category = sc.nextLine();
                    System.out.println("enter the reservation guest id");
                    int guestId = sc.nextInt();
                    sc.nextLine();

                    reservationController.createReservation(startDate,  endDate,
                    false, 0.00,  guestId,  1,  category);
                }
                break;

                case 2:
                    System.out.println("Enter the reservation ID:");
                    int updateId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the new start date (yyyy-MM-dd):");
                    LocalDate newStartDate = LocalDate.parse(sc.nextLine());
                    System.out.println("Enter the new end date (yyyy-MM-dd):");
                    LocalDate newEndDate = LocalDate.parse(sc.nextLine());
                    reservationController.updateReservation(updateId, newStartDate, newEndDate);
                    break;
                case 3:
                    System.out.println("Enter the reservation ID to cancel:");
                    int cancelId = sc.nextInt();
                    sc.nextLine();
                    reservationController.cancelReservation(cancelId);
                    break;
                case 4:
                    System.out.println("Enter the reservation ID to view details:");
                    int viewId = sc.nextInt();
                    sc.nextLine();
                    reservationController.viewReservationDetails(viewId);
                    break;
                case 5:

                    reservationController.generateReservationStatistics();
                    break;
                case 6:
                    System.out.println("you are back to home : ");
                    break;
                default:
                    System.out.println("invalid choice : ");

            }

        } while (choix != 6);
    }

}