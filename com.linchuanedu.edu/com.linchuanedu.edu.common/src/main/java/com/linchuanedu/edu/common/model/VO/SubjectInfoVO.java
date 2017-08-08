package com.linchuanedu.edu.common.model.VO;

/**
 * Created by pansp on 2017-8-8.
 */
public class SubjectInfoVO {
    private Long subjectId;
    private String grade;
    private String subject;
    private Integer bookable;
    private String createBy;
    private String modifyBy;
    private Long createTs;
    private Long modifyTs;

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

    public Long getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Long createTs) {
        this.createTs = createTs;
    }

    public Long getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(Long modifyTs) {
        this.modifyTs = modifyTs;
    }
}
