package com.linchuanedu.edu.api.controller;

import com.linchuanedu.edu.common.model.DTO.AddPlaceDTO;
import com.linchuanedu.edu.common.model.DTO.GetPlaceDTO;
import com.linchuanedu.edu.common.model.DTO.UpdatePlaceDTO;
import com.linchuanedu.edu.common.model.VO.PlaceVO;
import com.linchuanedu.edu.common.model.VO.ServerResponse;
import com.linchuanedu.edu.service.service.PlaceService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by pansp on 2017-8-10.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/place")
public class PlaceController extends AbstractController{

    @Resource
    private PlaceService placeService;

    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse addPlace(HttpServletRequest request, @RequestBody AddPlaceDTO addPlaceDTO) {

        //校验参数
        addPlaceDTO.checkValid();

        placeService.addPlace(addPlaceDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse updatePlace(HttpServletRequest request, @RequestBody UpdatePlaceDTO  updatePlaceDTO) {

        //校验参数
        updatePlaceDTO.checkValid();

        placeService.updatePlace(updatePlaceDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(null);
        return serverResponse;
    }

    @RequestMapping(value = "/get", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
    public ServerResponse getPlace(HttpServletRequest request, @RequestBody GetPlaceDTO getPlaceDTO) {

        //校验参数
        getPlaceDTO.checkValid();

        List<PlaceVO> listData = placeService.getPlace(getPlaceDTO);

        //返回
        ServerResponse serverResponse = ServerResponse.successWithData(listData);
        return serverResponse;
    }
}
