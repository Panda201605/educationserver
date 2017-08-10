package com.linchuanedu.edu.dao;

import com.linchuanedu.edu.common.model.DO.PlaceDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Mapper
@Component(value = "iPlaceDao")
public interface IPlaceDao {
    //添加场地信息
    void addPlace(PlaceDO placeDO);
    //修改场地信息
    void updatePlace(PlaceDO placeDO);
    //获取场地信息
    List<PlaceDO> getPlace(int placeId);
}
