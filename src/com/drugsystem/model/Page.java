package com.drugsystem.model;

/**
 * Created by Administrator on 2015/11/4.
 */
public class Page {

    private String daoBeanName;   //ʵ������,����User,����дUser
    private int pageNow;           //��ǰҳ
    private int pageSize;          //ÿҳ��ʾ����
    private int  totalCount;       //����

    private static Page page=null;
    public Page(){}

    public static Page getInstance(){
        if(page==null){
            page=new Page();
        }
        return page;
    }

    /**
     * ��ȡ����ҳ��
     * @return
     */
   public int getPages(){
       return totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
   }
    public String getDaoBeanName() {
        return daoBeanName;
    }

    public void setDaoBeanName(String daoBeanName) {
        this.daoBeanName = daoBeanName;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public static Page getPage() {
        return page;
    }

    public static void setPage(Page page) {
        Page.page = page;
    }
}
