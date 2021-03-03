package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class DepartMentDetailBean {

    /**
     * data : {"department_id":1,"title":"五常市民政局","initial":"W","address":"哈尔滨市五常市亚臣路498号","lat":"44.926552","lng":"127.167023","phone":"0451-53585858","intro":"结婚证办理\r\n离婚证办理\r\n退伍办理\r\n收养办理\r\n低保办理\r\n五保户办理\r\n流浪救助办理\r\n离婚办理办理\r\n婚姻登记办理"}
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
         * department_id : 1
         * title : 五常市民政局
         * initial : W
         * address : 哈尔滨市五常市亚臣路498号
         * lat : 44.926552
         * lng : 127.167023
         * phone : 0451-53585858
         * intro : 结婚证办理
         离婚证办理
         退伍办理
         收养办理
         低保办理
         五保户办理
         流浪救助办理
         离婚办理办理
         婚姻登记办理
         */

        @SerializedName("department_id")
        private int departmentId;
        @SerializedName("title")
        private String title;
        @SerializedName("initial")
        private String initial;
        @SerializedName("address")
        private String address;
        @SerializedName("lat")
        private Double lat;
        @SerializedName("lng")
        private Double lng;
        @SerializedName("phone")
        private String phone;
        @SerializedName("intro")
        private String intro;

        public int getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getInitial() {
            return initial;
        }

        public void setInitial(String initial) {
            this.initial = initial;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Double getLat() {
            return lat;
        }

        public void setLat(Double lat) {
            this.lat = lat;
        }

        public Double getLng() {
            return lng;
        }

        public void setLng(Double lng) {
            this.lng = lng;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }
}
