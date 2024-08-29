package com.briup.product_source.service.impl;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.dao.basic.FenceHouseMapper;
import com.briup.product_source.dao.basic.HurdlesMapper;
import com.briup.product_source.dao.ext.FenceHouseExtMapper;
import com.briup.product_source.dao.ext.HurdlesExtMapper;
import com.briup.product_source.expception.CustomException;
import com.briup.product_source.service.FenceHouseService;
import com.briup.product_source.util.BriupAssert;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

import static com.briup.product_source.util.ResultCode.*;

@Service
public class FenceHouseServiceImpl implements FenceHouseService {
    @Autowired
    private FenceHouseExtMapper fhEXtMapper;
    @Autowired
    private HurdlesExtMapper huExtMapper;

    public PageInfo<FenceHouse> findByPage(int pageNum, int pageSize, String fhName) {
        return PageHelper.startPage(pageNum,pageSize,true)
                .doSelectPageInfo(()->fhEXtMapper.selectByName(fhName));
    }
    public FenceHouseExt findById(String id) {

        return fhEXtMapper.selectWithHurdlesById(id);
    }

    public void saveOrUpdate(FenceHouse fenceHouse) {
        /*if(!StringUtils.hasText(fhName)){
            throw new CustomException(NAME_NOT_EMPTY);
        }
        if(fhDesc == null || fhDesc.trim().equals("")){
            throw new CustomException(DESC_NOT_EMPTY);
        }*/
        BriupAssert.hasTest(fenceHouse.getFhName(),NAME_NOT_EMPTY);
        BriupAssert.hasTest(fenceHouse.getFhDesc(),DESC_NOT_EMPTY);

        if(fenceHouse.getFhId() == null){
            String id = UUID.randomUUID().toString().replace("-","");
            fenceHouse.setFhId(id);
            fhEXtMapper.insert(fenceHouse);
        }else{
            fhEXtMapper.updateByPrimaryKey(fenceHouse);
        }

    }
    public void deleteById(String id) {
        FenceHouse fh = fhEXtMapper.selectByPrimaryKey(id);
        BriupAssert.notNull(fh,DATA_NOT_EXIST);


        huExtMapper.updateFenceId(id);

        fhEXtMapper.deleteByPrimaryKey(id);
    }
    public void deleteByBatch(List<String> ids) {
        ids.forEach(id ->{
            fhEXtMapper.deleteByPrimaryKey(id);
        });
        fhEXtMapper.deleteByIds(ids);


    }
}
