package com.example.haerbin.activity;

import com.google.gson.annotations.SerializedName;

public class MyBean {

    /**
     * code : 1
     * msg : 成功
     * data : {"consult_count":"我的咨询个数","fault_count":"我的纠错个数","complaint_count":"我的投诉个数","feedback_count":"我的意见反馈个数","company_count":"我的企业个数"}
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
         * consult_count : 我的咨询个数
         * fault_count : 我的纠错个数
         * complaint_count : 我的投诉个数
         * feedback_count : 我的意见反馈个数
         * company_count : 我的企业个数
         */

        @SerializedName("consult_count")
        private String consultCount;
        @SerializedName("fault_count")
        private String faultCount;
        @SerializedName("complaint_count")
        private String complaintCount;
        @SerializedName("feedback_count")
        private String feedbackCount;
        @SerializedName("company_count")
        private String companyCount;

        public String getConsultCount() {
            return consultCount;
        }

        public void setConsultCount(String consultCount) {
            this.consultCount = consultCount;
        }

        public String getFaultCount() {
            return faultCount;
        }

        public void setFaultCount(String faultCount) {
            this.faultCount = faultCount;
        }

        public String getComplaintCount() {
            return complaintCount;
        }

        public void setComplaintCount(String complaintCount) {
            this.complaintCount = complaintCount;
        }

        public String getFeedbackCount() {
            return feedbackCount;
        }

        public void setFeedbackCount(String feedbackCount) {
            this.feedbackCount = feedbackCount;
        }

        public String getCompanyCount() {
            return companyCount;
        }

        public void setCompanyCount(String companyCount) {
            this.companyCount = companyCount;
        }
    }
}
