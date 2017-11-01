package com.mo.base.entity;

import com.alibaba.fastjson.JSONObject;
import com.mo.base.utils.JSONResult;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Moonston on 2017/10/29.
 * 实名认证
 */
public class RealAuth extends BaseEntity{

    //定义认证状态
    public static final int STATE_UNCKECK = 0;//未审核
    public static final int STATE_NOMAL = 1;//正常审核中
    public static final int STATE_HASCHECK = 2;//已审核


    //定义性别常量
    private static final int SEX_MALE = 0;
    private static final int SEX_FAMALE = 1;

    private String realName;//真实姓名
    private int sex;//性别
    private String birthDate;//出生日期
    private String idNumber;//出生日期
    private String address;//出生日期
    private int state;//认证状态
    private String image1;//身份证正面图片地址
    private String image2;//身份证反面面图片地址
    private String remark;//认证备注
    private Date auditTime;//审核时间
    private Date applyTime;//申请时间

    private Logininfo auditor;//审核人
    private Logininfo applier;//申请人

    //显示性别
    public String getSexDisply(){
        return sex == SEX_MALE ? "男":"女";
    }

    //返回json数据
    public String getJsonString(){
        Map<String,Object> json = new HashMap<>();
        json.put("id",id);
        json.put("realName",id);
        json.put("sex",getSexDisply());
        json.put("birthDate",birthDate);
        json.put("idNumber",idNumber);
        json.put("address",address);
        json.put("state",state);
        json.put("image1",image1);
        json.put("image2",image2);
        json.put("remark",remark);
        return JSONObject.toJSONString(json);
    }


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public Logininfo getAuditor() {
        return auditor;
    }

    public void setAuditor(Logininfo auditor) {
        this.auditor = auditor;
    }

    public Logininfo getApplier() {
        return applier;
    }

    public void setApplier(Logininfo applier) {
        this.applier = applier;
    }



}
