/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class OrderingList {

    OrderingNode head, tail;

    public OrderingList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void visit(OrderingNode p) {
        if (p != null) {
            System.out.println(" " + p.info);
        }
    }

    public void addLast(Ordering o) {
        if (isEmpty()) {
            head = tail = new OrderingNode(o, null);
        } else {
            OrderingNode q = new OrderingNode(o, null);
            tail.next = q;
            tail = q;
        }
    }

    public Product searchProduct(String pcode) throws Exception {
        OrderingNode p = head;
        while (p != null) {
            if (p.info.getP().pcode.equalsIgnoreCase(pcode)) {
                return p.info.getP();
            }

            p = p.next;
        }
        return null;
    }

    public Customer searchCustomer(String ccode) throws Exception {
        OrderingNode p = head;
        while (p != null) {
            if (p.info.getC().ccode.equalsIgnoreCase(ccode)) {
                return p.info.getC();
            }
            p = p.next;
        }
        return null;
    }

    public void sort() {
        // sort by pcode + ccode
        OrderingNode current = head;
        OrderingNode index = null;
        Ordering temp;
        if (head == null) {
            return;
        } else {
            while (current.next != null) {
                // index points to the node next to current
                index = current.next;
                // swap if current > index
                // Sort P first then C
                while (index != null) {
                    if (current.info.getP().getPcode().compareTo(index.info.getP().getPcode()) > 0) {
                        temp = current.info;
                        current.info = index.info;
                        index.info = temp;
                    } // If Pcode are same then compare Ccode
                    else if (current.info.getP().getPcode().compareTo(index.info.getP().getPcode()) == 0) {
                        if (current.info.getC().getCcode().compareTo(index.info.getC().getCcode()) > 0) {
                            temp = current.info;
                            current.info = index.info;
                            index.info = temp;
                        }
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }

    }

    public void display() {
        OrderingNode p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

//    public int size() {
//        OrderingNode p = head;
//        int size = 0;
//        while (p != null) {
//            size++;
//            p = p.next;
//        }
//        return size;
//    }
//
//    public Ordering get(int i) {
//        OrderingNode p = head;
//        int pos = 0;
//        if (i == size() - 1) {
//            return tail.info;
//        }
//        while (p != null) {
//            if (pos == i) {
//                return p.info;
//            }
//            p = p.next;
//        }
//
//        return null;
//    }

}
