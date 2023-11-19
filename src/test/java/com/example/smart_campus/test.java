package com.example.smart_campus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.smart_campus.mapper.classroomMapper;
import com.example.smart_campus.pojo.Classroom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : test
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 18:03
 * @updateUser : Lin
 * @updateTime : 2023/11/17 18:03
 * @updateRemark : 描述说明本次修改内容
 */
@SpringBootTest
public class test {

    @Autowired
    private classroomMapper classroommapper;

    @Test
    public void test1(){
//        String starttime="2023-11-17 18:00:00";
//        String endtime="2023-11-17 19:00:00";
        String starttime=null;
        String endtime=null;
//        ArrayList<Classroom> classrooms = classroommapper.listClassroomByTime(starttime, endtime);
//        System.out.println(classrooms);

        LambdaQueryWrapper<Classroom> lqw = new LambdaQueryWrapper<Classroom>();
        lqw.gt(Classroom::getEndtime, endtime)
                .lt(Classroom::getStarttime, starttime)
                .eq(Classroom::getAvailability,1);
        List<Classroom> classrooms = classroommapper.selectList(lqw);
        System.out.println(classrooms);
    }
    @Test
    public void test2(){
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();

        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 格式化当前时间为字符串
        String time = currentTime.format(formatter);
        System.out.println(time);
    }
}
