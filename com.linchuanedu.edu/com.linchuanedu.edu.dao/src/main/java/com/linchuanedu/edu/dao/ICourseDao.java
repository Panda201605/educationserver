package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.CourseDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by pansp on 2017-8-7.
 */
@Mapper
@Component(value = "iCourseDao")
public interface ICourseDao {
    //创建课程
    void createCourse(CourseDO courseDO);
}
