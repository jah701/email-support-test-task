package com.email.support.model;

public class Line {
    private String serviceId;
    private String questionType;
    private String responseType;
    private String date;

    public Line() {
    }

    public Line(String serviceId, String questionType, String responseType, String date) {
        this.serviceId = serviceId;
        this.questionType = questionType;
        this.responseType = responseType;
        this.date = date;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
