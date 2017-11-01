package com.mo.base.query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Moonston on 2017/10/28.
 * 分页显示的数据
 * //分页查询结果对象
 **/
@SuppressWarnings("unchecked")
public class QueryPageResult<T> {

    private List<T> listData;// 当前页的结果集数据:查询
    private int totalCount;// 总数据条数:查询

    private int currentPage = 1;//当前页，默认从1开始
    private int pageSize = 10;//每页显示的数据数

    private int prePage;//上一页
    private int nextPage;//下一页
    private int totalPage;//总页数

    //判断总页数，如果为0，则返回一个空集列表
    public static QueryPageResult empty(int pageSize) {
        return new QueryPageResult(new ArrayList<>(),0,1,pageSize);
    }

    //获取总页数
    public int getTotalPage(){
        return totalPage == 0 ? 1:totalPage;
    }

    public QueryPageResult(List<T> listData, int totalCount, int currentPage, int pageSize) {
        this.listData = listData;
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        //计算总页数
        this.totalPage = this.totalCount%this.pageSize
                == 0 ? this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
        //计算上一页
        this.prePage = this.currentPage-1>=1 ? this.currentPage-1:1;
        //计算下一页
        this.nextPage = this.currentPage+1<=this.totalPage?this.currentPage+1:this.totalPage;
    }

    public List<?> getListData() {
        return listData;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public int getNextPage() {
        return nextPage;
    }
}
