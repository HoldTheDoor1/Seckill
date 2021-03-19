package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {
    @Resource
    private SuccessKilledDao successKilledDao;
    @Test
    public void insertSuccessKilled() {
        long id = 1001L;
        long phone = 13555987654L;
        int i = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + i);
    }

    //这块还不是很清楚
    @Test
    public void queryByIdWithSeckill() {
        long id = 1001L;
        long userPhone = 13555987651L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }
}
