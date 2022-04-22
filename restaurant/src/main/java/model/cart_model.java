package model;

public class cart_model {
    private int id;
    private int cust_id;
    private int product_id;
    private int product_amount;

    //Constructor
    public  cart_model(){}
    public cart_model(int id, int cust_id, int product_id, int product_amount) {
        this.id = id;
        this.cust_id = cust_id;
        this.product_id = product_id;
        this.product_amount = product_amount;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCust_id() {
        return cust_id;
    }

    public void setCust_id(int cust_id) {
        this.cust_id = cust_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(int product_amount) {
        this.product_amount = product_amount;
    }

    @Override
    public String toString() {
        return "cart_model{" +
                "id=" + id +
                ", cust_id=" + cust_id +
                ", product_id=" + product_id +
                ", product_amount=" + product_amount +
                '}';
    }
}
