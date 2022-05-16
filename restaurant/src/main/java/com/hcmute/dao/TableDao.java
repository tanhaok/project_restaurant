package com.hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.hcmute.connection.DdUtil;
import com.hcmute.model.dining_table_model;

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
            ps = connection.prepareStatement(sql);
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
    public List<dining_table_model> getAll(){
    	String sql = "select * from dining_table";
    	List<dining_table_model> list = getListTable(sql);
    	return list;
    }
}
