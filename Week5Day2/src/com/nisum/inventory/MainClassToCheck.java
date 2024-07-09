package com.nisum.inventory;
/* commenting the code which might
throw exceptions at runtime */
public class MainClassToCheck {
    public static void main(String[] args) {
        ProductService ps=new ProductService();
//        adding products
        ps.addProduct(12,"Apple",10);
        ps.addProduct(2,"Mobile",5);
        ps.addProduct(5,"Watch",10);

//        validating the implemented methods
        System.out.println(ps.getAllProducts());
        System.out.println(ps.getProductWithId(2));
//        System.out.println(ps.getProductWithId(15));
        System.out.println(ps.placeOrder(12,10));
//        System.out.println(ps.placeOrder(12,1));
        System.out.println(ps.addQuantity(12,23));
//        System.out.println(ps.addQuantity(10,23));
        System.out.println(ps.getProductWithId(12));
    }
}
