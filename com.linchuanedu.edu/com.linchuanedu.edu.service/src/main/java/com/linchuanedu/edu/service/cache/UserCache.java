package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DTO.RegisterUserDTO;
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

    public void createUser(RegisterUserDTO createUserDTO){
        iUserDao.createUser(createUserDTO);
    }
}
