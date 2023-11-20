package com.example.smart_campus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.smart_campus.mapper.*;
import com.example.smart_campus.pojo.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.text.ParseException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : userController
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 14:48
 * @updateUser : Lin
 * @updateTime : 2023/11/17 14:48
 * @updateRemark : 描述说明本次修改内容
 */
@RestController
public class userController {

    @Autowired
    private com.example.smart_campus.mapper.userMapper usermapper;
    @Autowired
    private memoMapper memomapper;
    @Autowired
    private course_selectionMapper course_selection_mapper;
    @Autowired
    private courseMapper coursemapper;
    @Autowired
    private announcementMapper announcementmapper;
    @Autowired
    private feedbackMapper feedbackmapper;
    @Autowired
    private reservationMapper reservationmapper;
    @Autowired
    private classroomMapper classroommapper;
    //登录
    @PostMapping("/login")
    public R login(@RequestBody Map<String,Object> data){
        String username = (String) data.get("username");
        String password = (String) data.get("password");
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        lqw.eq(User::getUsername,username);
        User user = usermapper.selectOne(lqw);
        if (user.getPassword().equals(password)){
            user.setPassword(null);
            return R.ok(user);
        }

        return R.fail("密码错误或账号不存在");
    };

    //修改密码
    @PostMapping("/changePassword")
    public R changePassword(@RequestBody Map<String,Object> data){
        Integer userid = (Integer) data.get("userid");
        String oldpassword = (String) data.get("oldpassword");
        String newpassword = (String) data.get("newpassword");
        User user = usermapper.selectById(userid);
        if (user.getPassword().equals(oldpassword)){
            user.setPassword(newpassword);
            int i = usermapper.updateById(user);
            return R.ok(i);
        }
        return R.fail(null);
    };

    //添加备忘录
    @PostMapping("/addMemo")
    public R addMemo(@RequestBody Memo memo){
        int insert = memomapper.insert(memo);
        return R.ok(insert);
    };

    //课程选课：选择管理员发布的课程
    @PostMapping("/selectCourse")
    public R selectCourse(@RequestBody Map<String,String> data){
        String courseid = data.get("courseid");
        String userid = data.get("userid");
        Course_Selection course_selection = new Course_Selection(null, Integer.valueOf(courseid), Integer.valueOf(userid));
        int insert = course_selection_mapper.insert(course_selection);
        return R.ok(insert);
    };

    //返回所有可选的课程
    @PostMapping("/getAllCourse")
    public R getAllCourse(){
        LambdaQueryWrapper<Course> lqw = new LambdaQueryWrapper<Course>();
        List<Course> classes = coursemapper.selectList(lqw);
        return R.ok(classes);
    };

    //返回已选课程   用于课程日历表
    @PostMapping("/getAllSelectedCourse")
    public R getAllSelectedCourse(@RequestBody Map<String,Object> data){
        Integer userid = (Integer) data.get("userid");
        LambdaQueryWrapper<Course_Selection> lqw1 = new LambdaQueryWrapper<Course_Selection>();
        lqw1.eq(Course_Selection::getUserid,userid);
        List<Course_Selection> course_selections = course_selection_mapper.selectList(lqw1);
        ArrayList<Integer> courseids = new ArrayList<>();
        for (Course_Selection course_selection : course_selections) {
            courseids.add(course_selection.getCourseid());
        }
        LambdaQueryWrapper<Course> lqw2 = new LambdaQueryWrapper<Course>();
        lqw2.in(Course::getId,courseids);
        List<Course> classes = coursemapper.selectList(lqw2);
        return R.ok(classes);
    };

    //返回可选的教室
    @PostMapping("/getAllClassroom")
    public R getAllClassroom(@RequestBody Map<String,Object> data) throws ParseException {
        String starttime = (String) data.get("starttime");
        String endtime = (String) data.get("endtime");

        LambdaQueryWrapper<Classroom> lqw = new LambdaQueryWrapper<Classroom>();
        if (!ObjectUtils.isEmpty(starttime))
        {
            lqw.lt(Classroom::getStarttime, starttime);
        }
        if (!ObjectUtils.isEmpty(endtime))
        {
            lqw.gt(Classroom::getEndtime, endtime);
        }
        lqw.eq(Classroom::getAvailability,1);
        List<Classroom> classrooms = classroommapper.selectList(lqw);

        return R.ok(classrooms);
    };



    //预约教室
    @PostMapping("/orderClassroom")
    public R orderClassroom(@RequestBody Map<String,Object> data){
        Integer userid = (Integer) data.get("userid");
        Integer classroomid = (Integer) data.get("classroomid");
        String reason = (String) data.get("reason");
        String starttime = (String) data.get("starttime");
        String endtime = (String) data.get("endtime");
        Integer status=0;
        // 获取当前时间
        LocalDateTime currentTime = LocalDateTime.now();
        // 定义时间格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // 格式化当前时间为字符串
        String time = currentTime.format(formatter);

        Reservation reservation = new Reservation(null, classroomid, userid, time, reason, starttime, endtime, status);
        int insert = reservationmapper.insert(reservation);



        return R.ok(insert);
    };

