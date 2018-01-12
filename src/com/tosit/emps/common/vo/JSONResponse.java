package com.tosit.emps.common.vo;

public class JSONResponse {
    private boolean success;
    private Object data;

    public JSONResponse() {
    }

    public JSONResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
