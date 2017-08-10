package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.CourseDO;
import com.linchuanedu.edu.common.model.DO.UserCourseDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Mapper
@Component(value = "iUserCourseDao")
public interface IUserCourseDao {
    //添加用户课程关系
    void addUserCourse(UserCourseDO userCourseDO);
    //删除用户课程关系
    void deleteUserCourse(UserCourseDO userCourseDO);
    //获取用户的课程信息
    List<Integer> getCourseByUserId(String UserId);

}
