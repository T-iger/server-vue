package com.my.common.result;

/**
 * @Description: code枚举
 * @Author: lh
 * @Date 2020/9/5
 * @Version: 1.0
 **/
public enum Code {
    /**成功*/
    SUCCESS(100),
    /**失败*/
    FAIL(999);

    public Integer code;

    Code(Integer code) {
        this.code = code;
    }
}
