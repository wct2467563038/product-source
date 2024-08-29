package com.briup.product_source.dao.basic;

import com.briup.product_source.bean.basic.IRecord;

public interface IRecordMapper {
    int deleteByPrimaryKey(Integer isrId);

    int insert(IRecord record);

    int insertSelective(IRecord record);

    IRecord selectByPrimaryKey(Integer isrId);

    int updateByPrimaryKeySelective(IRecord record);

    int updateByPrimaryKey(IRecord record);
}