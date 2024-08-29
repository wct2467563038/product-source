package com.briup.product_source.config;


import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import java.util.HashMap;
import java.util.Map;


public class resultMap<K,V> implements ResultHandler<Map<K,V>> {
    private final Map<K,V> mappedResults = new HashMap<>();
    @Override
    public void handleResult(ResultContext context) {
        Map map = (Map) context.getResultObject();
        mappedResults.put((K)map.get("key"), (V)map.get("value"));
    }
    public Map<K,V> getMappedResults() {
        return mappedResults;
    }

}