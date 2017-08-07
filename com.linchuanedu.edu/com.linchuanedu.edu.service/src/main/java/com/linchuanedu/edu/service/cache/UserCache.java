package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.UserDO;
import com.linchuanedu.edu.dao.IUserDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Created by pansp
 * Date: 2017-7-21
 * Time: 15:52
 */

@Component
public class UserCache {

    @Resource
    private IUserDao iUserDao;

    public void createUser(UserDO userDO){
        iUserDao.createUser(userDO);
    }

    public int checkUserByPhone(UserDO userDO){
        return iUserDao.checkUserByPhone(userDO);
    }

    public UserDO getUserByPhone(String phone){
        return iUserDao.queryUserByPhone(phone);
    }

    public UserDO getUserById(String userId){
        return iUserDao.queryUserById(userId);
    }

    public void updateUserInfo(UserDO userDO){
        iUserDao.updateUserInfo(userDO);
    }

    public void updatePwd(UserDO userDO){
        iUserDao.updatePwd(userDO);
    }
}
