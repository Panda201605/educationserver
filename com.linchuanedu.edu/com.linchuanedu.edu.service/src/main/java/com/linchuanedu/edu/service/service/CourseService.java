package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;
import com.linchuanedu.edu.common.model.DO.CourseDO;
import com.linchuanedu.edu.common.model.DO.UserDO;
import com.linchuanedu.edu.common.model.DTO.*;
import com.linchuanedu.edu.common.model.VO.CourseInfoVO;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.service.cache.CourseCache;
import com.linchuanedu.edu.service.cache.UserCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pansp on 2017-8-7.
 */
@Service
public class CourseService {

    @Resource
    private CourseCache courseCache;

    @Resource
    private UserCache userCache;


    private final String PATTERN = "yyyy-MM-dd HH:mm";
    private final int COURSE_TYPE_MANAGER_CREATE = 1;

    public void createCourse(CreateCourseDTO createCourseDTO) {
        String userId = createCourseDTO.getUserId();
        if (!checkPermission(userId)) {
            throw new AppException(ErrorCode.INVALID_PARAMETER);
        }

        CourseDO courseDO = buildCourseDO(createCourseDTO);
        courseDO.setType(COURSE_TYPE_MANAGER_CREATE);
        courseDO.setCreateTs(TimeUtil.getTimeStamp());
        courseCache.createCourse(courseDO);

    }

    public void updateCourse(UpdateCourseDTO updateCourseDTO) {
        String userId = updateCourseDTO.getUserId();
        if (!checkPermission(userId)) {
            throw new AppException(ErrorCode.INVALID_PARAMETER);
        }

        CourseDO courseDO = buildCourseDO(updateCourseDTO);
        courseDO.setCreateTs(TimeUtil.getTimeStamp());
        courseCache.updateCourse(courseDO);
    }

    public List<CourseInfoVO> getCourse(GetCourseDTO getCourseDTO) {
        CourseDO courseDO = new CourseDO();
        courseDO.setEnterable(getCourseDTO.getEnterable());
        courseDO.setIsShow(getCourseDTO.getIsShow());
        courseDO.setType(COURSE_TYPE_MANAGER_CREATE);

        List<CourseDO> listCourseDO = courseCache.getCourse(courseDO);
        List<CourseInfoVO> listCourseInfoVO = new ArrayList<>();

        for (CourseDO course : listCourseDO) {
            CourseInfoVO courseInfoVO = new CourseInfoVO();
            buildCourseInfoVO(course, courseInfoVO);
            listCourseInfoVO.add(courseInfoVO);
        }

        return listCourseInfoVO;
    }



    private CourseDO buildCourseDO(CreateCourseDTO createCourseDTO) {
        CourseDO courseDO = new CourseDO();
        courseDO.setCourseName(createCourseDTO.getCourseName());
        courseDO.setMenberNumMax(createCourseDTO.getMenberNumMax());
        courseDO.setEnterable(createCourseDTO.getEnterable());
        courseDO.setIsShow(createCourseDTO.getIsShow());
        courseDO.setCreateBy(createCourseDTO.getUserId());
        return courseDO;
    }

    private CourseDO buildCourseDO(UpdateCourseDTO updateCourseDTO) {
        CourseDO courseDO = new CourseDO();
        courseDO.setCourseId(updateCourseDTO.getCourseId());
        courseDO.setCourseName(updateCourseDTO.getCourseName());
        courseDO.setMenberNumMax(updateCourseDTO.getMenberNumMax());
        courseDO.setEnterable(updateCourseDTO.getEnterable());
        courseDO.setIsShow(updateCourseDTO.getIsShow());
        courseDO.setModifyBy(updateCourseDTO.getUserId());
        return courseDO;
    }

    private void buildCourseInfoVO(CourseDO courseDO, CourseInfoVO courseInfoVO) {
        courseInfoVO.setCourseId(courseDO.getCourseId());
        courseInfoVO.setCourseName(courseDO.getCourseName());
        courseInfoVO.setMenberNumMax(courseDO.getMenberNumMax());
        courseInfoVO.setEnterable(courseDO.getEnterable());
        courseInfoVO.setIsShow(courseDO.getIsShow());
        courseInfoVO.setCreateBy(courseDO.getCreateBy());
        courseInfoVO.setModifyBy(courseDO.getModifyBy());
        courseInfoVO.setCreateTs(TimeUtil.timeStampToDate(courseDO.getCreateTs(), PATTERN));
        if (courseDO.getModifyTs() != null) {
            courseInfoVO.setModifyTs(TimeUtil.timeStampToDate(courseDO.getModifyTs(), PATTERN));
        }

    }

    private boolean checkPermission(String userId) {
        UserDO userDO = userCache.getUserById(userId);
        if (userDO == null) {
            throw new AppException(ErrorCode.ID_INCORRECT);
        }

        switch (Role.getRoleByCode(userDO.getRole())) {
            case Admin:
            case Manager:
                return true;
            case Student:
            case Teacher:
                return false;
        }

        return true;
    }

}
