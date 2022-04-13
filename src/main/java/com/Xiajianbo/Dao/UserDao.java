package com.Xiajianbo.Dao;

import com.Xiajianbo.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, user.getId());
        ps.setString(2, user.getUsername());
        ps.setString(3, user.getPassword());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getGender());
        ps.setDate(6, (java.sql.Date)user.getBirthDate());
        if (ps.executeUpdate()==1){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, user.getId());
        int a = st.executeUpdate();
        return a;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update set username=?, password=?, email=?, gender=?, birthDate=? where id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getGender());
        st.setDate(5, (java.sql.Date) user.getBirthDate());
        st.setInt(6, user.getId());
        int  a= st.executeUpdate();
        return a;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select * from userdb where username = ? and password = ?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));

        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "Select * from usertable where username = ? and password = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, username);
        st.setString(2, password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "Select * from usertable where username = ?";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        st.setString(1, username);
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "Select * from usertable where password = ?";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        st.setString(1, password);
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "Select * from usertable where email = ?";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        st.setString(1, email);
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "Select * from usertable where gender = ?";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        st.setString(1, gender);
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "Select * from usertable where birthDate = ?";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        st.setString(1, String.valueOf(birthDate));
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "Select * from usertable ";
        PreparedStatement st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<User> users = new ArrayList<User>();
        while (rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getDate("birthdate"));
            users.add(user);
        }
        return users;    }
}
