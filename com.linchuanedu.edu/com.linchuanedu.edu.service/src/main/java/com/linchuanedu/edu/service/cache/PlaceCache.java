package com.linchuanedu.edu.service.cache;

import com.linchuanedu.edu.common.model.DO.PlaceDO;
import com.linchuanedu.edu.dao.IPlaceDao;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Component
public class PlaceCache {

    @Resource
    private IPlaceDao iPlaceDao;

    public void addPlace(PlaceDO placeDO){
        iPlaceDao.addPlace(placeDO);
    }

    public void updatePlace(PlaceDO placeDO){
        iPlaceDao.updatePlace(placeDO);
    }

    public List<PlaceDO> getPlace(int placeId){
        return iPlaceDao.getPlace(placeId);
    }
}
