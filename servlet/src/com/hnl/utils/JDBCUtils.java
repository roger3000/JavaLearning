package com.hnl.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 *  JDBC工具类, 使用druid连接池
 */
public class JDBCUtils {

    private static DataSource db;

//    加载配置文件, 初始化连接池
    static{
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(resourceAsStream);
           db = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static DataSource getDataSource(){
        return db;
    }

    public static  Connection getConnection() throws SQLException {
        return db.getConnection();
    }
}
