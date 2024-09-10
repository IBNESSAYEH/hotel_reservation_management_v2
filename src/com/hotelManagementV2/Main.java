package com.hotelManagementV2;

import com.hotelManagementV2.util.DBConnection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DBConnection.getConnectionInstance();
    }
}