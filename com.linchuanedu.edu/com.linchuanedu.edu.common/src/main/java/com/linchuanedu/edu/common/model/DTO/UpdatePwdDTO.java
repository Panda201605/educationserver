package com.linchuanedu.edu.common.model.DTO;

import com.linchuanedu.edu.common.util.Assert;

/**
 * Created by pansp on 2017-8-7.
 */
public class UpdatePwdDTO {
    private String userId;
    private String oldPwd;
    private String newPwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public void checkValid(){
        Assert.assertNotEmpty(userId,"userId");
        Assert.assertNotEmpty(oldPwd,"oldPwd");
        Assert.assertNotEmpty(newPwd,"newPwd");
    }
}
