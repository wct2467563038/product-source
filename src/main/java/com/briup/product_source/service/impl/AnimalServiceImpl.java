package com.briup.product_source.service.impl;

import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.bean.ext.AnimalExt;
import com.briup.product_source.bean.ext.ManagerAnimalExt;
import com.briup.product_source.service.AnimalService;
import com.briup.product_source.util.BriupAssert;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {


    @Override
    public void saveOrUpdate(Animal animal) {



    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public void deleteById(List<String> ids) {

    }

    @Override
    public PageInfo<AnimalExt> findByPage(Integer pageNum, int pageSize, String aHealthy, String aGender) {
        return null;
    }

    @Override
    public ManagerAnimalExt findById(String id) {
        return null;
    }

    @Override
    public String createQRcodeByAnimalId(String id) {
        return null;
    }
}
