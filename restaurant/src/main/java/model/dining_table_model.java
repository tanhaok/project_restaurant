package model;

public class dining_table_model {
    private int id;
    private String status;

    public dining_table_model(int id, String status) {
        this.id = id;
        this.status = status;
    }

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

    @Override
    public String toString() {
        return "dining_table{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
