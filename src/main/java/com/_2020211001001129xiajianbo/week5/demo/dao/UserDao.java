package com._2020211001001129xiajianbo.week5.demo.dao;
import com._2020211001001129xiajianbo.week5.demo.entity.userEntity;

import java.sql.*;

public class UserDao {
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public userEntity login(userEntity userEntity){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        userEntity result= null;
        try {
            conn= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=userdb;encrypt=false",
                    "sa",
                    "123");
            ps=conn.prepareStatement("select *\n" +
                    "from sys_user\n" +
                    "where name=? and pass=?");
            ps.setString(1,userEntity.getName());
            ps.setString(2,userEntity.getPass());

            rs = ps.executeQuery();

            if(rs.next()){
                result =new userEntity();
                result.setName(rs.getString("name"));
                result.setPass(rs.getString("pass"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try{
                    ps.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (conn!=null){
                try{
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
        }
        return result;
    }
}
