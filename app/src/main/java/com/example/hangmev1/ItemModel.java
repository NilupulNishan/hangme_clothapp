package com.example.hangmev1;
//this class for get the item data from web
//No xml view
public class ItemModel {

    String name, price, img;

    ItemModel(){

    }
    public ItemModel(String name, String price, String img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }
}
