package com.hcmute.dao;

import com.hcmute.model.ProductModel;
import com.hcmute.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private Connection connection;
    private PreparedStatement ps;
    private static final String GET_ALL_PRODUCT_SQL = "SELECT * FROM `restaurant_db`.`product`;";
    private static final String GET_PRODUCT_BY_ID_SQL = "select * from `restaurant_db`.`product`where product.id = ?";
    private static final String GET_8_NEWEST_PRODUCTS = "select * from `restaurant_db`.`product` order by product.id desc limit 8";

    public ProductDao(){

    }

    public List<ProductModel>  getAllProduct() {
        List<ProductModel> result = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            ps = connection.prepareStatement(GET_ALL_PRODUCT_SQL);
            ResultSet rs = ps.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("Description");
                String img = rs.getString("img");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                int cate_id = rs.getInt("cate_id");

                result.add(new ProductModel(id, name, des, img, price, amount, cate_id));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public ProductModel getProductById(int _id){
        ProductModel product = new ProductModel();
        try{
            connection = DbUtil.getConnection();
            ps = connection.prepareStatement(GET_PRODUCT_BY_ID_SQL);
            ps.setInt(1, _id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("Description"));
                product.setImg(rs.getString("img"));
                product.setPrice( rs.getInt("price"));
                product.setAmount(rs.getInt("amount"));
                product.setCate_id(rs.getInt("cate_id"));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return product;
    }

    public List<ProductModel>  get8NewestProducts() {
        List<ProductModel> result = new ArrayList<>();
        try {
            connection = DbUtil.getConnection();
            ps = connection.prepareStatement(GET_8_NEWEST_PRODUCTS);
            ResultSet rs = ps.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("Description");
                String img = rs.getString("img");
                int price = rs.getInt("price");
                int amount = rs.getInt("amount");
                int cate_id = rs.getInt("cate_id");

                result.add(new ProductModel(id, name, des, img, price, amount, cate_id));
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;

    }

}
