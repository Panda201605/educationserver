package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.CourseArrangeDO;
import com.linchuanedu.edu.common.model.DO.CourseDO;
import com.linchuanedu.edu.dao.ICourseDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pansp on 2017-8-7.
 */
@Component
public class CourseCache {

    @Resource
    private ICourseDao iCourseDao;

    public void createCourse(CourseDO courseDO){
        iCourseDao.createCourse(courseDO);
    }

    public void updateCourse(CourseDO courseDO){
        iCourseDao.updateCourse(courseDO);
    }

    public List<CourseDO> getCourse(CourseDO courseDO){
        return iCourseDao.getCourse(courseDO);
    }
}
