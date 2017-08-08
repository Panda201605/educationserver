package com.linchuanedu.edu.common.model.VO;

/**
 * Created by pansp on 2017-8-8.
 */
public class CourseInfoVO {
    private Long courseId;
    private String courseName;
    private Long menberNumMax;
    private Integer enterable;
    private Integer isShow;
    private String createBy;
    private String modifyBy;
    private String createTs;
    private String modifyTs;

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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getCreateTs() {
        return createTs;
    }

    public void setCreateTs(String createTs) {
        this.createTs = createTs;
    }

    public String getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(String modifyTs) {
        this.modifyTs = modifyTs;
    }
}
