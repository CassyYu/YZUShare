package cn.tedu.dao;

import cn.tedu.entity.Person;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonDao {
    public void insert(Person person) {
        Connection conn = DBUtils.getConn();
        String sql = "insert into person values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getUname());
            ps.setString(2, person.getUpwd());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getPhone());
            ps.setInt(5, person.getState());
            ps.setInt(6, person.getRole());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
            }
        }
    }

    public Person login(Person person) {
        Connection conn = DBUtils.getConn();
        Person user1 = null;//存储返回值对象
        String sql = "select * from person where uname=? and upwd=? and role=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getUname());
            ps.setString(2, person.getUpwd());
            ps.setInt(3, person.getRole());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user1 = new Person();
                user1.setUname(rs.getString("uname"));
                user1.setRole(rs.getInt("role"));
                user1.setPhone(rs.getString("phone"));
                user1.setEmail(rs.getString("email"));
                user1.setUpwd(rs.getString("upwd"));
                user1.setState(rs.getInt("state"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
            }
        }
        return user1;
    }

    public Person selectByUname(Person person) {
        Connection conn = DBUtils.getConn();
        Person person1 = null;
        String sql = "select * from person where uname=? and role=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getUname());
            ps.setInt(2, person.getRole());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                person1 = new Person(
                        rs.getString("uname"),
                        rs.getString("upwd"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("state"),
                        rs.getInt("role")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return person1;

    }

    public void update(Person person, String phone1) {
        Connection conn = DBUtils.getConn();
        String sql = "update person set uname=?,upwd=?,email=?,phone=? where phone=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getUname());
            ps.setString(2, person.getUpwd());
            ps.setString(3, person.getEmail());
            ps.setString(4, person.getPhone());
            ps.setString(5, phone1);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
            }
        }
    }

    public Person selectByPhone(Person person) {
        Connection conn = DBUtils.getConn();
        Person person1 = null;
        String sql = "select * from person where phone=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getPhone());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                person1 = new Person(
                        rs.getString("uname"),
                        rs.getString("upwd"),
                        rs.getString("email"),
                        rs.getString("phone"),
                        rs.getInt("state"),
                        rs.getInt("role")
                );

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return person1;

    }


}
