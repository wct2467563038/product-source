package com.briup.product_source.util;

public enum ResultCode {
    SUCCESS(200,"操作成功"),
    ERROR(0,"操作失败"),

    ADD_SUCCESS(2000,"新增成功"),
    UPDATE_SUCCESS(2001,"修改成功"),

    DELECT_SUCCESS(2002,"删除成功"),

    USER_ID_ERROR(4000,"用户ID不合法"),
    USER_NAME_REPET(4001,"用户名已被占用"),
    USER_PASSWORD_NULL(4002,"密码不能为空"),
    USER_PASSWORD_LENGTH(4003,"密码长度不能小于6位"),
    NAME_NOT_EMPTY(4005,"名字不能为空"),
    DESC_NOT_EMPTY(4006,"描述信息不能为空"),
    DATA_NOT_EXIST(4007,"数据不存在"),
    USER_NOT_LOGIN(4008,"用户未登录，请重新登录"),
    TOKEN_ERROR(4009,"token无效，请重新登录"),
    USER_NAME_EMPTY(500,"用户名不存在"),
    USER_PASSWD_ERROR(500,"密码错误"),
    USER_STATUS_ERROR(500,"账号已被禁用"),

    SERVER_INTER_ERROR(5000,"程序内部错误");

    private Integer code;
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
