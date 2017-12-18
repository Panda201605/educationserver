package com.linchuanedu.edu.api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by pansp on 2017-12-18.
 */
@RestController
@RequestMapping(value = "/v1/edu/app/test")
public class TestController {

    @RequestMapping(value = "/ac")
    public void testAC(HttpServletRequest request, HttpServletResponse response, @RequestBody Map<String, String> param) {

    }
}
