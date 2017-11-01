package com.mo.base.utils;

/**
 * Created by Moonston on 2017/10/26.
 */
public class JSONResult {
    private boolean success = true;
    private String msg ;

    public JSONResult(){
        super();
    }

    public JSONResult(String msg){
        super();
        this.msg = msg;
    }

    public JSONResult(Boolean success,String msg){
        super();
        this.success = success;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
