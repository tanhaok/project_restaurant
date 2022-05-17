package com.hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.hcmute.utils.DdUtil;
import com.hcmute.model.BookingTableModel;

public class BookingTableDao {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public boolean insert(BookingTableModel booking){
        Boolean result = false;
        try {
            String sql ="insert into booking_table (cust_id,table_id,arrival_date,arrival_time,booking_status) \n" +
                    "values(?,?,?,?,'reserving')";
            connection = DdUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,booking.getCusId());
            ps.setInt(2,booking.getTableId());
            ps.setDate(3,booking.getDate());
            ps.setTime(4,booking.getArrivalTime());
            result = ps.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
