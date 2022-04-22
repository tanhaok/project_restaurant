package model;

public class dining_table_model {
    private int id;
    private String status;
    private String cust_id;

    //Constructor
    public dining_table_model(){}
    public dining_table_model(int id, String status, String cust_id) {
        this.id = id;
        this.status = status;
        this.cust_id = cust_id;
    }

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    @Override
    public String toString() {
        return "dining_table_model{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", cust_id='" + cust_id + '\'' +
                '}';
    }
}
