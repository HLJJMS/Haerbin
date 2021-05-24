package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class NewsDetailBean {

    /**
     * data : {"article_id":1,"title":"测试新闻","source":"政府","content":"地方","clicks":0,"create_time":"2021-02-02 15:22:04"}
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
         * article_id : 1
         * title : 测试新闻
         * source : 政府
         * content : 地方
         * clicks : 0
         * create_time : 2021-02-02 15:22:04
         */

        @SerializedName("article_id")
        private int articleId;
        @SerializedName("title")
        private String title;
        @SerializedName("source")
        private String source;
        @SerializedName("content")
        private String content;
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

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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
