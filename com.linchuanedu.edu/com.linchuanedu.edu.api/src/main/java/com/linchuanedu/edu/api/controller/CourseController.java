package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.CreateCourseDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.CourseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

}
