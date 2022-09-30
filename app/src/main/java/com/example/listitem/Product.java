package com.example.listitem;


public class Product {
    int imgView;
    String name, infor, add, delete;
    int amount;
    int productID;


    public Product(int productID, String name,String infor, int amount, int imgView, String add, String delete) {
        this.name = name;
        this.infor = infor;
        this.amount = amount;
        this.productID = productID;
        this.imgView = imgView;
        this.add = add;
        this.delete = delete;
    }
}
