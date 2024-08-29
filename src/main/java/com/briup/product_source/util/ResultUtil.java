package com.briup.product_source.util;

public class ResultUtil {
    private ResultUtil(){
    }
    public static Result success(){
        return success(ResultCode.SUCCESS);
    }
    public static Result success(ResultCode rc){
        return success(rc,null);
    }
    public static Result success( ResultCode rc,Object data){
        return new Result(rc,data);
    }
    public static Result success(Object data){
        return success(ResultCode.SUCCESS,data);
    }
    public static Result error(){
        return error(ResultCode.ERROR);
    }
    public static Result error(ResultCode rc){
        return new Result(rc,null);
    }
}
