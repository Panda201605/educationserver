package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by pansp
 * Date: 2017-7-23
 * Time: 10:20
 */

@Mapper
@Component(value = "iUserDao")
public interface IUserDao {
    //创建用户
    void createUser(UserDO userDO);
    //查询用户是否存在
    int checkUserByPhone(UserDO userDO);
    //通过手机号获取用户信息
    UserDO queryUserByPhone(String phone);
    //通过id获取用户信息
    UserDO queryUserById(String userId);
    //修改用户信息
    void updateUserInfo(UserDO userDO);
}
