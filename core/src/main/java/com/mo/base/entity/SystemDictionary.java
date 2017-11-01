package com.mo.base.entity;

/**
 * Created by Moonston on 2017/10/24.
 */
public class SystemDictionary extends BaseEntity{
    private String sn;
    private String title;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
