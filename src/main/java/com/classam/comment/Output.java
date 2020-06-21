package com.classam.comment;

public class Output {
    public static final String MSG_SUCCESS = "success";
    public static final String MSG_FAIL = "fail";
    public static final int STATUS_SUCCESS = 0;
    public static final int STATUS_FAIL = -1;
    public static final int STATUS_POSITIVE_ONE=1;

    /**
     * 返回的状态码 0 正常，-1异常
     */
    private int status = STATUS_SUCCESS;

    /**
     * 返回信息
     */
    private String msg;

    private Object data;

    public Output() {
    }

    public Output(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Output(Object data) {
        this.data = data;
        this.status = 0;
        this.msg = MSG_SUCCESS;
    }

    public Output(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
