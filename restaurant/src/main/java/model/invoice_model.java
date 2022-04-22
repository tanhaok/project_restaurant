package model;

import java.util.Date;

public class invoice_model {
    private int id;
    private int cust_id;
    private int emp_id;
    private int cart_id;
    private int total_cost;
    private Date create_date;

    //Constructor
    public invoice_model(){}
    public invoice_model(int id, int cust_id, int emp_id, int cart_id, int total_cost, Date create_date) {
        this.id = id;
        this.cust_id = cust_id;
        this.emp_id = emp_id;
        this.cart_id = cart_id;
        this.total_cost = total_cost;
        this.create_date = create_date;
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

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    @Override
    public String toString() {
        return "invoice_model{" +
                "id=" + id +
                ", cust_id=" + cust_id +
                ", emp_id=" + emp_id +
                ", cart_id=" + cart_id +
                ", total_cost=" + total_cost +
                ", create_date=" + create_date +
                '}';
    }
}
