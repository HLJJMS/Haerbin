package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DoWorkDetailBean implements Serializable {

    /**
     * data : {"guide_id":1,"item_name":"城市地下空间开发利用","item_type":"行政许可","united_coding":"","deal_depth":"二级标准","promise_workday":"2","deal_channel":"1,2,3,4","run_count":"1"}
     * cate : [{"cate_id":1,"title":"基本信息","relate":"guide_basic","list":[{"id":1,"guide_id":1,"vartype":"text","varinfo":"事项类型","varname":"","varvalue":"行政许可","status":1,"sort":1,"create_time":0,"update_time":0}]},{"cate_id":2,"title":"办理信息","relate":"guide_deal","list":[{"id":1,"guide_id":1,"vartype":"text","varinfo":"受理时限","varname":"","varvalue":"\t1个工作日","status":1,"sort":1,"create_time":0,"update_time":0}]},{"cate_id":3,"title":"办理地址","relate":"guide_addr","list":[{"id":1,"guide_id":1,"vartype":"text","varinfo":"办理地址","varname":"","varvalue":"哈尔滨市南岗区中山路路181号市民大厦人防窗口","status":1,"sort":1,"create_time":0,"update_time":0},{"id":2,"guide_id":1,"vartype":"text","varinfo":"办理时间","varname":"","varvalue":"周一至周五（工作日） 上午：8:30-11:30 下午：13:30-16:30","status":1,"sort":1,"create_time":0,"update_time":0}]},{"cate_id":4,"title":"流程图","relate":"guide_chart","list":[]},{"cate_id":5,"title":"申请材料信息","relate":"guide_materials","list":[]},{"cate_id":6,"title":"常见问题","relate":"guide_question","list":[{"id":1,"guide_id":1,"question":"测试问题","answer":"没有答案","status":1,"sort":1,"create_time":0,"update_time":0}]}]
     * code : 1
     * msg : 成功
     */

    @SerializedName("data")
    private Data data;
    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("cate")
    private List<Cate> cate;

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

    public List<Cate> getCate() {
        return cate;
    }

    public void setCate(List<Cate> cate) {
        this.cate = cate;
    }

    public static class Data  {
        /**
         * guide_id : 1
         * item_name : 城市地下空间开发利用
         * item_type : 行政许可
         * united_coding :
         * deal_depth : 二级标准
         * promise_workday : 2
         * deal_channel : 1,2,3,4
         * run_count : 1
         */

        @SerializedName("guide_id")
        private int guideId;
        @SerializedName("item_name")
        private String itemName;
        @SerializedName("item_type")
        private String itemType;
        @SerializedName("united_coding")
        private String unitedCoding;
        @SerializedName("deal_depth")
        private String dealDepth;
        @SerializedName("promise_workday")
        private String promiseWorkday;
        @SerializedName("deal_channel")
        private String dealChannel;
        @SerializedName("run_count")
        private String runCount;

        public int getGuideId() {
            return guideId;
        }

        public void setGuideId(int guideId) {
            this.guideId = guideId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        public String getUnitedCoding() {
            return unitedCoding;
        }

        public void setUnitedCoding(String unitedCoding) {
            this.unitedCoding = unitedCoding;
        }

        public String getDealDepth() {
            return dealDepth;
        }

        public void setDealDepth(String dealDepth) {
            this.dealDepth = dealDepth;
        }

        public String getPromiseWorkday() {
            return promiseWorkday;
        }

        public void setPromiseWorkday(String promiseWorkday) {
            this.promiseWorkday = promiseWorkday;
        }

        public String getDealChannel() {
            return dealChannel;
        }

        public void setDealChannel(String dealChannel) {
            this.dealChannel = dealChannel;
        }

        public String getRunCount() {
            return runCount;
        }

        public void setRunCount(String runCount) {
            this.runCount = runCount;
        }
    }

    public static class Cate  implements Serializable {
        /**
         * cate_id : 1
         * title : 基本信息
         * relate : guide_basic
         * list : [{"id":1,"guide_id":1,"vartype":"text","varinfo":"事项类型","varname":"","varvalue":"行政许可","status":1,"sort":1,"create_time":0,"update_time":0}]
         */

        @SerializedName("cate_id")
        private int cateId;
        @SerializedName("title")
        private String title;
        @SerializedName("relate")
        private String relate;
        @SerializedName("list")
        private ArrayList<List> list;

        public int getCateId() {
            return cateId;
        }

        public void setCateId(int cateId) {
            this.cateId = cateId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRelate() {
            return relate;
        }

        public void setRelate(String relate) {
            this.relate = relate;
        }

        public ArrayList<List> getList() {
            return list;
        }

        public void setList(ArrayList<List> list) {
            this.list = list;
        }

        public static class List implements Serializable {
            /**
             * id : 1
             * guide_id : 1
             * vartype : text
             * varinfo : 事项类型
             * varname :
             * varvalue : 行政许可
             * status : 1
             * sort : 1
             * create_time : 0
             * update_time : 0
             */

            @SerializedName("id")
            private int id;
            @SerializedName("guide_id")
            private int guideId;
            @SerializedName("vartype")
            private String vartype;
            @SerializedName("varinfo")
            private String varinfo;
            @SerializedName("varname")
            private String varname;
            @SerializedName("varvalue")
            private String varvalue;
            @SerializedName("status")
            private int status;
            @SerializedName("sort")
            private int sort;
            @SerializedName("create_time")
            private int createTime;
            @SerializedName("update_time")
            private int updateTime;
            @SerializedName("picurl")
           private String picurl;

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getGuideId() {
                return guideId;
            }

            public void setGuideId(int guideId) {
                this.guideId = guideId;
            }

            public String getVartype() {
                return vartype;
            }

            public void setVartype(String vartype) {
                this.vartype = vartype;
            }

            public String getVarinfo() {
                return varinfo;
            }

            public void setVarinfo(String varinfo) {
                this.varinfo = varinfo;
            }

            public String getVarname() {
                return varname;
            }

            public void setVarname(String varname) {
                this.varname = varname;
            }

            public String getVarvalue() {
                return varvalue;
            }

            public void setVarvalue(String varvalue) {
                this.varvalue = varvalue;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getCreateTime() {
                return createTime;
            }

            public void setCreateTime(int createTime) {
                this.createTime = createTime;
            }

            public int getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(int updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
