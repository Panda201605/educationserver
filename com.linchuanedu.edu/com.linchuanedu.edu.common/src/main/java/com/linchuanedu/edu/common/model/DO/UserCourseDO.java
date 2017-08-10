package com.linchuanedu.edu.common.model.DO;

/**
 * Created by pansp on 2017-8-10.
 */
public class UserCourseDO {
    private String userId;
    private Long courseId;
    private Integer deleteTag = 0;

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

    public Integer getDeleteTag() {
        return deleteTag;
    }

    public void setDeleteTag(Integer deleteTag) {
        this.deleteTag = deleteTag;
    }
}
