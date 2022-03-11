/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;
import model.*;

/**
 *
 * @author Michell
 */
public class UserDao {

    private Connection con;

    private String query;
    private String queryCountId;
    private PreparedStatement pst;
    private ResultSet rs;

    public UserDao(Connection con) {
        this.con = con;
    }

    public User userLogin(String email, String password) {
        User user = null;
        try {
            query = "select * from users where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return user;
    }
    
    public int userRegistrasi(User user){
        int result = 0;
        int countId = 0;
        queryCountId = "SELECT COUNT(id) FROM users";
        query = "insert into users (id, name, email, password) values (?,?,?,?)";
        try {
            pst = this.con.prepareStatement(queryCountId);
            rs = pst.executeQuery();
            if (rs.next()) {
                countId = rs.getInt(1);
                user.setId(countId+1);
                System.out.println(countId);
            }
            
            pst = con.prepareStatement(query);
            pst.setInt(1, user.getId());
            pst.setString(2, user.getName());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getPassword());
            result = pst.executeUpdate();
            
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return result;
    }
}
