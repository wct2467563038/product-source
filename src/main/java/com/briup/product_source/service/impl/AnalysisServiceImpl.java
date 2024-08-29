package com.briup.product_source.service.impl;

import com.briup.product_source.config.resultMap;
import com.briup.product_source.dao.ext.AnalysisMapper;
import com.briup.product_source.service.AnalysisService;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    @Autowired
    private AnalysisMapper analysisMapper;
    public Map<String, List<Object>> countNum(){
        Map<String, Map<String, Object>> map = analysisMapper.countByMap();
        Map result = new HashMap<>();
        Set<String> names = map.keySet();
        List<Object> values = map.values()
                .stream()
                .map(m -> m.get("num"))
                .collect(Collectors.toList());
        result.put("name",names);
        result.put("value",values);
        return result;
    }

    public Map<String, List<Object>> countNum2(){
        List<Integer> values = analysisMapper.countByList();
        Map map = new HashMap<>();
        map.put("name",Arrays.asList("栏舍","栏圈","动物","冷库","员工"));
        map.put("value",values);
        return map;
    }

    @Override
    public Map<String, Integer> countWeight() {
        Map map = analysisMapper.countWeightMap();
        return map;
    }

    @Override
    public Map<String, Integer> countDisease() {
        List<Map<String, Object>> list = analysisMapper.countDiseasetMap();
        System.out.println(list);
        Map result= new HashMap<>();
        for (Map<String, Object> stringObjectMap : list) {
            Set<String> strings = stringObjectMap.keySet();
            String[] keys = new String[strings.size()];
            int i = 0;
            for (String string : strings) {
                System.out.println(string);
                keys[i] = string;
                i++;
            }
            result.put(stringObjectMap.get(keys[1]),stringObjectMap.get(keys[0]));
        }
        return result;
    }

    public Map<String, Integer> countDisease2() {
        resultMap<String,Integer> resultMap = new resultMap();
        analysisMapper.countDiseasetMap2(resultMap);
        Map<String, Integer> mappedResults = resultMap.getMappedResults();
        return mappedResults;
    }

    @Override
    public Map<String, List<Object>> countSales() {
        List<Map<String, Object>> list = analysisMapper.countSales();
        List<String> names = Arrays.asList("1月", "2月", "3月", "4月", "5月", "6月",
                                           "7月", "8月","9月", "10月", "11月", "12月");
        List values = new ArrayList(Collections.nCopies(12,0));
        list.forEach(data-> {
            int month = (Integer) data.get("month");
            int num = ((BigDecimal)data.get("num")).intValue();
            values.set(month-1,num);
        });
//        Map result = new HashMap();
//        result.put("name",names);
//        result.put("value",values);
        Map result = ImmutableMap.of("name", names, "value", values);
        return result;
    }
}
