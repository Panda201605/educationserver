package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;
import com.linchuanedu.edu.common.model.DTO.CreateUserDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pansp
 * Date: 2017-7-21
 * Time: 15:52
 */

@RestController
@RequestMapping(value = "/v1/edu/app/user")
public class UserController extends AbstractController{

    @Resource
    private UserService userService;

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse userSignIn(HttpServletRequest request, @RequestBody CreateUserDTO createUserDTO) {

        // TODO: 2017/7/22 校验参数

        String phone = createUserDTO.getPhone();
        String password = createUserDTO.getPassword();
        userService.createUser(createUserDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;

    }

}
