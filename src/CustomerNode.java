/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class CustomerNode {
    Customer info;
    CustomerNode next;

    public CustomerNode(Customer x, CustomerNode p) {
        info = x;
        next = p;
    }

    public CustomerNode(Customer x) {
        info = x;
    }
    
    
    
    
}
