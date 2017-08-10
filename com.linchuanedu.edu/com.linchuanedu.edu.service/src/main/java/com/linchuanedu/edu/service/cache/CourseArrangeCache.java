package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.CourseArrangeDO;
import com.linchuanedu.edu.dao.ICourseArrangeDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Component
public class CourseArrangeCache {

    @Resource
    private ICourseArrangeDao iCourseArrangeDao;

    public void orderCourse(CourseArrangeDO courseArrangeDO) {
        iCourseArrangeDao.addCourseArrange(courseArrangeDO);
    }

    public List<CourseArrangeDO> getCourseArrangeByTeacherId(String teacherId) {
        return iCourseArrangeDao.getCourseArrangeByTeacherId(teacherId);
    }

    public List<CourseArrangeDO> getCourseArrangeByCourseId(int CourseId) {
        return iCourseArrangeDao.getCourseArrangeByCourseId(CourseId);
    }

    public void updateCourseArrange(CourseArrangeDO courseArrangeDO){
        iCourseArrangeDao.updateCourseArrange(courseArrangeDO);
    }
}
