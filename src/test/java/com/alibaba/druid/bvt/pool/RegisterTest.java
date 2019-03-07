package com.alibaba.druid.bvt.pool;

import org.junit.Assert;

import com.alibaba.druid.pool.DruidDataSource;

import junit.framework.TestCase;


public class RegisterTest extends TestCase {
    public void test() throws Exception {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mock:xxx");
        dataSource.init();
        Assert.assertTrue(dataSource.isMbeanRegistered());

        DruidDataSource dataSource2 = new DruidDataSource();
        dataSource2.setUrl("jdbc:mock:xxx");
        dataSource2.init();
        Assert.assertTrue(dataSource2.isMbeanRegistered());


        dataSource.registerMbean();
        dataSource2.registerMbean();
        Assert.assertTrue(dataSource.isMbeanRegistered());
        Assert.assertTrue(dataSource2.isMbeanRegistered());

        dataSource.unregisterMbean();
        dataSource2.unregisterMbean();
        Assert.assertFalse(dataSource.isMbeanRegistered());
        Assert.assertFalse(dataSource2.isMbeanRegistered());
        dataSource.close();
        dataSource2.close();

    }
}
