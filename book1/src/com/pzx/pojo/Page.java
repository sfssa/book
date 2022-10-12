package com.pzx.pojo;

import java.util.List;

/**
 * @author panzhixin
 * @date 2022/10/4
 * @description
 */

public class Page<T> {
    //每页显示的数目
    public static final Integer PAGE_SIZE =4;
    //当前页码
    private Integer pageNo;
    //页码总数
    private Integer pageTotal;
    //总记录数
    private Integer pageTotalCount;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private Integer PageSize=PAGE_SIZE;
    //当前页书籍
    private List<T>items;

    public Integer getPageSize() {
        return PageSize;
    }

    public void setPageSize(Integer pageSize) {
        PageSize = pageSize;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", url='" + url + '\'' +
                ", PageSize=" + PageSize +
                ", items=" + items +
                '}';
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if(pageNo<1){
            pageNo=1;
        }
        if(pageNo>pageTotal){
            pageNo=pageTotal;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}