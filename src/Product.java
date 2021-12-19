
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
public class Product {

    String pcode; // unique
    String pro_name;
    int quantity;
    int saled; // <= quantity
    double price;

    public Product() {
        pcode = "";
        pro_name = "";
        quantity = 0;
        saled = 0;
        price = 0;
    }

    public Product(String pcode, String pro_name, int quantity, int saled, double price) {
        this.pcode = pcode;
        this.pro_name = pro_name;
        this.quantity = quantity;
        this.saled = saled;
        this.price = price;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSaled() {
        return saled;
    }

    public void setSaled(int saled) {
        this.saled = saled;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void inputProduct() throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        String ask;

//        do {
//            try {
//                System.out.println("Enter product code (Pxx): ");
//                sc = new Scanner(System.in);
//                pcode = sc.nextLine();
//                if (!Validation.isProductCodeValid(pcode)) {
//                    throw new Exception();
//                }
//                flag = false;
//            } catch (Exception e) {
//                System.out.println("Invalid product code");
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
                System.out.println("Enter product name : ");
                sc = new Scanner(System.in);
                pro_name = sc.nextLine();
                if (!Validation.isCharOnlyString(pro_name)) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid product name");
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
                System.out.println("Enter product quantity : ");
                sc = new Scanner(System.in);
                quantity = sc.nextInt();
                if (quantity < 0) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid product quantity");
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
                System.out.println("Enter product saled : ");
                sc = new Scanner(System.in);
                saled = sc.nextInt();
                if (saled > quantity) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Product saled must be lower than its quantity");
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
                System.out.println("Enter product price : ");
                sc = new Scanner(System.in);
                price = sc.nextDouble();
                if (price < 0) {
                    throw new Exception();
                }
                flag = false;
            } catch (Exception e) {
                System.out.println("Invalid product price");
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
        return String.format("%-1s | %-8s | %2d | %1d | %4.1f | %2.1f\r", pcode, pro_name, quantity, saled, price, price * saled);
    }

}
