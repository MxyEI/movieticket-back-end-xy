package com.awesometickets.config;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * 数据库统一标准
 */
public class MySQL5Dialect extends MySQL5InnoDBDialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}

