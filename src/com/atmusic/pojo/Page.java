package com.atmusic.pojo;

import java.util.List;

/**
 * Page 分页的模型对象
 * @author LIXICHEN
 * @create 2020-04-25 0:11
 * @param <T> 具体模块的javaBean类
 */
public class Page<T> {

    public static final Integer PAGE_SIZE = 4;

    /**
     * 当前页码
     */
    private Integer pageNo;
    /**
     * 总页码
     */
    private Integer pageTotal;
    /**
     * 当前页显示数量
     */
    private Integer pageSize = PAGE_SIZE;
    /**
     * 总记录数
     */
    private Integer pageTotalCount;
    /**
     * 当前页数据
     */
    private List<T> items;
    /**
     * 请求地址
     */
    private String url;

    public Page() {
    }

    public Page(Integer pageNo, Integer pageTotal, Integer pageSize, Integer pageTotalCount, List<T> items, String url) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
        this.url = url;
    }


    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }

}
