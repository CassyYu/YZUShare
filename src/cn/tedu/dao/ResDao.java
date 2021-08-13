package cn.tedu.dao;

import cn.tedu.entity.Person;
import cn.tedu.entity.Resource;
import cn.tedu.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ResDao {

    public ArrayList<Resource> selectAll() {
        ArrayList<Resource> list = new ArrayList<Resource>();
        Resource res1 = null;
        Connection conn = DBUtils.getConn();
        String sql = "select * from resource";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res1 = new Resource(
                        rs.getInt("id"),
                        rs.getString("rname"),
                        rs.getString("uname"),
                        rs.getDate("date"),
                        rs.getString("des"),
                        rs.getString("address")
                );
                list.add(res1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

    public ArrayList<Resource> selectBySearch(String search) {
        ArrayList<Resource> list = new ArrayList<Resource>();
        Resource res1 = null;
        String search1 = '%' + search + '%';
        Connection conn = DBUtils.getConn();
        String sql = "select * from resource where rname like ? or des like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, search1);
            ps.setString(2, search1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res1 = new Resource(
                        rs.getInt("id"),
                        rs.getString("rname"),
                        rs.getString("uname"),
                        rs.getDate("date"),
                        rs.getString("des"),
                        rs.getString("address")
                );
                list.add(res1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }

    public ArrayList<Resource> selectBySearchAndUname(String search, String uname) {
        ArrayList<Resource> list = new ArrayList<Resource>();
        Resource res1 = null;
        String search1 = '%' + search + '%';
        Connection conn = DBUtils.getConn();
        String sql = "select * from resource where uname=? and rname like ? or uname=? and des like ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, uname);
            ps.setString(2, search1);
            ps.setString(3, uname);
            ps.setString(4, search1);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res1 = new Resource(
                        rs.getInt("id"),
                        rs.getString("rname"),
                        rs.getString("uname"),
                        rs.getDate("date"),
                        rs.getString("des"),
                        rs.getString("address")
                );
                list.add(res1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (Exception e) {
            }
        }
        return list;
    }


    public ArrayList<Resource> selectByUname(Person person) {
        ArrayList<Resource> list = new ArrayList<Resource>();
        Resource res1 = null;
        Connection conn = DBUtils.getConn();
        String sql = "select * from resource where uname=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, person.getUname());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                res1 = new Resource(
                        rs.getInt("id"),
                        rs.getString("rname"),
                        rs.getString("uname"),
                        rs.getDate("date"),
                        rs.getString("des"),
                        rs.getString("address")
                );
                list.add(res1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DBUtils.close(conn);
            } catch (Exception e) {
            }
        }
        return list;

    }

    public void upload(Resource res) {
        Connection conn = DBUtils.getConn();
        String sql1 = "select * from resource";
        java.util.Date utilDate = new java.util.Date();
        long datems = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(datems);

        int id = 0;
        try {
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
            }
            ++id;
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sql = "insert into resource values(?,?,?,?,?,?)";//第一个为id是自增序列考虑删掉那个问号（也没法获取id值）
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, res.getRname());
            ps.setString(3, res.getUname());
            ps.setDate(4, sqlDate);
            ps.setString(5, res.getDes());
            ps.setString(6, res.getAddress());
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

    public void deleteByAddr(String addr) {
        Connection conn = DBUtils.getConn();
        String sql = "delete from resource where address=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, addr);
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
}
