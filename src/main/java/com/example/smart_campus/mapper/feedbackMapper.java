package com.example.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smart_campus.pojo.Feedback;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface feedbackMapper extends BaseMapper<Feedback> {
}
