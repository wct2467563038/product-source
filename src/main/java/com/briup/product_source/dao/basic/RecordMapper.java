package com.briup.product_source.dao.basic;

import com.briup.product_source.bean.basic.Record;

public interface RecordMapper {
    int deleteByPrimaryKey(Integer drId);

    int insert(Record record);

    int insertSelective(Record record);

    Record selectByPrimaryKey(Integer drId);

    int updateByPrimaryKeySelective(Record record);

    int updateByPrimaryKey(Record record);
}