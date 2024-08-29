package com.briup.product_source.bean.ext;

import com.briup.product_source.bean.basic.FenceHouse;
import com.briup.product_source.bean.basic.Hurdles;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FenceHouseExt  extends FenceHouse{
    @JsonProperty("mhs")
    private List<Hurdles> hurdlesList;
}
