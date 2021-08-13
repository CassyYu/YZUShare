package cn.tedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {
    public static Connection getConn() {
        Connection conn = null;
        try {
            //加载驱动
            Class.forName("org.sqlite.JDBC");
            //获取链接
            conn = DriverManager.getConnection("jdbc:sqlite:/Users/cassy/IdeaProjects/Rshare/src/share.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn) throws Exception {
        if (conn != null) {
            conn.close();
        }
    }
}