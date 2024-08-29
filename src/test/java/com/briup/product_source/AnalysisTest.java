package com.briup.product_source;

import com.briup.product_source.dao.ext.AnalysisMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SpringBootTest
public class AnalysisTest {
    @Autowired
    private AnalysisMapper mapper;
    @Test
    public void method(){
        List<Integer> integers = mapper.countByList();
        System.out.println(integers);
    }
    @Test
    public void method2(){
        Map<String, Map<String,Object>> map = mapper.countByMap();
        System.out.println(map);
    }
    @Test
    public void method3(){
        List<Map<String, Object>> map = mapper.countByMapAndList();
        System.out.println(map);
    }
    @Test
    public void method4(){
        Map<String, BigDecimal> map = mapper.countWeightMap();
        System.out.println(map.get("30以下").getClass());
    }
    @Test
    public void method5(){
        List<Map<String, Object>> map = mapper.countDiseasetMap();
        System.out.println(map);

    }
    @Test
    public void method6(){
        List<Map<String, Object>> list = mapper.countSales();
        System.out.println(list);
        Object o = list.get(0).get("month");
        Object o2 = list.get(0).get("num");
        System.out.println(o.getClass());
        System.out.println(o2.getClass());

    }
}
