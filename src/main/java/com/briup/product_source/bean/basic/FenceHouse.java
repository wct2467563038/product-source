package com.briup.product_source.bean.basic;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "栏舍信息")
public class FenceHouse {
    @ApiModelProperty(notes = "栏舍编号",example ="12e4f043910a4b7a9ad933f90fec620c")
    private String fhId;
    @ApiModelProperty(notes = "栏舍名称",example ="隔离舍")
    private String fhName;
    @ApiModelProperty(notes = "栏舍描述信息",example ="隔离病猪")
    private String fhDesc;
    @ApiModelProperty(notes = "创建时间",example = "2024-04-13 00:00:00")
    private Date fhTime;

    public String getFhId() {
        return fhId;
    }

    public void setFhId(String fhId) {
        this.fhId = fhId;
    }

    public String getFhName() {
        return fhName;
    }

    public void setFhName(String fhName) {
        this.fhName = fhName;
    }

    public String getFhDesc() {
        return fhDesc;
    }

    public void setFhDesc(String fhDesc) {
        this.fhDesc = fhDesc;
    }

    public Date getFhTime() {
        return fhTime;
    }

    public void setFhTime(Date fhTime) {
        this.fhTime = fhTime;
    }
}