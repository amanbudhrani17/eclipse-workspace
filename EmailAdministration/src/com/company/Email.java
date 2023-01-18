package com.company;

import java.util.*;

public class Email {
    public Scanner s = new Scanner(System.in);
    private String fname;
    private String lname;
    private String dept;
    private String email;
    private String password;
    private int mailCapacity = 500;
    private String alterEmail;
    public Email(String fname, String lname){
        this.fname = fname;
        this.lname = lname;
        this.dept = this.setDept();
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
    public void setPassword(){
        boolean flag = true;
        while (flag){
            System.out.println("Do you want to change your password(Y/n)");
            char choice = s.next().toLowerCase().charAt(0);

            if (choice == 'y'){
                flag = false;
                boolean flag2 = true;
                while (flag2) {
                    System.out.println("Enter current password:");
                    String temp = s.next();
                    if (temp.equals(this.password)) {
                        System.out.println("Enter new password");
                        this.password = s.next();
                        flag2 = false;
                    }
                    else{
                        System.out.println("Incorrect Password \n Do you want to try again(Y/n)");
                        char t = s.next().toLowerCase().charAt(0);
                        if (t=='n'){
                            flag2 = false;
                            System.out.println("Password change option cancelled!");
                        }
                        else{
                            continue;
                        }
                    }
                }
            }
            else if (choice == 'n'){
                flag = false;
            }
            else {
                System.out.println("Enter valid choice");
            }
        }

    }
    public void setMailCapacity(){
        System.out.println("Current capacity "+this.mailCapacity+"mb");
        System.out.println("Enter new mailbox capacity");
        this.mailCapacity = s.nextInt();
    }
    public void setAlternateEmail(){
        System.out.println("Enter new alternate mail: ");
        this.alterEmail = s.next();
    }
    public void getInfo(){
        System.out.println("User: "+this.fname+" "+this.lname);
        System.out.println("Department: " + this.dept);
        System.out.println("Email: " + this.email);
        System.out.println("Password: "+this.password);
        System.out.println("Mailbox Capacity: "+this.mailCapacity+"mb");
        System.out.println("Alternate mail: "+this.alterEmail);
    }
}
