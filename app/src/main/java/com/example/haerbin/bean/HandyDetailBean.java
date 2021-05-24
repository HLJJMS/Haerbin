package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class HandyDetailBean {

    /**
     * data : {"handy_id":1,"title":"法医临床司法鉴定机构","content":"","linkurl":""}
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
         * handy_id : 1
         * title : 法医临床司法鉴定机构
         * content :
         * linkurl :
         */

        @SerializedName("handy_id")
        private int handyId;
        @SerializedName("title")
        private String title;
        @SerializedName("content")
        private String content;
        @SerializedName("linkurl")
        private String linkurl;

        public int getHandyId() {
            return handyId;
        }

        public void setHandyId(int handyId) {
            this.handyId = handyId;
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
    }
}
