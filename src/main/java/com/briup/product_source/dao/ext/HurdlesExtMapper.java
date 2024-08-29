package com.briup.product_source.dao.ext;

import com.briup.product_source.dao.basic.HurdlesMapper;

public interface HurdlesExtMapper extends HurdlesMapper {
    void updateFenceId(String fenceId);
}
