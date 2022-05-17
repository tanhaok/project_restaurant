package com.hcmute.model;

public class CartModel {
    private int id;
    private int cusId;
    private int productId;
    private int productAmount;

    //Constructor
    public CartModel(){}
    public CartModel(int id, int cust_id, int product_id, int product_amount) {
        this.id = id;
        this.cusId = cust_id;
        this.productId = product_id;
        this.productAmount = product_amount;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    @Override
    public String toString() {
        return "cart_model{" +
                "id=" + id +
                ", cust_id=" + cusId +
                ", product_id=" + productId +
                ", product_amount=" + productAmount +
                '}';
    }
}
