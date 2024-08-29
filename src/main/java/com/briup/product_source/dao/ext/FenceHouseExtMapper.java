package com.briup.product_source.dao.ext;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.dao.basic.FenceHouseMapper;

import java.util.List;

public interface FenceHouseExtMapper extends FenceHouseMapper {
    void deleteByIds(List<String> ids);


    List<FenceHouse> selectByName(String fhName);

    FenceHouseExt selectWithHurdlesById(String id);
}
