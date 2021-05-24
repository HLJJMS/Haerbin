package com.example.haerbin.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HomeBean {

    /**
     * banner : [{"ad_id":1,"title":"首页广告宣传1","picurl":"http://wuyouban.yundianx.com/uploads/20210316/f2ec45297fa56d47d9175c21ff0bd27f.png","linkurl":""},{"ad_id":2,"title":"首页广告宣传2","picurl":"http://wuyouban.yundianx.com/uploads/20210316/ac9d88cf1e19e41f356bbdd94b91210d.png","linkurl":""}]
     * ad : [{"ad_id":3,"title":"仁","picurl":"http://wuyouban.yundianx.com/uploads/20210316/d529d87a6c369c3037ec5838629b5253.png","linkurl":""},{"ad_id":4,"title":"义","picurl":"http://wuyouban.yundianx.com/uploads/20210316/57f1348e4c883520a8cbac17e0bc7c15.png","linkurl":""},{"ad_id":5,"title":"礼","picurl":"http://wuyouban.yundianx.com/uploads/20210316/b93b1d6f76bb6c6e5fadd4ef04163033.png","linkurl":""},{"ad_id":6,"title":"智","picurl":"http://wuyouban.yundianx.com/uploads/20210316/679c4f8d814340f348d5029444b31706.png","linkurl":""},{"ad_id":7,"title":"信","picurl":"http://wuyouban.yundianx.com/uploads/20210316/fc02b10f6e9fe6b55234ca0c9d4ae7fd.png","linkurl":""}]
     * article : [{"article_id":1,"title":"测试新闻"}]
     * handy : [{"handy_id":4,"title":"公积金开户","linkurl":"","picurl":""},{"handy_id":5,"title":"不动产查询","linkurl":"","picurl":""},{"handy_id":6,"title":"缴存单位变更登记","linkurl":"","picurl":""},{"handy_id":7,"title":"电子监控违法处理","linkurl":"","picurl":""},{"handy_id":12,"title":"公积金查询","linkurl":"","picurl":""},{"handy_id":13,"title":"养老保险","linkurl":"","picurl":""},{"handy_id":14,"title":"医疗保险","linkurl":"","picurl":""}]
     * promo : [{"ad_id":9,"title":"宣传","picurl":"http://wuyouban.yundianx.com/uploads/20210316/308d52ea5de37d19e3d1f7281853391c.png","linkurl":""}]
     * impress : [{"ad_id":8,"title":"五常印象","picurl":"http://wuyouban.yundianx.com/uploads/20210316/60e8adefcfc07aaa07a3d6c468368611.png","linkurl":""}]
     * code : 1
     * msg : 成功
     */

    @SerializedName("code")
    private int code;
    @SerializedName("msg")
    private String msg;
    @SerializedName("banner")
    private List<Banner> banner;
    @SerializedName("ad")
    private List<Ad> ad;
    @SerializedName("article")
    private List<Article> article;
    @SerializedName("handy")
    private List<Handy> handy;
    @SerializedName("promo")
    private List<Promo> promo;
    @SerializedName("impress")
    private List<Impress> impress;

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

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<Ad> getAd() {
        return ad;
    }

    public void setAd(List<Ad> ad) {
        this.ad = ad;
    }

    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    public List<Handy> getHandy() {
        return handy;
    }

    public void setHandy(List<Handy> handy) {
        this.handy = handy;
    }

    public List<Promo> getPromo() {
        return promo;
    }

    public void setPromo(List<Promo> promo) {
        this.promo = promo;
    }

    public List<Impress> getImpress() {
        return impress;
    }

    public void setImpress(List<Impress> impress) {
        this.impress = impress;
    }

    public static class Banner {
        /**
         * ad_id : 1
         * title : 首页广告宣传1
         * picurl : http://wuyouban.yundianx.com/uploads/20210316/f2ec45297fa56d47d9175c21ff0bd27f.png
         * linkurl :
         */

        @SerializedName("ad_id")
        private int adId;
        @SerializedName("title")
        private String title;
        @SerializedName("picurl")
        private String picurl;
        @SerializedName("linkurl")
        private String linkurl;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }

    public static class Ad {
        /**
         * ad_id : 3
         * title : 仁
         * picurl : http://wuyouban.yundianx.com/uploads/20210316/d529d87a6c369c3037ec5838629b5253.png
         * linkurl :
         */

        @SerializedName("ad_id")
        private int adId;
        @SerializedName("title")
        private String title;
        @SerializedName("picurl")
        private String picurl;
        @SerializedName("linkurl")
        private String linkurl;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }

    public static class Article {
        /**
         * article_id : 1
         * title : 测试新闻
         */

        @SerializedName("article_id")
        private int articleId;
        @SerializedName("title")
        private String title;

        public int getArticleId() {
            return articleId;
        }

        public void setArticleId(int articleId) {
            this.articleId = articleId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }

    public static class Handy {
        /**
         * handy_id : 4
         * title : 公积金开户
         * linkurl :
         * picurl :
         */

        @SerializedName("handy_id")
        private int handyId;
        @SerializedName("title")
        private String title;
        @SerializedName("linkurl")
        private String linkurl;
        @SerializedName("picurl")
        private String picurl;

        public int getHandyId() {
            return handyId;
        }

        public void setHandyId(int handyId) {
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

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }
    }

    public static class Promo {
        /**
         * ad_id : 9
         * title : 宣传
         * picurl : http://wuyouban.yundianx.com/uploads/20210316/308d52ea5de37d19e3d1f7281853391c.png
         * linkurl :
         */

        @SerializedName("ad_id")
        private int adId;
        @SerializedName("title")
        private String title;
        @SerializedName("picurl")
        private String picurl;
        @SerializedName("linkurl")
        private String linkurl;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }

    public static class Impress {
        /**
         * ad_id : 8
         * title : 五常印象
         * picurl : http://wuyouban.yundianx.com/uploads/20210316/60e8adefcfc07aaa07a3d6c468368611.png
         * linkurl :
         */

        @SerializedName("ad_id")
        private int adId;
        @SerializedName("title")
        private String title;
        @SerializedName("picurl")
        private String picurl;
        @SerializedName("linkurl")
        private String linkurl;

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicurl() {
            return picurl;
        }

        public void setPicurl(String picurl) {
            this.picurl = picurl;
        }

        public String getLinkurl() {
            return linkurl;
        }

        public void setLinkurl(String linkurl) {
            this.linkurl = linkurl;
        }
    }
}
