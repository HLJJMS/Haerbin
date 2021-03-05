package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class NewsListBean {

    /**
     * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"article_id":1,"title":"测试新闻","picurl":"http://127.0.0.1:8007/uploads/20210202/028e2ea3f4f5a1a434de993e2a5d009e.png","clicks":0,"create_time":"2021-02-02 15:22:04"}]}
     * code : 1
     * msg : 成功
     */

    @SerializedName("list")
    private List list;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class List {
        /**
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"article_id":1,"title":"测试新闻","picurl":"http://127.0.0.1:8007/uploads/20210202/028e2ea3f4f5a1a434de993e2a5d009e.png","clicks":0,"create_time":"2021-02-02 15:22:04"}]
         */

        @SerializedName("total")
        private int total;
        @SerializedName("per_page")
        private int perPage;
        @SerializedName("current_page")
        private int currentPage;
        @SerializedName("last_page")
        private int lastPage;
        @SerializedName("data")
        private ArrayList<Data> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPerPage() {
            return perPage;
        }

        public void setPerPage(int perPage) {
            this.perPage = perPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public ArrayList<Data> getData() {
            return data;
        }

        public void setData(ArrayList<Data> data) {
            this.data = data;
        }

        public static class Data {
            /**
             * article_id : 1
             * title : 测试新闻
             * picurl : http://127.0.0.1:8007/uploads/20210202/028e2ea3f4f5a1a434de993e2a5d009e.png
             * clicks : 0
             * create_time : 2021-02-02 15:22:04
             */

            @SerializedName("article_id")
            private int articleId;
            @SerializedName("title")
            private String title;
            @SerializedName("picurl")
            private String picurl;
            @SerializedName("clicks")
            private int clicks;
            @SerializedName("create_time")
            private String createTime;

            public int getArticleId() {
                return articleId;
            }

            public void setArticleId(int articleId) {
                this.articleId = articleId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public int getClicks() {
                return clicks;
            }

            public void setClicks(int clicks) {
                this.clicks = clicks;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}
