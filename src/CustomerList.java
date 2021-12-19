
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class CustomerList {

    CustomerNode head, tail;

    public CustomerList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void visit(CustomerNode p) {
        if (p != null) {
            System.out.println(" " + p.info);
        }
    }

    void loadFile(String fileName) throws Exception {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String ccode, cus_name, phone;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 3) {
                break;
            }
            a = s.split("[|]");
            ccode = a[0].trim();
            cus_name = a[1].trim();
            phone = a[2].trim();
            addLast(new Customer(ccode, cus_name, phone));
        }
        fr.close();
        br.close();
    }

    void saveFile(String fileName) throws Exception {
        FileWriter fw = new FileWriter(fileName);
        PrintWriter pw = new PrintWriter(fw);
        CustomerNode p = head;
        while (p != null) {
            pw.printf("%-1s | %-4s | %-3s\r", p.info.ccode, p.info.cus_name, p.info.phone);
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public void addLast(Customer c) {
        if (isEmpty()) {
            head = tail = new CustomerNode(c, null);
        } else {
            CustomerNode q = new CustomerNode(c, null);
            tail.next = q;
            tail = q;
        }
    }

    public CustomerNode search(String ccode) {
        CustomerNode p = head;
        while (p != null) {
            if (p.info.ccode.equalsIgnoreCase(ccode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public void delete(String xCode) {
        CustomerNode p = head;
        while (p != null) {
            if (search(xCode) == null) {
                System.out.println("Don't have this customer");
                break;
            }
            if (head.info.ccode.equalsIgnoreCase(xCode)) {
                head = head.next;
                break;
            }
            if (p.next.info.ccode.equalsIgnoreCase(xCode)) {
                if (p.next.next != null) {
                    p.next = p.next.next;
                    break;
                } else {
                    // If xCode at Tail then delete Tail
                    tail = p;
                    p.next = null;
                    break;
                }
            }
            p = p.next;
        }

    }

    public void display() {
        CustomerNode p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }
}
