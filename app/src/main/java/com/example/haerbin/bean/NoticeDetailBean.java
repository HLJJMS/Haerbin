package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class NoticeDetailBean {

    /**
     * data : {"notice_id":1,"title":"测试公告","content":"测试公告测试公告","linkurl":"","add_time":"2021-02-28"}
     * code : 1
     * msg : 成功
     */

    @SerializedName("data")
    private Data data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
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

    public static class Data {
        /**
         * notice_id : 1
         * title : 测试公告
         * content : 测试公告测试公告
         * linkurl :
         * add_time : 2021-02-28
         */

        @SerializedName("notice_id")
        private int noticeId;
        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
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

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

