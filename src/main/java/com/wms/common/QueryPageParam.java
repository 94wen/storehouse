package com.wms.common;

import java.util.HashMap;

/**
 * @Author wen
 * @Data 2023/9/30 14:51
 */
public class QueryPageParam {
    //默认
    private static int PAGE_SIZE=3;
    private static int PAGE_NUM=1;


    private int pageSize=PAGE_SIZE;
    private int pageNum=PAGE_NUM;

    private HashMap param;

    public HashMap getParam() {
        return param;
    }

    public void setParam(HashMap param) {
        this.param = param;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}
