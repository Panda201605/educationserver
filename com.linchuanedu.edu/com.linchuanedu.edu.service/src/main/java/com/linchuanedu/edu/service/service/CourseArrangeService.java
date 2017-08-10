package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.model.DO.CourseArrangeDO;
import com.linchuanedu.edu.common.model.DTO.GetCourseArrangeDTO;
import com.linchuanedu.edu.common.model.DTO.OrderCourseDTO;
import com.linchuanedu.edu.common.model.DTO.Role;
import com.linchuanedu.edu.common.model.DTO.UpdateCourseArrangeDTO;
import com.linchuanedu.edu.common.model.VO.CourseArrangeVO;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.service.cache.CourseArrangeCache;
import com.linchuanedu.edu.service.cache.UserCourseCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Service
public class CourseArrangeService {

    @Resource
    private CourseArrangeCache courseArrangeCache;

    @Resource
    private UserCourseCache userCourseCache;

    public void orderCourse(OrderCourseDTO orderCourseDTO) {
        CourseArrangeDO courseArrangeDO = buildCourseArrangeDO(orderCourseDTO);
        courseArrangeCache.orderCourse(courseArrangeDO);
    }

    public List<CourseArrangeVO> getCourseArrange(GetCourseArrangeDTO getCourseArrangeDTO) {
        String userId = getCourseArrangeDTO.getUserId();
        int role = getCourseArrangeDTO.getRole();

        List<CourseArrangeDO> listCourseArrange = new ArrayList<>();

        switch (Role.getRoleByCode(role)) {
            case Admin:
            case Manager:
            case Teacher:
                listCourseArrange = courseArrangeCache.getCourseArrangeByTeacherId(userId);
                break;
            case Student:
                List<Integer> listCourseId = userCourseCache.getCourseByUserId(userId);
                for (int CourseId : listCourseId) {
                    List<CourseArrangeDO> listTmp = courseArrangeCache.getCourseArrangeByCourseId(CourseId);
                    listCourseArrange.addAll(listTmp);
                }
        }

        return buildListCourseArrangeVO(listCourseArrange);


    }

    public void updateCourseArrange(UpdateCourseArrangeDTO updateCourseArrangeDTO) {
        CourseArrangeDO courseArrangeDO = buildCourseArrangeDO(updateCourseArrangeDTO);
        courseArrangeCache.updateCourseArrange(courseArrangeDO);
    }

    private CourseArrangeDO buildCourseArrangeDO(OrderCourseDTO orderCourseDTO) {
        CourseArrangeDO courseArrangeDO = new CourseArrangeDO();
        courseArrangeDO.setCourseId(orderCourseDTO.getCourseId());
        courseArrangeDO.setSubjectId(orderCourseDTO.getSubjectId());
        courseArrangeDO.setTeacherId(orderCourseDTO.getTeacherId());
        courseArrangeDO.setPlaceId(orderCourseDTO.getPlaceId());
        courseArrangeDO.setYear(orderCourseDTO.getYear());
        courseArrangeDO.setMonth(orderCourseDTO.getMonth());
        courseArrangeDO.setDay(orderCourseDTO.getDay());
        courseArrangeDO.setStartTime(orderCourseDTO.getStartTime());
        courseArrangeDO.setEndTime(orderCourseDTO.getEndTime());
        courseArrangeDO.setCreateBy(orderCourseDTO.getUserId());
        courseArrangeDO.setCreateTs(TimeUtil.getTimeStamp());
        return courseArrangeDO;
    }

    private List<CourseArrangeVO> buildListCourseArrangeVO(List<CourseArrangeDO> listCourseArrange) {
        List<CourseArrangeVO> listCourseArrangeVO = new ArrayList<>();

        for (CourseArrangeDO courseArrangeDO : listCourseArrange) {
            CourseArrangeVO courseArrangeVO = new CourseArrangeVO();

            courseArrangeVO.setCourseArrangeId(courseArrangeDO.getCourseArrangeId());
            courseArrangeVO.setCourseId(courseArrangeDO.getCourseId());
            courseArrangeVO.setSubjectId(courseArrangeDO.getSubjectId());
            courseArrangeVO.setTeacherId(courseArrangeDO.getTeacherId());
            courseArrangeVO.setPlaceId(courseArrangeDO.getPlaceId());
            courseArrangeVO.setYear(courseArrangeDO.getYear());
            courseArrangeVO.setMonth(courseArrangeDO.getYear());
            courseArrangeVO.setDay(courseArrangeDO.getDay());
            courseArrangeVO.setStartTime(courseArrangeDO.getStartTime());
            courseArrangeVO.setEndTime(courseArrangeDO.getEndTime());

            listCourseArrangeVO.add(courseArrangeVO);
        }

        return listCourseArrangeVO;
    }

    private CourseArrangeDO buildCourseArrangeDO(UpdateCourseArrangeDTO updateCourseArrangeDTO) {
        CourseArrangeDO courseArrangeDO = new CourseArrangeDO();
        courseArrangeDO.setCourseId(updateCourseArrangeDTO.getCourseId());
        courseArrangeDO.setSubjectId(updateCourseArrangeDTO.getSubjectId());
        courseArrangeDO.setTeacherId(updateCourseArrangeDTO.getTeacherId());
        courseArrangeDO.setPlaceId(updateCourseArrangeDTO.getPlaceId());
        courseArrangeDO.setYear(updateCourseArrangeDTO.getYear());
        courseArrangeDO.setMonth(updateCourseArrangeDTO.getMonth());
        courseArrangeDO.setDay(updateCourseArrangeDTO.getDay());
        courseArrangeDO.setStartTime(updateCourseArrangeDTO.getStartTime());
        courseArrangeDO.setEndTime(updateCourseArrangeDTO.getEndTime());
        courseArrangeDO.setModifyBy(updateCourseArrangeDTO.getUserId());
        courseArrangeDO.setModifyTs(TimeUtil.getTimeStamp());
        return courseArrangeDO;
    }

}
