package com.nisum.inventory;

import com.sun.org.apache.bcel.internal.generic.ATHROW;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService {
    private Map<Integer,Product> products;
    public ProductService(){
        this.products=new HashMap<>();
    }
//    to add products
    public void addProduct(int id, String name, int qunatity){
        Product product=new Product(id,name,qunatity);
        if(!products.containsKey(product.getId())){
            products.put(product.getId(),product);
        }
        else{
            throw new RuntimeException("product with id "+product.getId()+" already exists");
        }
    }
//    to get product using product id
    public Product getProductWithId(int id){
        if(products.containsKey(id))
            return products.get(id);
        throw new RuntimeException("There is no such product with id: "+id);
    }

//    to get list of all the products present
    public List<Product> getAllProducts(){
        List<Product> allProducts= new ArrayList<>(products.values());
        if(!allProducts.isEmpty()){
            return allProducts;
        }
        throw new RuntimeException("There are products to display");
    }

//    to delete product using id
    public void deleteProductById(int id){
        if(products.containsKey(id))
            products.remove(id);
        else
            throw new RuntimeException("There is not product with id: "+id);
    }

//    to place order i.e. to reduce the quantity of the product
    public String placeOrder(int id, int quantity){
        if(products.containsKey(id)){
            Product currentProduct=products.get(id);
            if(currentProduct.getQuantity()>=quantity){
                currentProduct.setQuantity(currentProduct.getQuantity()-quantity);
                return "Order Placed";
            }
            throw new RuntimeException("There are no sufficient products to place the order, we have only "+currentProduct.getQuantity()+" products");
        }
        throw new RuntimeException("No such product found");
    }

//    to increase product quantity
    public boolean addQuantity(int id, int quantity){
        if(products.containsKey(id)){
            Product currentProduct=products.get(id);
            currentProduct.setQuantity(currentProduct.getQuantity()+quantity);
            return true;
        }
        throw new RuntimeException("There is no such product with id "+id);
    }
}
