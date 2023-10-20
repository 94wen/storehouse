package com.wms.common;

import java.util.HashMap;

/**
 * @Author wen
 * @Data 2023/9/30 14:51
 */
public class QueryPageParam {

    private int pageSize;
    private int pageNum;

    private HashMap param = new HashMap();

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
