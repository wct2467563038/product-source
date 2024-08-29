package com.briup.product_source.dao.ext;
import com.briup.product_source.bean.basic.*;
import com.briup.product_source.config.resultMap;
import org.apache.ibatis.annotations.MapKey;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


public interface AnalysisMapper {

    List<Integer> countByList();

    @MapKey("name")
    Map<String,Map<String,Object>> countByMap();

    List<Map<String,Object>> countByMapAndList();


    Map<String, BigDecimal> countWeightMap();

    List<Map<String,BigDecimal>> countWeightList();

    List<Map<String ,Object>> countDiseasetMap();


    void countDiseasetMap2(resultMap resultMap);

    List<Map<String,Object>> countSales();
}
