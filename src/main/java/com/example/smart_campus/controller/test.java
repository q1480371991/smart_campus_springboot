package com.example.smart_campus.controller;

import com.example.smart_campus.pojo.Classroom;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : test
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 13:46
 * @updateUser : Lin
 * @updateTime : 2023/11/17 13:46
 * @updateRemark : 描述说明本次修改内容
 */
@RestController
public class test {
    @RequestMapping(value = "test",method = RequestMethod.POST)
    public String test(@RequestBody Classroom classroom){
        System.out.println(classroom);
        return "111";
    }
}
