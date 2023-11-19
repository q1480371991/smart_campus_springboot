package com.example.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smart_campus.pojo.Course_Selection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface course_selectionMapper extends BaseMapper<Course_Selection>{
}
