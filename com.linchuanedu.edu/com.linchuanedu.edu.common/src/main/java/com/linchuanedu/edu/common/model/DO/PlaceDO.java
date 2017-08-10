package com.linchuanedu.edu.common.model.DO;

/**
 * Created by pansp on 2017-8-10.
 */
public class PlaceDO {
    private Integer placeId;
    private String placeName;
    private String address;
    private String room;
    private Integer capacity;
    private String createBy;
    private String modifyBy;
    private Long createTs;
    private Long modifyTs;

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Long getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Long createTs) {
        this.createTs = createTs;
    }

    public Long getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(Long modifyTs) {
        this.modifyTs = modifyTs;
    }
}
