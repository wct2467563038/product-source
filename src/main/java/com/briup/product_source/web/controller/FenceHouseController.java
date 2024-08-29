package com.briup.product_source.web.controller;


import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.ext.FenceHouseExt;
import com.briup.product_source.service.impl.FenceHouseServiceImpl;
import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "栏舍管理")
@RestController
@RequestMapping("/fenceHouse")
public class FenceHouseController {
    @Resource
    private FenceHouseServiceImpl service;

    @ApiOperation("分页多条件查询栏舍信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum",value = "当前页码",required = true),
            @ApiImplicitParam(name = "pageSize",value = "每页大小",required = true),
            @ApiImplicitParam(name = "fhName",value = "栏舍名字，支持模糊查询",required = false)

    })
    @GetMapping("/query")
    public Result<PageInfo<FenceHouse>> findPageInfo(@RequestParam(required = true) Integer pageNum,
                                                     @RequestParam(required = true) Integer pageSize,
                                                     @RequestParam(value = "fhName",required = false) String name){

        PageInfo<FenceHouse> page = service.findByPage(pageNum, pageSize, name);
        return ResultUtil.success(page);
    }

    @ApiOperation("根据栏舍编号查询栏舍信息以及栏圈信息接口")
    @ApiImplicitParam(name = "fhId",value = "栏舍编号")
    @GetMapping("/selectById")
    public Result<FenceHouseExt> findById(@RequestParam(required = true) String fhId){
        FenceHouseExt fh = service.findById(fhId);
        return ResultUtil.success(fh);
    }

    @ApiOperation("新增或修改栏舍接口")
    @PostMapping("/saveOrUpdate")
    public Result saveOrUpdate(@RequestBody FenceHouse fh){
        service.saveOrUpdate(fh);
        return ResultUtil.success();
    }

    @ApiOperation("批量删除栏舍接口")
    @DeleteMapping("/deleteByIdAll")
    public Result deleteByIds(@RequestBody List<String> ids){
        service.deleteByBatch(ids);
        return ResultUtil.success();
    }

    @ApiOperation("根据id删除栏舍信息接口")
    @ApiImplicitParam(name = "hId",value = "栏舍编号",required = true)
    @DeleteMapping("/deleteById/{hId}")
    public Result deleteById(@PathVariable("hId") String id){
        service.deleteById(id);
        return ResultUtil.success();
    }


}
