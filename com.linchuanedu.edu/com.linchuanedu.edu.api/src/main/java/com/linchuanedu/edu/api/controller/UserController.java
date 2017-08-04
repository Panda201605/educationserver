package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.RegisterUserDTO;
import com.linchuanedu.edu.common.model.DTO.UserInfoDTO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.common.model.VO.UserInfoVO;
import com.linchuanedu.edu.service.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

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

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse userRegister(HttpServletRequest request, @RequestBody RegisterUserDTO registerUserDTO) {

        // 校验参数
        registerUserDTO.checkValid();

        userService.createUser(registerUserDTO.getPhone(),registerUserDTO.getPassword());

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/login")
    public ServerResponse userLogin(HttpServletRequest request, @RequestBody RegisterUserDTO registerUserDTO){
        //校验参数
        registerUserDTO.checkValid();

        String userId = userService.userLogin(registerUserDTO.getPhone(),registerUserDTO.getPassword());

        //返回
        Map<String,String> data = new HashMap<>();
        data.put("userId",userId);
        ServerResponse serverResponse = ServerResponse.successWithData(data);
        return serverResponse;
    }

    @RequestMapping(value = "/get")
    public ServerResponse getUserInfo(HttpServletRequest request, @RequestBody UserInfoDTO userInfoDTO){
        //校验参数
        userInfoDTO.checkValid();

        UserInfoVO userInfoVO = userService.getUserInfo(userInfoDTO.getUserId());

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(userInfoVO);
        return serverResponse;
    }

    @RequestMapping(value = "/info/update")
    public void updateUserInfo(HttpServletRequest request, @RequestBody UserInfoDTO userInfoDTO){
        //校验参数
        userInfoDTO.checkValid();

        userService.updateUserInfo(userInfoDTO);

    }

}
