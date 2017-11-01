package com.mo.base.entity;

import com.mo.base.utils.BidConst;

import java.math.BigDecimal;

/**
 * Created by Moonston on 2017/10/26.
 */
public class Account extends BaseEntity{

    private int version;//对象版本
    private String tradePassword;//交易密码

    private BigDecimal usableAmount = BidConst.ZERO;//账户可用余额
    private BigDecimal freezedAmount = BidConst.ZERO;//账户冻结金额
    private BigDecimal unReceiveInterest = BidConst.ZERO;//账户待收利息
    private BigDecimal unReceivePrincipal = BidConst.ZERO;//账户待收本金
    private BigDecimal unReturnAmount = BidConst.ZERO;//账户待还金额
    private BigDecimal borrowLimitAmount = BidConst.INIT_BORROW_LIMIT;//账户授信额度
    private BigDecimal remainBorrowLimit = BidConst.INIT_BORROW_LIMIT;//账户剩余授信额度

    private String verifyCode;// 做数据校验的

    //计算总金额=账户总额=可用金额+冻结金额+待收本金
    public BigDecimal getTotalAmount(){
        return usableAmount.add(this.freezedAmount).add(this.unReceivePrincipal);
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    //检查用户数据的正确性
    public boolean checkVerifyCode(){
        return false ;
    }


    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTradePassword() {
        return tradePassword;
    }

    public void setTradePassword(String tradePassword) {
        this.tradePassword = tradePassword;
    }

    public BigDecimal getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(BigDecimal usableAmount) {
        this.usableAmount = usableAmount;
    }

    public BigDecimal getFreezedAmount() {
        return freezedAmount;
    }

    public void setFreezedAmount(BigDecimal freezedAmount) {
        this.freezedAmount = freezedAmount;
    }

    public BigDecimal getUnReceiveInterest() {
        return unReceiveInterest;
    }

    public void setUnReceiveInterest(BigDecimal unReceiveInterest) {
        this.unReceiveInterest = unReceiveInterest;
    }

    public BigDecimal getUnReceivePrincipal() {
        return unReceivePrincipal;
    }

    public void setUnReceivePrincipal(BigDecimal unReceivePrincipal) {
        this.unReceivePrincipal = unReceivePrincipal;
    }

    public BigDecimal getUnReturnAmount() {
        return unReturnAmount;
    }

    public void setUnReturnAmount(BigDecimal unReturnAmount) {
        this.unReturnAmount = unReturnAmount;
    }

    public BigDecimal getBorrowLimitAmount() {
        return borrowLimitAmount;
    }

    public void setBorrowLimitAmount(BigDecimal borrowLimitAmount) {
        this.borrowLimitAmount = borrowLimitAmount;
    }

    public BigDecimal getRemainBorrowLimit() {
        return remainBorrowLimit;
    }

    public void setRemainBorrowLimit(BigDecimal remainBorrowLimit) {
        this.remainBorrowLimit = remainBorrowLimit;
    }
}
