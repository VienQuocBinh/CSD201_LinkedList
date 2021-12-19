


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Acer
 */
public class Ordering {

    Customer c;
    Product p;
    int quantity;

    public Ordering() {
        c = null;
        p = null;
        quantity = 0;
    }

    public Ordering(Customer c, Product p, int quantity) {
        this.c = c;
        this.p = p;
        this.quantity = quantity;
    }

    public Customer getC() {
        return c;
    }

    public void setC(Customer c) {
        this.c = c;
    }

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product: " + p + "\n" 
                + "Customer: " + c + "\n"
                + "Quantity: " + quantity + "\n"
                + "                 ********";
    }

}
