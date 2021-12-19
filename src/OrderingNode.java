/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class OrderingNode {
    OrderingNode next;
    Ordering info;

    public OrderingNode(Ordering x, OrderingNode p) {
        info = x;
        next = p;
    }

    public OrderingNode(Ordering x) {
        info = x;
    }
    
    
}
