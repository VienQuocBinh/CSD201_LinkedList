/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Acer
 */
public class ProductNode {
    Product info;
    ProductNode next;

    public ProductNode(Product x, ProductNode p) {
        info = x;
        next = p;
    }
    public ProductNode(Product x) {
        info = x;
    }
}
