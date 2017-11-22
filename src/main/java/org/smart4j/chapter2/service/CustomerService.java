package org.smart4j.chapter2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Houfy on 2017/11/21.
 *
 *  提供客户数据服务
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    private static final String DB_DRIVER;
    private static final String DB_URL;
    private static final String DB_USERNAME;
    private static final String DB_PASSWORD;

    static {
        Properties conf = PropsUtil.loadProps("config.properties");
        DB_DRIVER = PropsUtil.getString(conf,"jdbc.driver");
        DB_URL = PropsUtil.getString(conf,"jdbc.url");
        DB_USERNAME =PropsUtil.getString(conf,"jdbc.username");
        DB_PASSWORD = PropsUtil.getString(conf,"jdbc.password");

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver",e);
        }
    }



    /**
     * 获取客户列表
     */
    public List<Customer> getCustomerList(){
        Connection conn = null;

        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM customer";
            conn = DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setName(rs.getString("name"));
                customer.setContact(rs.getString("contact"));
                customer.setTelephone(rs.getString("telephone"));
                customer.setEmail(rs.getString("email"));
                customer.setRemark(rs.getString("remark"));
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            LOGGER.error("execute sql failure",e);
        }finally {
            if(conn != null){
                try {
                    conn.close();
                }catch (SQLException e){
                    LOGGER.error("close connection failure",e);
                }
            }
        }
        return null;
    }

    /**
     *  获取客户
     */
    public Customer getCustomer(long id){
//        TODO
        return null;
    }

    /**
     *  创建客户
     */
    public boolean createCustomer(Map<String,Object> fieldMap){
//        TODO
        return false;
    }

    /**
     *  更新客户
     */
    public boolean updateCustomer(long id,Map<String,Object> fieldMap){
//        TODO
        return false;
    }

    /**
     *  删除客户
     */
    public boolean deleteCustomer(long id){
//        TODO
        return false;
    }

}
