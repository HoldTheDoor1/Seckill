package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合，junit启动时加载spingIOC容器
 * spring-test,junit
 *
 * **/
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入Dao实现类依赖
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void queryById() {
        long id = 1000;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void queryAll() {
        //java没有保存形参的记录 queryAll(int offset,int limit) -> queryAll(arg0,arg1)
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill sk:seckills) {
            System.out.println(sk.toString());
        }
        System.out.println(seckills.toString());
    }

    @Test
    public void reduceNumber() {
        Date killTime = new Date();
        int i = seckillDao.reduceNumber(1000L, killTime);
        System.out.println("updateCount  " + i);
    }
}
