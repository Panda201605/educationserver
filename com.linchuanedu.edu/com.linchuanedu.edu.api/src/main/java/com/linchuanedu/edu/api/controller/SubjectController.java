package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.GetSubjectDTO;
import com.linchuanedu.edu.common.model.DTO.AddSubjectInfoDTO;
import com.linchuanedu.edu.common.model.DTO.UpdateSubjectDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.common.model.VO.SubjectInfoVO;
import com.linchuanedu.edu.service.service.SubjectService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pansp on 2017-8-8.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/subject")
public class SubjectController extends AbstractController{

    @Resource
    private SubjectService subjectService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse addSubject(HttpServletRequest request, @RequestBody AddSubjectInfoDTO addSubjectInfoDTO) {
        //校验参数
        addSubjectInfoDTO.checkValid();

        subjectService.addSubject(addSubjectInfoDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse getSubject(HttpServletRequest request, @RequestBody GetSubjectDTO getSubjectDTO) {
        //校验参数
        getSubjectDTO.checkValid();

        List<SubjectInfoVO> listData = subjectService.getSubject(getSubjectDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(listData);
        return serverResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse updateSubject(HttpServletRequest request, @RequestBody UpdateSubjectDTO updateSubjectDTO) {
        //校验参数
        updateSubjectDTO.checkValid();

        subjectService.updateSubject(updateSubjectDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }
}
