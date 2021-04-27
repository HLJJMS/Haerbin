package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PrivateDoWorkBean {

    /**
     * list : [{"cate_id":4,"title":"生育收养","icon":""},{"cate_id":5,"title":"户籍办理","icon":""},{"cate_id":6,"title":"民族宗教","icon":""},{"cate_id":7,"title":"教育科研","icon":""},{"cate_id":8,"title":"入伍服役","icon":""},{"cate_id":9,"title":"就业创业","icon":""},{"cate_id":10,"title":"设立变更","icon":""},{"cate_id":11,"title":"准营办理","icon":""},{"cate_id":12,"title":"抵押质押","icon":""},{"cate_id":13,"title":"职业资格","icon":""},{"cate_id":14,"title":"纳税缴费","icon":""},{"cate_id":15,"title":"婚姻登记","icon":""},{"cate_id":16,"title":"优待抚恤","icon":""},{"cate_id":17,"title":"规划建设","icon":""},{"cate_id":18,"title":"住房保障","icon":""},{"cate_id":19,"title":"社会保障","icon":""},{"cate_id":20,"title":"证件办理","icon":""},{"cate_id":21,"title":"交通出行","icon":""},{"cate_id":22,"title":"旅游观光","icon":""},{"cate_id":23,"title":"处境入境","icon":""},{"cate_id":24,"title":"消费维权","icon":""},{"cate_id":25,"title":"公共安全","icon":""},{"cate_id":26,"title":"司法公证","icon":""},{"cate_id":27,"title":"知识产权","icon":""},{"cate_id":28,"title":"环保绿化","icon":""},{"cate_id":29,"title":"文化体育","icon":""},{"cate_id":30,"title":"公用事业","icon":""},{"cate_id":31,"title":"医疗卫生","icon":""},{"cate_id":32,"title":"离职退休","icon":""},{"cate_id":33,"title":"死亡殡葬","icon":""},{"cate_id":34,"title":"其他","icon":""}]
     * code : 1
     * msg : 成功
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("list")
    private ArrayList<List> list;

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

    public ArrayList<List> getList() {
        return list;
    }

    public void setList(ArrayList<List> list) {
        this.list = list;
    }

    public static class List {
        /**
         * cate_id : 4
         * title : 生育收养
         * icon :
         */

        @SerializedName("cate_id")
        private String cateId;
        @SerializedName("title")
        private String title;
        @SerializedName("icon")
        private String icon;

        public String getCateId() {
            return cateId;
        }

        public void setCateId(String cateId) {
            this.cateId = cateId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }
}
