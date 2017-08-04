package com.linchuanedu.edu.common.model.DTO;

import com.linchuanedu.edu.common.util.Assert;

/**
 * Created by pansp
 * Date: 2017-7-21
 * Time: 16:21
 */

public class RegisterUserDTO {

    private String phone;
    private String password;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void checkValid(){
        Assert.assertNotEmpty(phone,"phone");
        Assert.assertNotEmpty(password,"password");
    }
}
