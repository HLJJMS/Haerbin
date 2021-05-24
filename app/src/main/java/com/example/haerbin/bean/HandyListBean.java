package com.example.haerbin.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HandyListBean {


    /**
     * list : [{"cate_id":1,"title":"司法公证","list":[{"handy_id":1,"title":"法医临床司法鉴定机构","linkurl":"","icon":""},{"handy_id":2,"title":"法医病理司法鉴定机构","linkurl":"","icon":""},{"handy_id":3,"title":"法医病理鉴定指南","linkurl":"","icon":""}]},{"cate_id":2,"title":"房屋产权","list":[{"handy_id":4,"title":"公积金开户","linkurl":"","icon":""},{"handy_id":5,"title":"不动产查询","linkurl":"","icon":""},{"handy_id":6,"title":"缴存单位变更登记","linkurl":"","icon":""}]},{"cate_id":3,"title":"交通旅游","list":[{"handy_id":7,"title":"电子监控违法处理","linkurl":"","icon":""},{"handy_id":8,"title":"本地考试预约","linkurl":"","icon":""},{"handy_id":9,"title":"期满换证","linkurl":"","icon":""},{"handy_id":10,"title":"机动车检验预约","linkurl":"","icon":""},{"handy_id":11,"title":"交通违法网上查询","linkurl":"","icon":""}]},{"cate_id":4,"title":"社会保障","list":[{"handy_id":12,"title":"公积金查询","linkurl":"","icon":""},{"handy_id":13,"title":"养老保险","linkurl":"","icon":""},{"handy_id":14,"title":"医疗保险","linkurl":"","icon":""},{"handy_id":15,"title":"企业医疗保险","linkurl":"","icon":""},{"handy_id":16,"title":"工伤保险","linkurl":"","icon":""}]},{"cate_id":5,"title":"教育培训","list":[{"handy_id":17,"title":"幼儿园收费","linkurl":"","icon":""},{"handy_id":18,"title":"用人单位人事代理申请","linkurl":"","icon":""},{"handy_id":19,"title":"事业单位招考","linkurl":"","icon":""},{"handy_id":20,"title":"执业资格考试","linkurl":"","icon":""},{"handy_id":21,"title":"公务员考试","linkurl":"","icon":""}]}]
     * code : 1
     * msg : 成功
     */

    @SerializedName("code")
    private Integer code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("list")
    private List<ListDTOX> list;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListDTOX> getList() {
        return list;
    }

    public void setList(List<ListDTOX> list) {
        this.list = list;
    }

    public static class ListDTOX {
        /**
         * cate_id : 1
         * title : 司法公证
         * list : [{"handy_id":1,"title":"法医临床司法鉴定机构","linkurl":"","icon":""},{"handy_id":2,"title":"法医病理司法鉴定机构","linkurl":"","icon":""},{"handy_id":3,"title":"法医病理鉴定指南","linkurl":"","icon":""}]
         */

        @SerializedName("cate_id")
        private Integer cateId;
        @SerializedName("title")
        private String title;
        @SerializedName("list")
        private List<ListDTO> list;

        public Integer getCateId() {
            return cateId;
        }

        public void setCateId(Integer cateId) {
            this.cateId = cateId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListDTO> getList() {
            return list;
        }

        public void setList(List<ListDTO> list) {
            this.list = list;
        }

        public static class ListDTO implements MultiItemEntity {
            public ListDTO(String handyId, String title, String linkurl, String icon, int type) {
                this.handyId = handyId;
                this.title = title;
                this.linkurl = linkurl;
                this.icon = icon;
                this.type = type;
            }

            /**
             * handy_id : 1
             * title : 法医临床司法鉴定机构
             * linkurl :
             * icon :
             */

            @SerializedName("handy_id")
            private String handyId;
            @SerializedName("title")
            private String title;
            @SerializedName("linkurl")
            private String linkurl;
            @SerializedName("icon")
            private String icon="";
            private int type = 0;

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getHandyId() {
                return handyId;
            }

            public void setHandyId(String handyId) {
                this.handyId = handyId;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getLinkurl() {
                return linkurl;
            }

            public void setLinkurl(String linkurl) {
                this.linkurl = linkurl;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            @Override
            public int getItemType() {
                return type;
            }
        }
    }
}
