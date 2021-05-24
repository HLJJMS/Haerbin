package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NoticeBean {

    /**
     * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"notice_id":1,"title":"测试公告","linkurl":"","add_time":"2021-02-28"}]}
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
         * data : [{"notice_id":1,"title":"测试公告","linkurl":"","add_time":"2021-02-28"}]
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
             * notice_id : 1
             * title : 测试公告
             * linkurl :
             * add_time : 2021-02-28
             */

            @SerializedName("notice_id")
            private int noticeId;
            @SerializedName("title")
            private String title;
            @SerializedName("linkurl")
            private String linkurl;
            @SerializedName("add_time")
            private String addTime;

            public int getNoticeId() {
                return noticeId;
            }

            public void setNoticeId(int noticeId) {
                this.noticeId = noticeId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLinkurl() {
                return linkurl;
            }

            public void setLinkurl(String linkurl) {
                this.linkurl = linkurl;
            }

            public String getAddTime() {
                return addTime;
            }

            public void setAddTime(String addTime) {
                this.addTime = addTime;
            }
        }
    }
}
