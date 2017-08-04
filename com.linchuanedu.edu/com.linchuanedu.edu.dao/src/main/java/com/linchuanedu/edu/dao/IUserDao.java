package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DTO.RegisterUserDTO;
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
    void createUser(RegisterUserDTO createUserDTO);
}
