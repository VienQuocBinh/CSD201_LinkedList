
import MyService.Validation;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ProductList listOfPro = new ProductList();
        CustomerList listOfCus = new CustomerList();
        OrderingList listOfOrder = new OrderingList();
        int choice = -1;
        int pchoice = -1;
        int cchoice = -1;
        int ochoice = -1;
        int quantity = 0;
        boolean flag = false;
        String pcode = "";
        String ccode = "";
        String ask;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Product List");
            System.out.println("2. Customer List");
            System.out.println("3. Ordering List");
            System.out.println("Other is quit");
            System.out.println("Select option: ");

            do {
                try {
                    sc = new Scanner(System.in);
                    choice = sc.nextInt();
                    flag = false;
                } catch (Exception e) {
                    System.out.println("Enter the number");
                    flag = true;
                }
            } while (flag);
            switch (choice) {
                case 1:
                    do {
                        System.out.println("1. Load data from file");
                        System.out.println("2. Input and add product");
                        System.out.println("3. Display product");
                        System.out.println("4. Save list to file");
                        System.out.println("5. Search by product code");
                        System.out.println("6. Delete by product code");
                        System.out.println("7. Sort by product code");
                        System.out.println("8. Add after position k");
                        System.out.println("9. Delete after product");
                        System.out.println("Other: return to menu");
                        System.out.println("Your option: ");
                        do {
                            try {
                                sc = new Scanner(System.in);
                                pchoice = sc.nextInt();
                                flag = false;
                            } catch (Exception e) {
                                System.out.println("Enter the number");
                                flag = true;
                            }
                        } while (flag);

                        switch (pchoice) {
                            case 1:
                                String fileName = "";
                                try {
                                    System.out.println("Enter file name: ");
                                    sc = new Scanner(System.in);
                                    fileName = sc.nextLine();
                                    listOfPro.clear();
                                    listOfPro.loadFile(fileName + ".txt");

                                } catch (IOException e) {
                                    System.out.println("Not found the file name " + fileName + ".txt");
                                }
                                listOfPro.display();
                                break;

                            case 2:
                                try {
                                Product p = new Product();

                                do {
                                    try {
                                        System.out.println("Enter product code (Pxx): ");
                                        sc = new Scanner(System.in);
                                        pcode = sc.nextLine();
                                        if (!Validation.isProductCodeValid(pcode)) {
                                            throw new Exception("Invalid product code");
                                        }
                                        if (listOfPro.search(pcode) != null) {
                                            throw new Exception("Already has in the list");
                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
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
                                p.inputProduct();
                                p.setPcode(pcode);
                                listOfPro.addLast(p);
                            } catch (Exception e) {
                                System.out.println("Add fail");
                            }
                            break;

                            case 3:

                                listOfPro.display();
                                break;
                            case 4:
                                String fname;
                                try {
                                    System.out.println("Enter file name: ");
                                    sc = new Scanner(System.in);
                                    fname = sc.nextLine();
                                    listOfPro.saveFile(fname + ".txt");
                                    System.out.println("Save to file " + fname + ".txt");
                                } catch (IOException e) {
                                    System.out.println("Can't save");
                                }
                                break;

                            case 5:

                                do {

                                    try {
                                        System.out.println("Enter product code (Pxx): ");
                                        sc = new Scanner(System.in);
                                        pcode = sc.nextLine();
                                        if (!Validation.isProductCodeValid(pcode)) {
                                            throw new Exception();
                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println("Invalid product code");
                                        System.out.println("Do you want to continue (y/n): ");
                                        sc = new Scanner(System.in);
                                        ask = sc.nextLine();
                                        flag = (ask.equalsIgnoreCase("y"));
                                    }
                                } while (flag);

                                try {
                                    if (listOfPro.search(pcode).info != null) {
                                        System.out.println("Found\n" + listOfPro.search(pcode).info);
                                    } else {
                                        throw new Exception();
                                    }
                                } catch (Exception e) {
                                    System.out.println("Not found");
                                }
                                break;
                            case 6:

                                do {

                                    try {
                                        System.out.println("Enter product code (Pxx): ");
                                        sc = new Scanner(System.in);
                                        pcode = sc.nextLine();
                                        if (!Validation.isProductCodeValid(pcode)) {
                                            throw new Exception();
                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println("Invalid product code");
                                        System.out.println("Do you want to continue (y/n): ");
                                        sc = new Scanner(System.in);
                                        ask = sc.nextLine();
                                        flag = (ask.equalsIgnoreCase("y"));
                                    }
                                } while (flag);

                                try {
                                    listOfPro.delete(pcode);
                                    System.out.println("Deleted");
                                } catch (Exception e) {
                                    System.out.println("Don't have this product");
                                }

                                break;
                            case 7:

                                listOfPro.sort();
                                listOfPro.display();
                                break;
                            case 8:
                                int k = -1;
                                do {
                                    try {
                                        System.out.println("Enter postion: ");
                                        sc = new Scanner(System.in);
                                        k = sc.nextInt();
                                        if (k < 0) {
                                            throw new Exception();
                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println("Enter valid number");
                                        flag = true;
                                    }
                                } while (flag);
                                try {
                                    Product p = new Product();

                                    do {
                                        try {
                                            System.out.println("Enter product code (Pxx): ");
                                            sc = new Scanner(System.in);
                                            pcode = sc.nextLine();
                                            if (!Validation.isProductCodeValid(pcode)) {
                                                throw new Exception("Invalid product code");
                                            }
                                            if (listOfPro.search(pcode) != null) {
                                                throw new Exception("Already has in the list");
                                            }
                                            flag = false;
                                        } catch (Exception e) {
                                            System.out.println(e.getMessage());
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
                                    p.inputProduct();
                                    p.setPcode(pcode);
                                    listOfPro.addAfter(p, k);
                                } catch (Exception e) {
                                    System.out.println("Add after fail");
                                }

                                break;
                            case 9:
                                try {
                                System.out.println("Enter product code: ");
                                sc = new Scanner(System.in);
                                pcode = sc.nextLine();
                                if (!Validation.isProductCodeValid(pcode)) {
                                    throw new Exception("Wrong format");
                                }
                                if (listOfPro.search(pcode) == null) {
                                    throw new Exception("Don't have this product");
                                }
                                listOfPro.deleteAfter(pcode);
                                System.out.println("Delete after success");
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                System.out.println("Fail");

                            }

                            break;
                        }
                    } while (pchoice >= 1 && pchoice <= 9);

                    break;
                case 2:
                    do {
                        System.out.println("1. Load data from file");
                        System.out.println("2. Input and add customer");
                        System.out.println("3. Display customer");
                        System.out.println("4. Save list to file");
                        System.out.println("5. Search by customer code");
                        System.out.println("6. Delete by customer code");
                        System.out.println("Other: return to menu");
                        System.out.println("Your option: ");
                        do {
                            try {
                                sc = new Scanner(System.in);
                                cchoice = sc.nextInt();
                                flag = false;
                            } catch (Exception e) {
                                System.out.println("Enter the number");
                                flag = true;
                            }
                        } while (flag);
                        switch (cchoice) {
                            case 1:
                                String filename = "";
                                try {
                                    System.out.println("Enter file name: ");
                                    sc = new Scanner(System.in);
                                    filename = sc.nextLine();
                                    listOfCus.clear();
                                    listOfCus.loadFile(filename + ".txt");
                                    listOfCus.display();
                                } catch (Exception e) {
                                    System.out.println("Don't find " + filename + ".txt");
                                }
                                break;
                            case 2:
                                try {
                                Customer c = new Customer();
                                do {
                                    try {
                                        System.out.println("Enter customer code (Cxx): ");
                                        sc = new Scanner(System.in);
                                        ccode = sc.nextLine();
                                        if (!Validation.isCustomerCodeValid(ccode)) {
                                            throw new Exception("Invalid customer code");
                                        }
                                        if (listOfCus.search(ccode) != null) {
                                            throw new Exception("Already have in the customer list");

                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
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
                                c.setCcode(ccode);
                                c.inputCustomer();
                                listOfCus.addLast(c);
                            } catch (Exception e) {
                                System.out.println("Add fail");
                            }

                            break;
                            case 3:
                                listOfCus.display();
                                break;
                            case 4:
                                try {
                                System.out.println("Enter file name: ");
                                sc = new Scanner(System.in);
                                filename = sc.nextLine();
                                listOfCus.saveFile(filename + ".txt");
                                System.out.println("Saved");
                            } catch (Exception e) {
                                System.out.println("Saved fail");
                            }
                            break;
                            case 5:

                                do {
                                    try {
                                        System.out.println("Enter customer code: ");
                                        sc = new Scanner(System.in);
                                        ccode = sc.nextLine();
                                        if (listOfCus.search(ccode) == null) {
                                            throw new Exception("Not found this customer");
                                        }
                                        System.out.println("Found");
                                        System.out.println(listOfCus.search(ccode).info);
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Do you want to continue (y/n): ");
                                        sc = new Scanner(System.in);
                                        ask = sc.nextLine();
                                        flag = ask.equalsIgnoreCase("y");
                                    }
                                } while (flag);

                                break;
                            case 6:
                                do {
                                    try {
                                        System.out.println("Enter customer code: ");
                                        sc = new Scanner(System.in);
                                        ccode = sc.nextLine();
                                        if (listOfCus.search(ccode) == null) {
                                            throw new Exception("Not found this customer");
                                        }
                                        System.out.println("Deleted");
                                        listOfCus.delete(ccode);
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Do you want to continue (y/n): ");
                                        sc = new Scanner(System.in);
                                        ask = sc.nextLine();
                                        flag = ask.equalsIgnoreCase("y");
                                    }
                                } while (flag);
                                break;
                        }

                    } while (cchoice >= 1 && cchoice <= 6);

                    break;
                case 3:
                    do {
                        System.out.println("1. Input ordering");
                        System.out.println("2. Display ordering");
                        System.out.println("3. Sort");
                        System.out.println("Other: return to menu");
                        System.out.println("Your choice");

                        do {
                            try {
                                sc = new Scanner(System.in);
                                ochoice = sc.nextInt();
                                flag = false;
                            } catch (Exception e) {
                                System.out.println("Enter the number");
                                flag = true;
                            }
                        } while (flag);
                        switch (ochoice) {
                            case 1:
                                Ordering o = new Ordering();
                                do {
                                    try {

                                        System.out.println("Enter product code (Pxx): ");
                                        sc = new Scanner(System.in);
                                        pcode = sc.nextLine();
                                        if (!Validation.isProductCodeValid(pcode)) {
                                            throw new Exception("Wrong format");
                                        }
                                        if (listOfPro.search(pcode) == null) {
                                            throw new Exception("Don't have this product");
                                        }
                                        o.setP(listOfPro.search(pcode).info);

                                        System.out.println("Enter customer code (Cxx): ");
                                        sc = new Scanner(System.in);
                                        ccode = sc.nextLine();
                                        if (!Validation.isCustomerCodeValid(ccode)) {
                                            throw new Exception("Wrong format");
                                        }
                                        if (listOfCus.search(ccode) == null) {
                                            throw new Exception("Don't have this customer");
                                        }
                                        o.setC(listOfCus.search(ccode).info);

                                        if (listOfOrder.searchCustomer(ccode) != null && listOfOrder.searchProduct(pcode) != null) {
                                            throw new Exception("Customer and product are in other order");

                                        }

                                        System.out.println("Enter quantity: ");
                                        sc = new Scanner(System.in);
                                        quantity = sc.nextInt();
                                        if (quantity <= 0) {
                                            throw new Exception("Not equal to 0");
                                        }
                                        if ((o.getP().quantity - o.getP().saled) >= quantity) {
                                            throw new Exception("The product is exhausted (Product remaing " + (o.getP().quantity - o.getP().saled) + ")");
                                        } else {
                                            o.setQuantity(quantity);
                                            listOfOrder.addLast(o);
                                        }
                                        flag = false;
                                    } catch (Exception e) {
                                        System.out.println(e.getMessage());
                                        System.out.println("Do you want to continue (y/n): ");
                                        sc = new Scanner(System.in);
                                        ask = sc.nextLine();
                                        flag = ask.equalsIgnoreCase("y");
                                    }
                                } while (flag);
                                break;
                            case 2:
                                listOfOrder.display();
                                break;
                            case 3:
                                listOfOrder.sort();
                                listOfOrder.display();
                                break;
                        }

                    } while (ochoice >= 1 && ochoice <= 3);

                    break;
            }

        } while (choice >= 1 && choice <= 3);
    }
}
