package com.example.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smart_campus.pojo.Classroom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Repository
public interface classroomMapper extends BaseMapper<Classroom> {
    @Select("SELECT * FROM classroom WHERE  #{endtime}< endtime AND  #{starttime}> starttime AND availability=1")
    public ArrayList<Classroom> listClassroomByTime(String starttime,String endtime);
}
