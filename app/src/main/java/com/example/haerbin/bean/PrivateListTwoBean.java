package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PrivateListTwoBean {

    /**
     * list : {"total":1,"per_page":10,"current_page":1,"last_page":1,"data":[{"guide_id":1,"item_name":"城市地下空间开发利用","item_type":"行政许可"}]}
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
         * data : [{"guide_id":1,"item_name":"城市地下空间开发利用","item_type":"行政许可"}]
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
             * guide_id : 1
             * item_name : 城市地下空间开发利用
             * item_type : 行政许可
             */

            @SerializedName("guide_id")
            private int guideId;
            @SerializedName("item_name")
            private String itemName;
            @SerializedName("item_type")
            private String itemType;

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
        }
    }
}
