
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ProductList {

    ProductNode head, tail;

    public ProductList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void visit(ProductNode p) {
        if (p != null) {
            System.out.println(" " + p.info);
        }
    }

    void loadFile(String fname) throws IOException { // Using FileReader class
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
        String s;
        String[] a;
        String pcode; // unique
        String pro_name;
        int quantity;
        int saled; // <= quantity
        double price;
        double value;
        while (true) {
            s = br.readLine();
            if (s == null || s.trim().length() < 5) {
                break;
            }
            a = s.split("[|]");
            pcode = a[0].trim();
            pro_name = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());
            saled = Integer.parseInt(a[3].trim());
            price = Double.parseDouble(a[4].trim());
            value = Double.parseDouble(a[5].trim());
            addLast(new Product(pcode, pro_name, quantity, saled, price));
        }
        fr.close();
        br.close();
    }

    void saveFile(String fname) throws IOException { // Using FileReader class
        FileWriter fw = new FileWriter(fname);
        PrintWriter pw = new PrintWriter(fw);
        ProductNode p = head;
        while (p != null) {
            pw.printf("%-1s | %-8s | %2d | %1d | %4.1f | %2.1f\r", p.info.pcode, p.info.pro_name, p.info.quantity, p.info.saled, p.info.price, p.info.price * p.info.saled);
            p = p.next;
        }
        pw.close();
        fw.close();
    }

    public void addLast(Product p) {
        if (isEmpty()) {
            head = tail = new ProductNode(p, null);
        } else {
            ProductNode q = new ProductNode(p, null);
            tail.next = q;
            tail = q;
        }
    }

    public ProductNode search(String xCode) throws Exception {
        ProductNode p = head;
        while (p != null) {
            if (p.info.pcode.equalsIgnoreCase(xCode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public void delete(String xCode) throws Exception {
        ProductNode p = head;
        // Bo lien ket toi x va noi toi x.next

        if (search(xCode).info == null) {
            throw new Exception();
        }
        while (p != null) {
            if (head.info.pcode.equalsIgnoreCase(xCode)) {
                head = head.next;
                break;
            }
            if (p.next.info.pcode.equalsIgnoreCase(xCode)) {
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

    public void sort() {
        ProductNode current = head;
        ProductNode index = null;
        Product temp;
        if (head == null) {
            return;
        } else {
            while (current.next != null) {
                // index points to the node next to current
                index = current.next;
                // swap if current > index
                while (index != null) {
                    if (current.info.getPcode().compareTo(index.info.getPcode()) > 0) {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }

    }

    public void addAfter(Product p, int pos) {

        if (isEmpty()) {
            head = tail = new ProductNode(p, null);
        } else {
            ProductNode q = new ProductNode(p, null);
            ProductNode index = head;
            int count = 0; // current pos
            while (index.next != null) {
                if (count == pos) {
                    q.next = index.next;
                    index.next = q;
                    break;
                }
                index = index.next;
                count++;
            }
            // If pos = Tail then add to tail
            if (index.next == null && count == pos) {
                index.next = q;
                q = tail;
            }
        }
    }

    public void deleteAfter(String xCode) {
        ProductNode temp = head;
        while (temp.next != null) {
            if (temp.info.pcode.equals(xCode)) {
                if (temp.next.next != null) {
                    temp.next = temp.next.next;
                    break;
                } else {
                    // If xCode before Tail
                    tail = temp;
                    temp.next = null;
                    break;
                }
            }
            temp = temp.next;
        }
        if (temp.next == null && temp.info.pcode.equals(xCode)) {
            System.out.println("You are at Tail");
        }
    }

    public void display() {
        ProductNode p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }
}
