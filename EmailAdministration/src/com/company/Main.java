package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first name");
        String fname = s.next();
        System.out.println("Enter last name");
        String lname = s.next();
        Email email = new Email(fname,lname);
        boolean flag = true;
        while (flag){
            System.out.println("\n*******\nEnter Your Choice\n1 Show Info\n2 Change Password\n3 Set Mail Capacity\n4 Set alternate mail\n5 exit");
            int choice = s.nextInt();
            switch(choice){
                case 1: email.getInfo();
                    break;
                case 2: email.setPassword();
                    break;
                case 3: email.setMailCapacity();
                    break;
                case 4: email.setAlternateEmail();
                    break;
                case 5: System.out.println("Thank you for visiting");
                    flag = false;
                    break;
                default: System.out.println("Invalid choice, choose again");
            }

        }
    }
}
