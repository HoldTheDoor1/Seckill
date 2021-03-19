package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.concurrent.Executor;

@RunWith(SpringJUnit4ClassRunner.class)
//这是啥？
@ContextConfiguration({
        "classpath:spring/spring-dao.xml",
        "classpath:spring/spring-service.xml"
})
public class SeckillServiceTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService seckillService;
    @Test
    public void getSeckillList() {
        List<Seckill> seckillList = seckillService.getSeckillList();
        logger.info("list={}" + seckillList.toString());
    }

    @Test
    public void getById() {
        Seckill byId = seckillService.getById(1000);
        logger.info("seckill={}" + byId);
    }

    @Test
    public void exportSeckillUrl() {
        long id =1003;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
    }

    @Test
    public void executeSeckill() throws Exception {
        long id = 1000;
        long phone = 13492010242L;
        String md5 = "787d5b88f218641ed63408095ee75972";
        SeckillExecution seckillExecution = seckillService.executeSeckill(id, phone, md5);
        logger.info("result={}",seckillExecution);
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId =1000;
        long userPhone=13492010242L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if(exposer.isExposed()){
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService.executeSeckillProcedure(seckillId, userPhone, md5);
            logger.info(seckillExecution.getStateInfo());
        }
    }
}
