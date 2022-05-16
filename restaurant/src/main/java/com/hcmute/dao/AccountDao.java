package com.hcmute.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hcmute.connection.DdUtil;
import com.hcmute.model.acc_model;

public class AccountDao {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        public acc_model getAccount(String username,String password){
            acc_model account = null;
            try {
                String sql = "select *from account where username = ? and password = ?";
                connection = DdUtil.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                rs = ps.executeQuery();
                while ((rs.next())){
                    account = new acc_model();
                    account.setUsername(rs.getString(1));
                    account.setPassword(rs.getString(2));
                    account.setUsertype(rs.getString(3));
                    account.setId(rs.getInt(4));
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return  account;
        }
        public Boolean insert(acc_model account){
            Boolean result = false;
            try {
                String sql = "insert into account (username,password,usertype) values(?,?,?)";
                connection = DdUtil.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1,account.getUsername());
                ps.setString(2,account.getPassword());
                ps.setString(3,account.getUsertype());
                result = (ps.executeUpdate() == 1);
            }catch (Exception e){
                e.printStackTrace();
            }
            return  result;
        }
        public void update(acc_model acc){
            try {
                String sql = "update account set username=?, password = ? \n" +
                        "where id=?";
                connection = DdUtil.getConnection();
                ps = connection.prepareStatement(sql);
                ps.setString(1,acc.getUsername());
                ps.setString(2,acc.getPassword());
                ps.setInt(3,acc.getId());
                ps.executeUpdate();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        acc_model model = new acc_model("test","123","user");
        AccountDao dao = new AccountDao();
        Boolean r = dao.insert(model);
        System.out.println(r.toString());
    }
}
