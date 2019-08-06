package com.invoker.restful.dao;

import com.invoker.restful.bean.MerchantIpQueryVobj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by invoker on 2019-08-06
 * Description:
 */
public class DemoDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 数据查询方法
     */
    public MerchantIpQueryVobj getBean(String id) {
        String sql = "select t.merchant_id, t.merchant_ip_list, t.test_num from esales_merchant_ip_list t where t.merchant_id = ?";
        final MerchantIpQueryVobj merchantIpQueryVobj = new MerchantIpQueryVobj();
        this.jdbcTemplate.query(sql, new Object[]{id}, new RowCallbackHandler() {

            public void processRow(ResultSet rs) throws SQLException {
                merchantIpQueryVobj.setMerchantId(rs.getString("merchant_id"));
                merchantIpQueryVobj.setMerchantIpList(rs.getString("merchant_ip_list"));
                merchantIpQueryVobj.setMoney(rs.getFloat("test_num"));
            }
        });
        System.out.println(merchantIpQueryVobj.toString());
        return merchantIpQueryVobj;
    }

    /**
     * 数据插入
     */
    public int insertData(final MerchantIpQueryVobj merchantIpQueryVobj) {
        String sql = "insert into esales_merchant_ip_list(merchant_id, merchant_ip_list, test_num) values(?,?,?)";
        int count = this.jdbcTemplate.update(sql, new PreparedStatementSetter() {

            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, merchantIpQueryVobj.getMerchantId());
                ps.setString(2, merchantIpQueryVobj.getMerchantIpList());
                ps.setFloat(3, merchantIpQueryVobj.getMoney());
            }
        });
        return count;
    }
}
