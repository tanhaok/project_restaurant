package com.hcmute.model;

import java.sql.Date;
import java.sql.Time;

public class booking_table_model {
    private int id;
    private int cust_id;
    private int table_id;
    private Date date;
    private Time arrival_time;
    private String status;

    public booking_table_model(int cust_id, int table_id, Date date, Time arrival_time, String status) {
        this.cust_id = cust_id;
        this.table_id = table_id;
        this.date = date;
        this.arrival_time = arrival_time;
        this.status = status;
    }

    public booking_table_model(int id, int cust_id, int table_id, Date date, Time arrival_time, String status) {
        this.id = id;
        this.cust_id = cust_id;
        this.table_id = table_id;
        this.date = date;
        this.arrival_time = arrival_time;
        this.status = status;
    }

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

    public int getTable_id() {
        return table_id;
    }

    public void setTable_id(int table_id) {
        this.table_id = table_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getArrival_time() {
        return arrival_time;
    }

    public void setArrival_time(Time arrival_time) {
        this.arrival_time = arrival_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "booking_table_model [id=" + id + ", cust_id=" + cust_id + ", table_id=" + table_id + ", date=" + date
				+ ", arrival_time=" + arrival_time + ", status=" + status + "]";
	}
    

    
}
