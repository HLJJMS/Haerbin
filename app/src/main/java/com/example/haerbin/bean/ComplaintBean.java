package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ComplaintBean {

    /**
     * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"complaint_id":1,"sn":"202102251435148709","type":1,"department":"gfd","theme":"2332","content":"dgfd","create_time":"2021-02-25","reply_date":"2021-02-26","reply":"回复内容"}]}
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
         * data : [{"complaint_id":1,"sn":"202102251435148709","type":1,"department":"gfd","theme":"2332","content":"dgfd","create_time":"2021-02-25","reply_date":"2021-02-26","reply":"回复内容"}]
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
             * complaint_id : 1
             * sn : 202102251435148709
             * type : 1
             * department : gfd
             * theme : 2332
             * content : dgfd
             * create_time : 2021-02-25
             * reply_date : 2021-02-26
             * reply : 回复内容
             */

            @SerializedName("complaint_id")
            private int complaintId;
            @SerializedName("sn")
            private String sn;
            @SerializedName("type")
            private int type;
            @SerializedName("department")
            private String department;
            @SerializedName("theme")
            private String theme;
            @SerializedName("content")
            private String content;
            @SerializedName("create_time")
            private String createTime;
            @SerializedName("reply_date")
            private String replyDate;
            @SerializedName("reply")
            private String reply;

            public int getComplaintId() {
                return complaintId;
            }

            public void setComplaintId(int complaintId) {
                this.complaintId = complaintId;
            }

            public String getSn() {
                return sn;
            }

            public void setSn(String sn) {
                this.sn = sn;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getDepartment() {
                return department;
            }

            public void setDepartment(String department) {
                this.department = department;
            }

            public String getTheme() {
                return theme;
            }

            public void setTheme(String theme) {
                this.theme = theme;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getReplyDate() {
                return replyDate;
            }

            public void setReplyDate(String replyDate) {
                this.replyDate = replyDate;
            }

            public String getReply() {
                return reply;
            }

            public void setReply(String reply) {
                this.reply = reply;
            }
        }
    }
}
