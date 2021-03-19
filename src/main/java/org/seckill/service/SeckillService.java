package org.seckill.service;

import org.apache.ibatis.annotations.Param;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import java.util.List;

/**
 * 业务接口：站在使用者角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型/）
 *
 * **/
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     **/
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     **/
    Seckill getById(long seckillId);

    /**
     * 秒杀开发是输出秒杀接口地址，否则输出系统时间和秒杀时间
     **/
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     **/
    SeckillExecution executeSeckill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone,@Param("md5") String md5)
    throws Exception;

    /**
     * 执行秒杀操作
     *
     * **/
    SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);

}
