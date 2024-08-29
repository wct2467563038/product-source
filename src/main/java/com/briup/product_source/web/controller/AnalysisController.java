package com.briup.product_source.web.controller;


import com.briup.product_source.service.impl.AnalysisServiceImpl;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@Api(tags = "首页大屏")
@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    @Resource
    private AnalysisServiceImpl analysisService;

    @ApiOperation("统计栏舍，栏圈，动物数量，冷库数量，员工数量信息接口")
    @GetMapping("/count")
    public Result<Map<String, List<Object>>> findAllById(){
        Map<String, List<Object>> Info = analysisService.countNum();
        return ResultUtil.success(Info);
    }
    @ApiOperation("统计动物体重信息接口")
    @GetMapping("/indexCount")
    public Result<Map<String,Integer>> findWeight(){
        Map<String, Integer> map = analysisService.countWeight();
        return ResultUtil.success(map);
    }
    @ApiOperation("统计动物病症数量接口")
    @GetMapping("/countDisease")
    public Result<Map<String,Integer>> findDisease(){
        Map<String, Integer> map = analysisService.countDisease2();
        return ResultUtil.success(map);
    }
    @ApiOperation("统计本年度12个月销售动物接口")
    @GetMapping("/countSales")
    public Result<Map<String, List<Object>>> findSales(){
        Map<String, List<Object>> map = analysisService.countSales();
        return ResultUtil.success(map);
    }




}
