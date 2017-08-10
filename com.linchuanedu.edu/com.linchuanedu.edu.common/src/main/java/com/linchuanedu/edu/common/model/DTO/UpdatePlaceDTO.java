package com.linchuanedu.edu.common.model.DTO;

import com.linchuanedu.edu.common.util.Assert;

/**
 * Created by pansp on 2017-8-10.
 */
public class UpdatePlaceDTO {
    private Integer placeId;
    private String userId;
    private String placeName;
    private String address;
    private String room;
    private Integer capacity;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public void checkValid(){
        Assert.assertNotEmpty(placeId.toString(),"placeId");
        Assert.assertNotEmpty(userId,"userId");
    }
}
