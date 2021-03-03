package com.example.haerbin.bean;

import android.content.Intent;

public class GovermentServiceBean {
    int img;
    String txt;
    Intent intent;

    public GovermentServiceBean(int img, String txt, Intent intent) {
        this.img = img;
        this.txt = txt;
        this.intent = intent;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
}
