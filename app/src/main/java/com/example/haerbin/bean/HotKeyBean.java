package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;


public class HotKeyBean implements Serializable {


    /**
     * data : [{"label":"热点1","value":"热点1"},{"label":"热点二","value":"热点二"},{"label":"五常天气","value":"五常天气"}]
     * code : 1
     * msg : 成功
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private List<Data> data;

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

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public static class Data {
        /**
         * label : 热点1
         * value : 热点1
         */

        @SerializedName("label")
        private String label;
        @SerializedName("value")
        private String value;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
