package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.GetCourseArrangeDTO;
import com.linchuanedu.edu.common.model.DTO.OrderCourseDTO;
import com.linchuanedu.edu.common.model.DTO.UpdateCourseArrangeDTO;
import com.linchuanedu.edu.common.model.VO.CourseArrangeVO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.CourseArrangeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/course/arrange")
public class CourseArrangeController extends AbstractController{

    @Resource
    private CourseArrangeService courseArrangeService;

    @RequestMapping(value = "/order", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse orderCourseArrange(HttpServletRequest request, @RequestBody OrderCourseDTO orderCourseDTO) {

        //校验参数
        orderCourseDTO.checkValid();

        courseArrangeService.orderCourse(orderCourseDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse getCourseArrange(HttpServletRequest request, @RequestBody GetCourseArrangeDTO getCourseArrangeDTO) {

        //校验参数
        getCourseArrangeDTO.checkValid();

        List<CourseArrangeVO> listData = courseArrangeService.getCourseArrange(getCourseArrangeDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(listData);
        return serverResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse updateCourseArrange(HttpServletRequest request, @RequestBody UpdateCourseArrangeDTO updateCourseArrangeDTO) {

        //校验参数
        updateCourseArrangeDTO.checkValid();

        courseArrangeService.updateCourseArrange(updateCourseArrangeDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }
}
