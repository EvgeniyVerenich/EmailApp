package org.example;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;

    private String email;

    private String companySuffix = "yourcompany.com";

    private int defaultPasswordLength = 10;
    private String department;
    private int mailboxCapacity = 500;
    private String alternateEmail;

    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is " + this.password);
        email = firstName.toLowerCase() + "." + lastName.toLowerCase()
                + "@" + department + "." + companySuffix;
    }

    private String setDepartment(){
        System.out.println("Enter the department\n 0 for none\n 1 for Sale\n 2 for Development\n 3 for Accounting");
        Scanner in = new Scanner(System.in);
        int numOfDep = in.nextInt();
        switch (numOfDep) {
            case 1 -> {
                return "sale";
            }
            case 2 -> {
                return "dev";
            }
            case 3 -> {
                return "acct";
            }
            default -> {
                return "";
            }
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@!#$%^&*";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    public void setAlternateEmail(String alternateEmail){
        this.alternateEmail = alternateEmail;
    }

    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){
        return mailboxCapacity;
    }

    public String getAlternateEmail(){
        return alternateEmail;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName
                + "\nCOMPANY EMAIL: " + email
                + "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
