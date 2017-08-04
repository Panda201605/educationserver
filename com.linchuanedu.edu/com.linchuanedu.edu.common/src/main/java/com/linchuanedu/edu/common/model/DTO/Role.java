package com.linchuanedu.edu.common.model.DTO;

/**
 * Created by pansp on 2017-8-4.
 */
public enum Role {
    Admin(0, "admin"),
    Manager(1, "manager"),
    Teacher(2, "teacher"),
    Student(3, "student");

    Role(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static Role getRoleByCode(int code) {
        for (Role c : Role.values()) {
            if (code == c.getCode()) {
                return c;
            }
        }
        return null;
    }

    public Role getRoleByMsg(String msg) {
        for (Role c : Role.values()) {
            if (msg.equals(c.getMsg())) {
                return c;
            }
        }
        return null;
    }
}
