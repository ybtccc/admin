package com.demo.admin.util;

/**
 * Result
 *
 * @author ybtccc ,2019/3/20
 */
public class Result<T> {

    private String code = "00";
    private String message = "操作完成";
    private T data;

    public static Result success(){
        Result<Object> r = new Result<>();
        return r;
    }

    public static Result success(Object o){
        Result<Object> r = new Result<>();
        r.setData(o);
        return r;
    }

    public static Result error(String code,String msg){
        Result<Object> r = new Result<>();
        r.setCode(code);
        r.setMessage(msg);
        return r;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
