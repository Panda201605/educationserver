package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.UserCourseDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.UserCourseService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pansp on 2017-8-10.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/course")
public class UserCourseController {

    @Resource
    private UserCourseService userCourseService;

    @RequestMapping(value = "/join", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse getCourse(HttpServletRequest request, @RequestBody UserCourseDTO userCourseDTO) {

        //校验参数
        userCourseDTO.checkValid();

        userCourseService.joinCourse(userCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/quit", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse quitCourse(HttpServletRequest request, @RequestBody UserCourseDTO userCourseDTO) {

        //校验参数
        userCourseDTO.checkValid();

        userCourseService.quitCourse(userCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

}
