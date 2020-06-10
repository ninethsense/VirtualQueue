package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        // New Customer wants to buy a bottle
        Customer customer = new Customer();

        // Customer Registration
        customer.RegisterMe("+919999999999", PhoneType.APP ); // App or SMS?

        // Assuming Registration successful

        // Customer requests the token using a mobile app, or by sending SMS
        String CustomerToken =  customer.giveMeAToken("695000"); // Pin code

        if (CustomerToken != null) {
            //  Assuming Customer gets the token and he goes to the Outlet
        } else {
            // Seems there are no slots available. Try again later.
            return;
        }


        // At the Outlet, sales guy is scanning the token
        Boolean OutletVerification = new Outlet().isTheTokenShownByCustomerValid(CustomerToken);

        if (OutletVerification) {
            // Assuming the validation is success
            System.out.println("Customer says: Wow, I got the bottle!");
        } else {
            System.out.println("Sales guy says: Get lost!");
        }
    }

    public enum PhoneType { APP, SMS };

    private static class VQServer {
        // Database
        public String[] tokenDB = { "A", "B","C","D","E" };
        public String[] Outlets = {"Outlet1", "Outlet2", "Outlet3"};

        public void registerCustomer(String phoneNumber, PhoneType phonetype) {
            // Register customer

        }
        public String requestNewTokenByCustomer(String pinCode) {
            // Logic for - Token generation logic
            // Logic for - Find nearest outlet using pinCode

            // Send token by SMS if PhoneType is SMS

            return "C"; // Sample token
        }

        public Boolean validateTokenByOutlet(String token) {
            return Arrays.asList(tokenDB).contains(token); // Validate
        }
    };

    static VQServer vqServer = new VQServer();

    private static class Customer {

        public String giveMeAToken(String pinCode) {
            return vqServer.requestNewTokenByCustomer(pinCode);
        }
        public void RegisterMe(String phoneNumber, PhoneType phonetype) {
            // Customer Registration
            vqServer.registerCustomer(phoneNumber, phonetype);
        }
    }
    private static class Outlet {
        public Boolean isTheTokenShownByCustomerValid(String token) {
            return vqServer.validateTokenByOutlet(token);
        }
    }
}