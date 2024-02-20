package com.MedicalSuppliesSystem.MedicalSupplies.pojos;

public class ResponsePojo {
    private boolean success;
    private String exceptionMessage;
    private Object data;

    public ResponsePojo(boolean success, String exceptionMessage, Object data) {
        this.success = success;
        this.exceptionMessage = exceptionMessage;
        this.data = data != null ? data : "";
    }

    public ResponsePojo() {
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public Object getData() {
        this.data = this.data != null ? this.data : "";
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
