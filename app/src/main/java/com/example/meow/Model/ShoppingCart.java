package com.example.meow.Model;

public class ShoppingCart {
    private int image;
    private String name;
    private String categories;
    private String price;
    private int amount;

    public ShoppingCart(int image, String name, String categories, String price, int amount) {
        this.image = image;
        this.name = name;
        this.categories = categories;
        this.price = price;
        this.amount = amount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
