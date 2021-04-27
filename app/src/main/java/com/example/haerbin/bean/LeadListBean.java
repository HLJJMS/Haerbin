package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LeadListBean {

    /**
     * list : {"total":22,"per_page":10,"current_page":1,"last_page":3,"data":[{"lead_id":1,"title":"我要办医生相关业务"},{"lead_id":2,"title":"我要办盲人医疗按摩相关业务"},{"lead_id":3,"title":"我要从事医务工作"},{"lead_id":4,"title":"我要办理车辆转移、过户相关业务"},{"lead_id":5,"title":"我要成为出租汽车驾驶员"},{"lead_id":6,"title":"我要办道路运输从业人员从业资格认定"},{"lead_id":7,"title":"我要办社保卡相关业务"},{"lead_id":8,"title":"我要办内地人员收养证明"},{"lead_id":9,"title":"我要当律师"},{"lead_id":10,"title":"我要办理流动人员职称"}]}
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
         * total : 22
         * per_page : 10
         * current_page : 1
         * last_page : 3
         * data : [{"lead_id":1,"title":"我要办医生相关业务"},{"lead_id":2,"title":"我要办盲人医疗按摩相关业务"},{"lead_id":3,"title":"我要从事医务工作"},{"lead_id":4,"title":"我要办理车辆转移、过户相关业务"},{"lead_id":5,"title":"我要成为出租汽车驾驶员"},{"lead_id":6,"title":"我要办道路运输从业人员从业资格认定"},{"lead_id":7,"title":"我要办社保卡相关业务"},{"lead_id":8,"title":"我要办内地人员收养证明"},{"lead_id":9,"title":"我要当律师"},{"lead_id":10,"title":"我要办理流动人员职称"}]
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
             * lead_id : 1
             * title : 我要办医生相关业务
             */

            @SerializedName("lead_id")
            private int leadId;
            @SerializedName("title")
            private String title;

            public int getLeadId() {
                return leadId;
            }

            public void setLeadId(int leadId) {
                this.leadId = leadId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }
    }
}
