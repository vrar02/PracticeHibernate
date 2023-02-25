package com.vivek.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {

    private String course;
    private String result;

    public Certificate() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
