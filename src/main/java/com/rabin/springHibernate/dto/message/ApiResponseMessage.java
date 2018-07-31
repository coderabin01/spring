package com.rabin.springHibernate.dto.message;

public class ApiResponseMessage {
    private String message;
    private String code;

    public ApiResponseMessage(){ }

    public ApiResponseMessage(String message){
        this.message=message;
    }

    public ApiResponseMessage(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
