package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.exception.AppException;
import com.linchuanedu.edu.common.exception.ErrorCode;
import com.linchuanedu.edu.common.model.DO.UserDO;
import com.linchuanedu.edu.common.model.DTO.Role;
import com.linchuanedu.edu.common.model.DTO.UserInfoDTO;
import com.linchuanedu.edu.common.model.VO.UserInfoVO;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.common.util.UserIdGen;
import com.linchuanedu.edu.service.cache.UserCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by pansp
 * Date: 2017-7-21
 * Time: 15:52
 */

@Service
public class UserService {

    @Resource
    private UserCache userCache;

    public void createUser(String phone, String password) {
        UserDO userDO = new UserDO();
        userDO.setPhone(phone);
        userDO.setPassword(password);
        //校验是否已存在
        if (userCache.checkUserByPhone(userDO) > 0) {
            throw new AppException(ErrorCode.USER_ALREADY_EXISTS);
        }

        long createTs = TimeUtil.getTimeStamp();
        String userId = UserIdGen.newUserId(createTs, phone);
        userDO.setUserId(userId);
        userDO.setCreateTs(createTs);
        userDO.setRole(Role.Student.getCode());

        userCache.createUser(userDO);
    }

    public String userLogin(String phone, String password) {
        UserDO userDO = userCache.getUserByPhone(phone);
        if(userDO == null || !password.equals(userDO.getPassword())){
            throw new AppException(ErrorCode.ACCOUNT_PASSWORD_INCORRECT);
        }

        return userDO.getUserId();

    }

    public UserInfoVO getUserInfo(String userId){
        UserDO userDO = userCache.getUserById(userId);
        if(userDO == null){
            throw new AppException(ErrorCode.ID_INCORRECT);
        }

        return buildUserInfo(userDO);

    }

    public void updateUserInfo(UserInfoDTO userInfoDTO){
        UserDO userDO = buildUserDO(userInfoDTO);
        userCache.updateUserInfo(userDO);
    }

    private UserInfoVO buildUserInfo(UserDO userDO){
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserId(userDO.getUserId());
        userInfoVO.setPhone(userDO.getPhone());
        userInfoVO.setRealName(userDO.getRealName());
        userInfoVO.setAge(userDO.getAge());
        userInfoVO.setSex(userDO.getSex());
        userInfoVO.setSchool(userDO.getSchool());
        userInfoVO.setAddress(userDO.getAddress());

        return userInfoVO;
    }

    private UserDO buildUserDO(UserInfoDTO userInfoDTO){
        UserDO userDO = new UserDO();
        userDO.setUserId(userInfoDTO.getUserId());
        userDO.setPhone(userInfoDTO.getPhone());
        userDO.setRealName(userInfoDTO.getRealName());
        userDO.setAge(userInfoDTO.getAge());
        userDO.setSex(userInfoDTO.getSex());
        userDO.setSchool(userInfoDTO.getSchool());
        userDO.setAddress(userInfoDTO.getAddress());
        return userDO;
    }
}
