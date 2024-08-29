package com.briup.product_source.web.controller;


import com.briup.product_source.bean.basic.Animal;
import com.briup.product_source.service.impl.AnalysisServiceImpl;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultCode;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "动物管理")
@RestController
@RequestMapping("/animal")
public class AnimalServerController {
    @Resource
    private AnalysisServiceImpl analysisService;

    @ApiOperation("新增或修改动物接口")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdateAnimal(@RequestBody Animal animal){
        return ResultUtil.success();
    }

    @ApiOperation("批量删除动物接口")
    @DeleteMapping("/deleteByIdAll")
    public Result deleteByIds(@RequestBody List<String> ids){
        return ResultUtil.success();
    }

    @ApiOperation("根据ID删除动物接口")
    @ApiImplicitParam(name = "aId",value = "动物编号",required = true)
    @DeleteMapping("/deleteById/{aAnimalId}")
    public Result deleteById(@PathVariable("aId") String id) {
        return ResultUtil.success();
    }




}
