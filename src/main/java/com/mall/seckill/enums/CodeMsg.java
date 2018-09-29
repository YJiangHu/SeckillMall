package com.mall.seckill.enums;

/**
 * 结果状态信息枚举类
 */
public enum CodeMsg {

    SUCCESS(0, "成功"), SERVER_ERROR(1, "服务端异常"), BIND_ERROR(3, "参数绑定异常"),
        MOBILE_EMPTY(1000, "手机号不能为空"), MOBILE_ERROR(1001, "手机号格式错误"),
        MOBILE_NOT_EXIST(1002, "手机号不存在"), PASSWORD_EMPTY(1003, "密码不能为空"),
        PASSWORD_ERROR(1004, "密码错误"), SESSION_ERROR(1005, "Session不存在或已失效");

    private int code; //状态码
    private String msg; //信息

    private CodeMsg( int code,String msg ) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }

}