    //返回教室的预约消息结果
    @PostMapping("/getClassroomResult")
    public R getClassroomResult(@RequestBody Map<String,Object> data){
        Integer userid = (Integer) data.get("userid");
        LambdaQueryWrapper<Reservation> lqw = new LambdaQueryWrapper<Reservation>();
        lqw.eq(Reservation::getUserid,userid);
        List<Reservation> reservations = reservationmapper.selectList(lqw);
        return R.ok(reservations);
    };

    //返回所有管理员发布的公告
    @PostMapping("/getAllAnnouncement")
    public R getAllAnnouncement(){
        LambdaQueryWrapper<Announcement> lqw = new LambdaQueryWrapper<Announcement>();
        List<Announcement> announcements = announcementmapper.selectList(lqw);
        return R.ok(announcements);

    };



    //向管理员投诉反馈
    @PostMapping("/addFeedback")
    public R addFeedback(@RequestBody Feedback feedback) throws JsonProcessingException {
        int insert = feedbackmapper.insert(feedback);
        return R.ok(insert);
    };




    //管理员

    //发布公告
    @PostMapping("/addAnnouncement")
    public R addAnnouncement(@RequestBody Announcement announcement){
        int insert = announcementmapper.insert(announcement);
        return R.ok(insert);
    };

    //发布教室
    @PostMapping("/addClassroom")
    public R addClassroom(@RequestBody Classroom classroom){
        classroom.setAvailability(1);
        int insert = classroommapper.insert(classroom);
        return R.ok(insert);
    };

    //发布课程
    @PostMapping("/addCourse")
    public R addCourse(@RequestBody Course course){
        int insert = coursemapper.insert(course);
        return R.ok(insert);
    };

    //返回所有学生的未处理的教室预约申请
    @PostMapping("/getAllUncheckedOrder")
    public R getAllUncheckedOrder(){
        LambdaQueryWrapper<Reservation> lqw = new LambdaQueryWrapper<Reservation>();
        lqw.eq(Reservation::getStatus,0);
        List<Reservation> unchecked_reservations = reservationmapper.selectList(lqw);

        ArrayList<HashMap<String, Object>> res = new ArrayList<>();
        for (Reservation unchecked_reservation : unchecked_reservations) {
            HashMap<String, Object> map = new HashMap<>();
            Classroom classroom = classroommapper.selectById(unchecked_reservation.getClassroomId());
            map.put("unchecked_reservation",unchecked_reservation);
            map.put("classroom",classroom);
            res.add(map);

        }
        return R.ok(res);
    };

    //返回所有学生的已经处理的教室预约申请
    @PostMapping("/getAllCheckedOrder")
    public R getAllCheckedOrder(){
        LambdaQueryWrapper<Reservation> lqw = new LambdaQueryWrapper<Reservation>();
        lqw.ne(Reservation::getStatus,0);
        List<Reservation> checked_reservations = reservationmapper.selectList(lqw);

        ArrayList<HashMap<String, Object>> res = new ArrayList<>();
        for (Reservation checked_reservation : checked_reservations) {
            HashMap<String, Object> map = new HashMap<>();
            Classroom classroom = classroommapper.selectById(checked_reservation.getClassroomId());
            map.put("checked_reservation",checked_reservation);
            map.put("classroom",classroom);
            res.add(map);

        }
        return R.ok(res);
    };

//    通过或拒绝学生的教室预约申请
    @PostMapping("/judgeOrder")
    public R judgeOrder(@RequestBody Map<String,Object> data){
        Integer reservationid = (Integer) data.get("reservationid");
        Integer status = (Integer) data.get("status");



        Reservation reservation = reservationmapper.selectById(reservationid);
        if (status==1){
            //同意
            reservation.setStatus(status);
            //把别的申请都拒绝   先不写
        }else if(status==2){
            //不同意
            reservation.setStatus(status);
        }
        int i = reservationmapper.updateById(reservation);
        //把教室预约改为不可预约
        Integer classroom_id = reservation.getClassroomId();
        Classroom classroom = classroommapper.selectById(classroom_id);
        classroom.setAvailability(0);
        return R.ok(i);
    };

    //接收查看学生的反馈信息
    @PostMapping("/getAllFeedback")
    public R getAllFeedback(){
        LambdaQueryWrapper<Feedback> lqw = new LambdaQueryWrapper<Feedback>();
        List<Feedback> feedbacks = feedbackmapper.selectList(lqw);
        return R.ok(feedbacks);
    };
}
