package com.briup.product_source.expception;


import com.briup.product_source.util.ResultCode;

public class CustomException extends RuntimeException {
    private ResultCode code;

    public CustomException(ResultCode rc) {
        super(rc.getMessage());
        this.code = rc;
    }

    public ResultCode getCode() {
        return code;
    }
}
