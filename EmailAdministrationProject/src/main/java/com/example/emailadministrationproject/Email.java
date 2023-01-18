package com.example.emailadministrationproject;

import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);
    private String fname;
    public String lname;
    public String dept;
    public String email;
    public String password;
    private int mailCapacity = 500;
    public String alterEmail;
    public Email(String fname, String lname, String dept){
        this.fname = fname;
        this.lname = lname;
        this.dept = dept;
        this.password = this.generatePassword(12);
        this.email = this.generateEmail();
    }
    private String generateEmail(){
        return this.fname.toLowerCase()+"."+this.lname.toLowerCase()+"@"+this.dept.toLowerCase()+".bb.com";
    }

    private String setDept(){
        System.out.println("Department Codes \n1 for sales \n2 for Development \n3 for Accounting");
        boolean flag = true;
        int choice = s.nextInt();
        while (flag) {
            System.out.println("Enter Department Code");
            switch (choice) {
                case 1:
                    return "sales";
                case 2:
                    return "development";
                case 3:
                    return "accounting";
                default:
                    System.out.println("Invalid choice please choose again");
            }
        }
        return null;
    }
    private String generatePassword(int length){
        Random r = new Random();
        String password = "";
        String values = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%&?";
        for (int i = 0; i<length; i++){
            password = password+values.charAt(r.nextInt(values.length()));
        }
        return password;
    }
    public void setPassword(String str){
        this.password = str;
    }
    public void setMailCapacity(int m){
        this.mailCapacity = m;
    }
    public void setAlternateEmail(String str){
        this.alterEmail = str;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Username: "+this.fname+" "+this.lname);
        sb.append(System.lineSeparator());
        sb.append("Department: " + this.dept);
        sb.append(System.lineSeparator());
        sb.append("Email: " + this.email);
        sb.append(System.lineSeparator());
        sb.append("Password: "+this.password);
        sb.append(System.lineSeparator());
        sb.append("Mailbox Capacity: "+this.mailCapacity+"mb");
        sb.append(System.lineSeparator());
        sb.append("Alternate mail: "+this.alterEmail);
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}
