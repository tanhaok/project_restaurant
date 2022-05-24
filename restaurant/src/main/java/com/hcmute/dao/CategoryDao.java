package com.hcmute.dao;

import com.hcmute.model.CartModel;
import com.hcmute.model.ProductCategoryModel;
import com.hcmute.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CategoryDao {
    public static final String SELECT_CATEGORY = "SELECT * FROM product_category";
    public static final String INSERT_CATEGORY = "INSERT INTO product_category (name) VALUES (?)";
    public static final String UPDATE_CATEGORY = "UPDATE product_category SET name = ? WHERE id = ?";
    public static final String DELETE_CATEGORY = "DELETE FROM product_category WHERE id = ?";

    public void insertCategory(ProductCategoryModel category) {
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
        ) {
            preparedStatement.setInt(1, category.getId());
            preparedStatement.setString(2, category.getName());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean updateCategory(ProductCategoryModel category) {
        boolean rowUpdated;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY);) {
            statement.setString(1, category.getName());
            statement.setInt(2, category.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowUpdated;
    }
/*    public boolean deleteCa(int id) {
        boolean rowDeleted;
        try (Connection connection = DbUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CART);) {
            statement.setInt(1, cart_id);
            statement.setInt(2, product_id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }*/
}
