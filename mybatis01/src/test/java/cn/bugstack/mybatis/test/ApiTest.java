package cn.bugstack.mybatis.test;

import cn.bugstack.mybatis.binding.MapperProxyFactory;
import cn.bugstack.mybatis.test.dao.IUserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {
    @Test
    public void test_MapperProxyFactory(){
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();
        sqlSession.put("cn.bugstack.mybatis.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句，查询用户名");
        sqlSession.put("cn.bugstack.mybatis.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句，查询用户年龄");

        IUserDao userDao = factory.newInstance(sqlSession);
        System.out.println(userDao.queryUserName("111"));

    }
}
