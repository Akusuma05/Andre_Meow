package com.example.meow.Model;

public class RecyclerView_Items {
    private int image;
    private String name;
    private String categories;
    private String amount;
    private String price;

    public RecyclerView_Items(int image, String name, String categories, String amount, String price) {
        this.image = image;
        this.name = name;
        this.categories = categories;
        this.amount = amount;
        this.price = price;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
