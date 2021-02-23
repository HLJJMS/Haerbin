package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnonuncementListBean {

    /**
     * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"notice_id":1,"title":"测试公告","linkurl":"","add_time":"2021-02-28"}]}
     * code : 1
     * msg : 成功
     */

    @SerializedName("list")
    private ListDTO list;
    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;

    public ListDTO getList() {
        return list;
    }

    public void setList(ListDTO list) {
        this.list = list;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class ListDTO {
        /**
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"notice_id":1,"title":"测试公告","linkurl":"","add_time":"2021-02-28"}]
         */

        @SerializedName("total")
        private Integer total;
        @SerializedName("per_page")
        private Integer perPage;
        @SerializedName("current_page")
        private Integer currentPage;
        @SerializedName("last_page")
        private Integer lastPage;
        @SerializedName("data")
        private List<DataDTO> data;

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(Integer currentPage) {
            this.currentPage = currentPage;
        }

        public Integer getLastPage() {
            return lastPage;
        }

        public void setLastPage(Integer lastPage) {
            this.lastPage = lastPage;
        }

        public List<DataDTO> getData() {
            return data;
        }

        public void setData(List<DataDTO> data) {
            this.data = data;
        }

        public static class DataDTO {
            /**
             * notice_id : 1
             * title : 测试公告
             * linkurl :
             * add_time : 2021-02-28
             */

            @SerializedName("notice_id")
            private Integer noticeId;
            @SerializedName("title")
            private String title;
            @SerializedName("linkurl")
            private String linkurl;
            @SerializedName("add_time")
            private String addTime;

            public Integer getNoticeId() {
                return noticeId;
            }

            public void setNoticeId(Integer noticeId) {
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
