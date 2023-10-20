package com.wms.common;

import lombok.Data;

/**
 * @Author wen
 * @Data 2023/10/18 22:02
 */
@Data
public class Result {
    //编码200成功，400失败
    private int code;
    //消息
    private String msg;
    //返回总记录数
    private Long total;
    //数据
    private Object data;

    public static Result result(int code,String msg,Long total,Object data){
        Result res = new Result();
        res.setTotal(total);
        res.setMsg(msg);
        res.setData(data);
        res.setCode(code);
        return res;
    }

    public static Result suc(Long total,Object data){
        return result(200,"成功",total,data);
    }

    public static Result fail(){
        return result(400,"失败",0L,null);
    }

}
