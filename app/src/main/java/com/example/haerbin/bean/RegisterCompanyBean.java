package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

public class RegisterCompanyBean {

    /**
     * code : 1
     * msg : 成功
     * company_id : 1
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("company_id")
    private String companyId;

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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
