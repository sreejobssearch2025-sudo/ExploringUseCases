package com.ProductsFilterSort.Model;

public class Product {
//create fields barCode, item, category, price,discount,available


    private String barCode;
    private String item;
    private String category;
    private double price;
    private int discount;
    private int available;

    public void setCategory(String category) {
        this.category = category;
    }
    
    public int getAvailable() {
        return available;
    }
    public void setAvailable(int available) {
        this.available = available;
    }
    public int getDiscount() {
        return discount;
    }
    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //Modify this constructor to include discount and available
    public Product(String barCode, String item, String category, double price, int discount, int available) {
        this.barCode = barCode;
        this.item = item;
        this.category = category;
        this.price = price;
        this.discount = discount;
        this.available = available;
    }

    //create getters and setters
    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getCategory() {
        return category;
    }
}
