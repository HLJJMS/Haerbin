package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ErrorBean {

    /**
     * list : {"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"fault_id":6,"sn":"202102251333589606","type":2,"department":"测试部门","content":"ece发的","create_time":"2021-02-25 13:33:58"},{"fault_id":5,"sn":"202102251333445547","type":1,"department":"","content":"ece发的","create_time":"2021-02-25 13:33:44"}]}
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
         * total : 2
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"fault_id":6,"sn":"202102251333589606","type":2,"department":"测试部门","content":"ece发的","create_time":"2021-02-25 13:33:58"},{"fault_id":5,"sn":"202102251333445547","type":1,"department":"","content":"ece发的","create_time":"2021-02-25 13:33:44"}]
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
             * fault_id : 6
             * sn : 202102251333589606
             * type : 2
             * department : 测试部门
             * content : ece发的
             * create_time : 2021-02-25 13:33:58
             */

            @SerializedName("fault_id")
            private int faultId;
            @SerializedName("sn")
            private String sn;
            @SerializedName("type")
            private int type;
            @SerializedName("department")
            private String department;
            @SerializedName("content")
            private String content;
            @SerializedName("create_time")
            private String createTime;

            public int getFaultId() {
                return faultId;
            }

            public void setFaultId(int faultId) {
                this.faultId = faultId;
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
        }
    }
}
