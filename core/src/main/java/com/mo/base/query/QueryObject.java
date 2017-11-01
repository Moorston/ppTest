package com.mo.base.query;

/**
 * Created by Moonston on 2017/10/28.
 * 定义页显示数和当前页
 */
public class QueryObject {

    private int currentPage = 1;//默认当前页为第一页
    private int pageSize = 10; //默认每页显示10条数据

    //获取开始的最初数据的位置
    public int getStart(){
        return (currentPage-1)*pageSize;
    }

    public int getCurrentPage() {

        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
