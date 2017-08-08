package com.linchuanedu.edu.common.model.DTO;

import com.linchuanedu.edu.common.util.Assert;

/**
 * Created by pansp on 2017-8-8.
 */
public class UpdateCourseDTO {
    private String userId;
    private Long courseId;
    private String courseName;
    private Long menberNumMax;
    private Integer enterable;
    private Integer isShow;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Long getMenberNumMax() {
        return menberNumMax;
    }

    public void setMenberNumMax(Long menberNumMax) {
        this.menberNumMax = menberNumMax;
    }

    public Integer getEnterable() {
        return enterable;
    }

    public void setEnterable(Integer enterable) {
        this.enterable = enterable;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public void checkValid(){
        Assert.assertNotEmpty(userId,"userId");
        Assert.assertNotEmpty(courseId.toString(),"courseId");
    }
}
