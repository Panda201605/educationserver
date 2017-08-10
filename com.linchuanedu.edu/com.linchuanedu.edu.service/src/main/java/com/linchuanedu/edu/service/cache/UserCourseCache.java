package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.CourseDO;
import com.linchuanedu.edu.common.model.DO.UserCourseDO;
import com.linchuanedu.edu.dao.IUserCourseDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Component
public class UserCourseCache {

    @Resource
    private IUserCourseDao iUserCourseDao;

    public void addUserCourse(UserCourseDO userCourseDO){
        iUserCourseDao.addUserCourse(userCourseDO);
    }

    public void deleteUserCourse(UserCourseDO userCourseDO){
        iUserCourseDao.deleteUserCourse(userCourseDO);
    }

    public List<Integer> getCourseByUserId(String UserId){
        return iUserCourseDao.getCourseByUserId(UserId);
    }
}
