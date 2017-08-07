package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;
import com.linchuanedu.edu.common.model.DO.CourseDO;
import com.linchuanedu.edu.common.model.DO.UserDO;
import com.linchuanedu.edu.common.model.DTO.CreateCourseDTO;
import com.linchuanedu.edu.common.model.DTO.Role;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.service.cache.CourseCache;
import com.linchuanedu.edu.service.cache.UserCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pansp on 2017-8-7.
 */
@Service
public class CourseService {

    @Resource
    private CourseCache courseCache;

    @Resource
    private UserCache userCache;

    public void createCourse(CreateCourseDTO createCourseDTO){
        String userId = createCourseDTO.getUserId();
        UserDO userDO = userCache.getUserById(userId);
        if(userDO == null){
            throw new AppException(ErrorCode.ID_INCORRECT);
        }

        CourseDO courseDO1 = null;

        switch (Role.getRoleByCode(userDO.getRole())){
            case Admin:
            case Manager:
                courseDO1 = ManagerBuildCourseDO(createCourseDTO);
                courseDO1.setType(1);
                break;
            case Student:
            case Teacher:
                throw new AppException(ErrorCode.PERMISSION_DENIED);
        }

        courseDO1.setCreateTs(TimeUtil.getTimeStamp());
        courseCache.createCourse(courseDO1);

    }

    public CourseDO ManagerBuildCourseDO(CreateCourseDTO createCourseDTO){
        CourseDO courseDO = new CourseDO();
        courseDO.setCourseName(createCourseDTO.getCourseName());
        courseDO.setMenberNumMax(createCourseDTO.getMenberNumMax());
        courseDO.setEnterable(createCourseDTO.getEnterable());
        courseDO.setIsShow(createCourseDTO.getIsShow());
        courseDO.setCreateBy(createCourseDTO.getUserId());
        return courseDO;
    }
}
