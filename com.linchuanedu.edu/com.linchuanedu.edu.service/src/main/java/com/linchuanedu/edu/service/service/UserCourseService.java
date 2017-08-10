package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.model.DO.UserCourseDO;
import com.linchuanedu.edu.common.model.DTO.UserCourseDTO;
import com.linchuanedu.edu.service.cache.UserCourseCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pansp on 2017-8-10.
 */
@Service
public class UserCourseService {

    @Resource
    private UserCourseCache userCourseCache;

    private final int USER_COURSE_DELETE_FLAG = 1;

    public void joinCourse(UserCourseDTO userCourseDTO){
        String[] userIds = userCourseDTO.getUserIds().split(",");
        long courseId = userCourseDTO.getCourseId();

        for (String userId : userIds){
            UserCourseDO userCourseDO = bulidUserCourseDO(userId,courseId);
            userCourseCache.addUserCourse(userCourseDO);
        }
    }

    public void quitCourse(UserCourseDTO userCourseDTO){
        String[] userIds = userCourseDTO.getUserIds().split(",");
        long courseId = userCourseDTO.getCourseId();

        for (String userId : userIds){
            UserCourseDO userCourseDO = bulidUserCourseDO(userId,courseId);
            userCourseDO.setDeleteTag(USER_COURSE_DELETE_FLAG);
            userCourseCache.deleteUserCourse(userCourseDO);
        }
    }

    private UserCourseDO bulidUserCourseDO(String userId,long courseId){
        UserCourseDO userCourseDO = new UserCourseDO();
        userCourseDO.setUserId(userId);
        userCourseDO.setCourseId(courseId);
        return userCourseDO;
    }
}
