package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.CourseArrangeDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Mapper
@Component(value = "iCourseArrangeDao")
public interface ICourseArrangeDao {
    //添加课程安排
    void addCourseArrange(CourseArrangeDO courseArrangeDO);
    //教师查询课程安排
    List<CourseArrangeDO> getCourseArrangeByTeacherId(String teacherId);
    //查询课程的安排
    List<CourseArrangeDO> getCourseArrangeByCourseId(int CourseId);
    //修改课程安排
    void updateCourseArrange(CourseArrangeDO courseArrangeDO);
}
