package com.my.common.result;

/**
 * @Description: 返回结果工厂
 * @Author: lh
 * @Date 2020/9/5
 * @Version: 1.0
 **/
public class ResultFactory {
    public static Result successResult(Object data) {
        return new Result(Code.SUCCESS.code, "成功", data);
    }

    public static Result successResult(String msg, Object data) {
        return new Result(Code.SUCCESS.code, msg, data);
    }

    public static Result failResult(String msg) {
        return new Result(Code.FAIL.code, msg, null);
    }

    public static Result setErrorMsg(Integer code,String msg){
        return new Result(code,msg,null);
    }


}
