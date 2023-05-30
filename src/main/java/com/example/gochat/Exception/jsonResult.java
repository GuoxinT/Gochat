package com.example.gochat.Exception;


import com.example.gochat.Utility.util;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

public @Data class jsonResult {

    private String time_zone;
    private Date date;
    private Integer status;
    private String message;

    public jsonResult() {
        this.time_zone = "CCT";
        this.setDate(new Date());
    }
    public jsonResult(BaseErrorInfoInterface info) {
        this.time_zone = "CCT";
        this.status = util.Int(info.getResultStatus());
        this.message = info.getResultMsg();
    }
    public jsonResult(BaseErrorInfoInterface info, Integer code) {
        this.time_zone = "CCT";
        this.status = util.Int(info.getResultStatus());
        this.message = info.getResultMsg();
    }

    public void setInfo(BaseErrorInfoInterface info) {
        this.setMessage(info.getResultMsg());
        this.setStatus(util.Int(info.getResultStatus()));
    }

    public void setInfo(MyException info) {
        this.setMessage(info.getMessage());
        this.setStatus(util.Int(info.getErrorStatus()));
    }

    public static jsonResult success() {
        return success(null);
    }

    public static jsonResult success(String s) {
        jsonResult res = new jsonResult();
        res.setMessage(s == null ? "请求成功" : s);
        res.setStatus(util.Int(ExceptionEnum.SUCCESS.getResultStatus()));
        return res;
    }

    public static jsonResult error(BaseErrorInfoInterface info) {
        jsonResult res = new jsonResult();
        res.setInfo(info);
        return res;
    }

    public static jsonResult error(MyException info) {
        jsonResult res = new jsonResult();
        res.setInfo(info);
        return res;
    }

    public static jsonResult error(Integer status, String info) {
        jsonResult res = new jsonResult();
        res.setStatus(status);
        res.setMessage(info);
        return res;
    }
}

