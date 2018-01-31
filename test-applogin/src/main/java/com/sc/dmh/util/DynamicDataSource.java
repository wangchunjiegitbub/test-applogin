package com.sc.dmh.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
/**
 * 多数据源手动选择工具
 * @author lenovo
 *
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }
}
