package com.example.smart_campus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.smart_campus.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface reservationMapper extends BaseMapper<Reservation> {
    @Select("SELECT * from reservation WHERE id=#{reservationid}")
    public Map<String,Object> selectReservationByid(Integer reservationid);
}
