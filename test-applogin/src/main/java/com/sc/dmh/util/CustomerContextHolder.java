package com.sc.dmh.util;

import com.alibaba.druid.util.StringUtils;
/**
 * 多数据源手动选择工具
 * @author lenovo
 *
 */

public class CustomerContextHolder {
    /**
     * 路局现车数据库
     */
	public static final String DATA_SOURCE_SYXC = "dataSource";
    /**
     * mssql数据库
     */
	public static final String DATA_SOURCE_MSSQL = "mssqlDataSource";
    /**
     * 沈阳车务段数据库
     */
	public static final String DATA_SOURCE_SYCWD = "sycwdDataSource";
    //用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();
    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
        String dataSource = contextHolder.get();
        if (StringUtils.isEmpty(dataSource)) {
            return DATA_SOURCE_SYXC;
        }else {
            return dataSource;
        }
    }
    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
