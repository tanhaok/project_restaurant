package dao;

import connection.DdUtil;
import model.dining_table_model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TableDao {
    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public dining_table_model getTable(int id){
        dining_table_model table = null;
        try{
            String sql = "select * from dining_table where id = ?";
            connection = DdUtil.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                table = new dining_table_model(rs.getInt(1),rs.getString(2));
                return  table;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return table;
    }
    public List<dining_table_model> getListTable(String sql){
        List<dining_table_model> list = new ArrayList<>();
        try{
            connection = DdUtil.getConnection();
            rs = ps.executeQuery(sql);
            while (rs.next()){
                dining_table_model table_model = new dining_table_model(rs.getInt(1),rs.getString(2));
                list.add(table_model);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return  list;
    }
}
