package com.briup.product_source.expception;


import com.briup.product_source.util.Result;
import com.briup.product_source.util.ResultCode;
import com.briup.product_source.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception ex){
        log.error("进行全局异常处理");
        ex.printStackTrace();
        if (ex instanceof CustomException) {
            return ResultUtil.error(((CustomException) ex).getCode());
        }
        return ResultUtil.error(ResultCode.SERVER_INTER_ERROR);
    }
}
