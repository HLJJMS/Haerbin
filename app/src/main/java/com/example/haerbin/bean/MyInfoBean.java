package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class MyInfoBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"id":4,"username":"2","password":"409dde27bd9a15f84e25c2b3bfbb734e","headimgurl":"","realname":"刘能","idtype":"身份证","idcard":"230802197708099888","mobile":"18846089921","sex":1,"reg_type":1,"prov":"","city":"","area":"","address":"","email":"","auth":0,"company_id":0,"create_time":1614907470,"update_time":1614908004,"status":1,"logout_reason":""}
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
         * id : 4
         * username : 2
         * password : 409dde27bd9a15f84e25c2b3bfbb734e
         * headimgurl :
         * realname : 刘能
         * idtype : 身份证
         * idcard : 230802197708099888
         * mobile : 18846089921
         * sex : 1
         * reg_type : 1
         * prov :
         * city :
         * area :
         * address :
         * email :
         * auth : 0
         * company_id : 0
         * create_time : 1614907470
         * update_time : 1614908004
         * status : 1
         * logout_reason :
         */

        @SerializedName("id")
        private int id;
        @SerializedName("username")
        private String username;
        @SerializedName("password")
        private String password;
        @SerializedName("headimgurl")
        private String headimgurl;
        @SerializedName("realname")
        private String realname;
        @SerializedName("idtype")
        private String idtype;
        @SerializedName("idcard")
        private String idcard;
        @SerializedName("mobile")
        private String mobile;
        @SerializedName("sex")
        private int sex;
        @SerializedName("reg_type")
        private int regType;
        @SerializedName("prov")
        private String prov;
        @SerializedName("city")
        private String city;
        @SerializedName("area")
        private String area;
        @SerializedName("address")
        private String address;
        @SerializedName("email")
        private String email;
        @SerializedName("auth")
        private int auth;
        @SerializedName("company_id")
        private int companyId;
        @SerializedName("create_time")
        private int createTime;
        @SerializedName("update_time")
        private int updateTime;
        @SerializedName("status")
        private int status;
        @SerializedName("logout_reason")
        private String logoutReason;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getHeadimgurl() {
            return headimgurl;
        }

        public void setHeadimgurl(String headimgurl) {
            this.headimgurl = headimgurl;
        }

        public String getRealname() {
            return realname;
        }

        public void setRealname(String realname) {
            this.realname = realname;
        }

        public String getIdtype() {
            return idtype;
        }

        public void setIdtype(String idtype) {
            this.idtype = idtype;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
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

        public String getProv() {
            return prov;
        }

        public void setProv(String prov) {
            this.prov = prov;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getAuth() {
            return auth;
        }

        public void setAuth(int auth) {
            this.auth = auth;
        }

        public int getCompanyId() {
            return companyId;
        }

        public void setCompanyId(int companyId) {
            this.companyId = companyId;
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

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getLogoutReason() {
            return logoutReason;
        }

        public void setLogoutReason(String logoutReason) {
            this.logoutReason = logoutReason;
        }
    }
}
