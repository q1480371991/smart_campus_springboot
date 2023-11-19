package com.example.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smart_campus.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : courseMapper
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 15:15
 * @updateUser : Lin
 * @updateTime : 2023/11/17 15:15
 * @updateRemark : 描述说明本次修改内容
 */
@Mapper
@Repository
public interface courseMapper extends BaseMapper<Course> {
}
