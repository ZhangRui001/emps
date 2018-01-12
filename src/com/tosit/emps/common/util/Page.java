package com.tosit.emps.common.util;

import java.util.Collection;

/**
 * 分页器
 * @param <T>
 */
public class Page<T> {
    private int pageSize;
    private int pageNo;
    private int count;
    private Collection<T> data;
    private int pageCount ;
    /*private int  nextPage;
    private int  prevPage;*/
    private int firstPage = 1;
    private int lastPage =0;

    public Page(int pageNo,int pageSize,int count,Collection<T> data) {
        this.count=count;
        this.pageCount = (count/pageSize) + (count%pageSize==0?0:1);
        this.data = data;
        if (!(pageNo>=1 && pageNo<=pageCount)){
            throw  new RuntimeException("分页错误");
        }
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.firstPage=1;
        this.lastPage = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getCount() {
        return count;
    }

    public Collection<T> getData() {
        return data;
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getNextPage() {
        if(this.pageNo+1<=pageCount){
            return pageNo+1;
        }
        return lastPage;
    }

    public int getPrevPage() {
        if(this.pageNo-1>=1){
            return pageNo-1;
        }
        return firstPage;
    }

    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }
}
