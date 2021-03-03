package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class LoginBean {

    /**
     * code : 1
     * msg : 登录成功
     * data : {"user_id":1,"mobile":"18846938242","realname":"马淑霞","headimgurl":"","sex":1,"reg_type":1,"token":"87250744be66eabf0fce613a27eeecc3"}
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("data")
    private Data data;

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

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        /**
         * user_id : 1
         * mobile : 18846938242
         * realname : 马淑霞
         * headimgurl :
         * sex : 1
         * reg_type : 1
         * token : 87250744be66eabf0fce613a27eeecc3
         */

        @SerializedName("user_id")
        private int userId;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("realname")
        private String realname;
        @SerializedName("headimgurl")
        private String headimgurl;
        @SerializedName("sex")
        private int sex;
        @SerializedName("reg_type")
        private int regType;
        @SerializedName("token")
        private String token;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getRegType() {
            return regType;
        }

        public void setRegType(int regType) {
            this.regType = regType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
