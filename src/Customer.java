

import MyService.Validation;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class Customer {

    String ccode;
    String cus_name;
    String phone;

    public Customer() {
        ccode = "";
        cus_name = "";
        phone = "";
    }

    public Customer(String ccode, String cus_name, String phone) {
        this.ccode = ccode;
        this.cus_name = cus_name;
        this.phone = phone;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void inputCustomer() throws Exception {

        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String ask;
//        do {
//            try {
//                System.out.println("Enter customer code (Cxx): ");
//                sc = new Scanner(System.in);
//                ccode = sc.nextLine();
//                if (!Validation.isCustomerCodeValid(ccode)) {
//                    throw new Exception();
//                }
//                flag = false;
//            } catch (Exception e) {
//                System.out.println("Invalid customer code");
//                System.out.println("Do you want to continue (y/n): ");
//                sc = new Scanner(System.in);
//                ask = sc.nextLine();
//                if (ask.equalsIgnoreCase("y")) {
//                    flag = true;
//                } else {
//                    throw new Exception();
//                }
//            }
//        } while (flag);

        do {
            try {
                System.out.println("Enter customer name: ");
                sc = new Scanner(System.in);
                cus_name = sc.nextLine();
                if (!Validation.isCharOnlyString(cus_name)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid customer name");
                System.out.println("Do you want to continue (y/n): ");
                sc = new Scanner(System.in);
                ask = sc.nextLine();
                if (ask.equalsIgnoreCase("y")) {
                    flag = true;
                } else {
                    throw new Exception();
                }
            }
        } while (flag);

        do {
            try {
                System.out.println("Enter customer phone number: ");
                sc = new Scanner(System.in);
                phone = sc.nextLine();
                if (!Validation.isPhoneNumber(phone)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid customer phone number");
                System.out.println("Do you want to continue (y/n): ");
                sc = new Scanner(System.in);
                ask = sc.nextLine();
                if (ask.equalsIgnoreCase("y")) {
                    flag = true;
                } else {
                    throw new Exception();
                }
            }
        } while (flag);
    }

    @Override
    public String toString() {
        return String.format("%-1s | %-4s | %-3s\r", ccode, cus_name, phone);
    }

}
