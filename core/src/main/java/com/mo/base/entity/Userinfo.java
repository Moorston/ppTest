package com.mo.base.entity;

import com.mo.base.utils.BitStateUtils;

/**
 * Created by Moonston on 2017/10/24.
 */
public class Userinfo extends BaseEntity{

    private int version;// 版本号
    private long bitState = 0;// 用户绑定状态码
    private String realName; //真名
    private String idNumber;//身份证号码
    private String phoneNumber; //电话号码
    private String email;   //邮箱
    private int score;// 风控累计分数;
    private Long realAuthId;// 该用户对应的实名认证对象id

    private SystemDictionaryItem incomeGrade;// 收入状况
    private SystemDictionaryItem marriage;// 婚姻状况
    private SystemDictionaryItem kidCount;//子女情况
    private SystemDictionaryItem educationBackground;//教育背景
    private SystemDictionaryItem houseCondition;//住房条件

    /**
     * 添加状态码
     * @param state
     */
    public void addState(long state){
        this.setBitState(BitStateUtils.addState(this.bitState,state));
    }

    /**
     * 返回用户是否已经实名认证
     *
     * @return
     */
    public boolean getIsRealAuth(){
        return BitStateUtils.hasState(this.bitState, BitStateUtils.OP_REAL_AUTH);
    }


    /**
     * 返回用户是否已经绑定手机
     *
     * @return
     */
    public boolean getIsBindPhone(){
        return BitStateUtils.hasState(this.bitState,BitStateUtils.OP_BIND_PHONE);
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public long getBitState() {
        return bitState;
    }

    public void setBitState(long bitState) {
        this.bitState = bitState;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getRealAuthId() {
        return realAuthId;
    }

    public void setRealAuthId(Long realAuthId) {
        this.realAuthId = realAuthId;
    }

    public SystemDictionaryItem getIncomeGrade() {
        return incomeGrade;
    }

    public void setIncomeGrade(SystemDictionaryItem incomeGrade) {
        this.incomeGrade = incomeGrade;
    }

    public SystemDictionaryItem getMarriage() {
        return marriage;
    }

    public void setMarriage(SystemDictionaryItem marriage) {
        this.marriage = marriage;
    }

    public SystemDictionaryItem getKidCount() {
        return kidCount;
    }

    public void setKidCount(SystemDictionaryItem kidCount) {
        this.kidCount = kidCount;
    }

    public SystemDictionaryItem getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(SystemDictionaryItem educationBackground) {
        this.educationBackground = educationBackground;
    }

    public SystemDictionaryItem getHouseCondition() {
        return houseCondition;
    }

    public void setHouseCondition(SystemDictionaryItem houseCondition) {
        this.houseCondition = houseCondition;
    }
}
