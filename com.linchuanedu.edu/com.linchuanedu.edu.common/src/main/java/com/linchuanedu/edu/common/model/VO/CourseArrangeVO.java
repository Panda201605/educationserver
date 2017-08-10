package com.linchuanedu.edu.common.model.VO;

/**
 * Created by pansp on 2017-8-10.
 */
public class CourseArrangeVO {
    private Integer courseArrangeId;
    private Integer courseId;
    private Integer subjectId;
    private String teacherId;
    private Integer placeId;
    private String year;
    private String month;
    private String day;
    private String startTime;
    private String endTime;

    public Integer getCourseArrangeId() {
        return courseArrangeId;
    }

    public void setCourseArrangeId(Integer courseArrangeId) {
        this.courseArrangeId = courseArrangeId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
