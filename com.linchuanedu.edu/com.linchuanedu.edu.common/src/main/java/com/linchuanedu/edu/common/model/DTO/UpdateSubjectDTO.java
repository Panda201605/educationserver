package com.linchuanedu.edu.common.model.DTO;

import com.linchuanedu.edu.common.util.Assert;

/**
 * Created by pansp on 2017-8-8.
 */
public class UpdateSubjectDTO {
    private String userId;
    private Long subjectId;
    private String grade;
    private String subject;
    private Integer bookable;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getBookable() {
        return bookable;
    }

    public void setBookable(Integer bookable) {
        this.bookable = bookable;
    }

    public void checkValid(){
        Assert.assertNotEmpty(userId,"userId");
        Assert.assertNotEmpty(subjectId.toString(),"subjectId");
    }
}
