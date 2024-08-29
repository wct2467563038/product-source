package com.briup.product_source.util;

import com.briup.product_source.expception.CustomException;

public abstract class BriupAssert {
    public static void hasTest(String text,ResultCode rc){
        if (text == null || "".equals(text.trim())){
            throw new CustomException(rc);
        }
    }
    public static void notNull(Object obj,ResultCode rc){
        if(obj == null){
            throw new CustomException(rc);
        }
    }
    /**
     *
     * @param expression
     * @param rc
     */
    public static void isTrue(boolean expression,ResultCode rc){
        if(!expression){
            throw new CustomException(rc);
        }
    }
}
