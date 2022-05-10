package dao;

import connection.DdUtil;
import model.booking_table_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookingTableDao {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public boolean insert(booking_table_model booking){
        Boolean result = false;
        try {
            String sql ="insert into booking_table (cust_id,table_id,arrival_date,arrival_time,booking_status) \n" +
                    "values(?,?,?,?,'reserving')";
            connection = DdUtil.getConnection();
            ps = connection.prepareStatement(sql);
            result = ps.executeUpdate() > 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
