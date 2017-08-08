package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.CreateCourseDTO;
import com.linchuanedu.edu.common.model.DTO.GetCourseDTO;
import com.linchuanedu.edu.common.model.DTO.UpdateCourseDTO;
import com.linchuanedu.edu.common.model.VO.CourseInfoVO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.CourseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pansp on 2017-8-7.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/course")
public class CourseController extends AbstractController {

    @Resource
    private CourseService courseService;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse createCourse(HttpServletRequest request, @RequestBody CreateCourseDTO createCourseDTO) {
        //校验参数
        createCourseDTO.checkValid();

        courseService.createCourse(createCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse updateCourse(HttpServletRequest request, @RequestBody UpdateCourseDTO updateCourseDTO) {
        //校验参数
        updateCourseDTO.checkValid();

        courseService.updateCourse(updateCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse getCourse(HttpServletRequest request, @RequestBody GetCourseDTO getCourseDTO) {

        List<CourseInfoVO> listData =  courseService.getCourse(getCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(listData);
        return serverResponse;
    }
}
