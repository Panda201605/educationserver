package com.linchuanedu.edu.service.service;

import com.linchuanedu.edu.common.model.DO.PlaceDO;
import com.linchuanedu.edu.common.model.DTO.AddPlaceDTO;
import com.linchuanedu.edu.common.model.DTO.GetPlaceDTO;
import com.linchuanedu.edu.common.model.DTO.UpdatePlaceDTO;
import com.linchuanedu.edu.common.model.VO.PlaceVO;
import com.linchuanedu.edu.common.util.TimeUtil;
import com.linchuanedu.edu.service.cache.PlaceCache;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@Service
public class PlaceService {

    @Resource
    private PlaceCache placeCache;

    public void addPlace(AddPlaceDTO addPlaceDTO){
        PlaceDO placeDO = buildPlaceDO(addPlaceDTO);
        placeCache.addPlace(placeDO);
    }

    public void updatePlace(UpdatePlaceDTO updatePlaceDTO){
        PlaceDO placeDO = buildPlaceDO(updatePlaceDTO);
        placeCache.updatePlace(placeDO);
    }

    public List<PlaceVO> getPlace(GetPlaceDTO getPlaceDTO){
        int placeId = getPlaceDTO.getPlaceId();
        List<PlaceDO> listPlaceDO = placeCache.getPlace(placeId);

        return buildListPlaceVO(listPlaceDO);
    }

    private PlaceDO buildPlaceDO(AddPlaceDTO addPlaceDTO){
        PlaceDO placeDO = new PlaceDO();
        placeDO.setPlaceName(addPlaceDTO.getPlaceName());
        placeDO.setAddress(addPlaceDTO.getAddress());
        placeDO.setRoom(addPlaceDTO.getRoom());
        placeDO.setCapacity(addPlaceDTO.getCapacity());
        placeDO.setCreateBy(addPlaceDTO.getUserId());
        placeDO.setCreateTs(TimeUtil.getTimeStamp());
        return placeDO;
    }

    private PlaceDO buildPlaceDO(UpdatePlaceDTO updatePlaceDTO){
        PlaceDO placeDO = new PlaceDO();
        placeDO.setPlaceName(updatePlaceDTO.getPlaceName());
        placeDO.setAddress(updatePlaceDTO.getAddress());
        placeDO.setRoom(updatePlaceDTO.getRoom());
        placeDO.setCapacity(updatePlaceDTO.getCapacity());
        placeDO.setModifyBy(updatePlaceDTO.getUserId());
        placeDO.setModifyTs(TimeUtil.getTimeStamp());
        return placeDO;
    }

    private List<PlaceVO> buildListPlaceVO(List<PlaceDO> listPlaceDO){
        List<PlaceVO> listPlaceVO = new ArrayList<>();

        for (PlaceDO placeDO : listPlaceDO){
            PlaceVO placeVO = new PlaceVO();
            placeVO.setPlaceId(placeDO.getPlaceId());
            placeVO.setPlaceName(placeDO.getPlaceName());
            placeVO.setAddress(placeDO.getAddress());
            placeVO.setRoom(placeDO.getRoom());
            placeVO.setCapacity(placeDO.getCapacity());
            listPlaceVO.add(placeVO);
        }

        return listPlaceVO;
    }
}
