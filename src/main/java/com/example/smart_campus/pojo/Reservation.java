package com.example.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : reservationMapper
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 17:29
 * @updateUser : Lin
 * @updateTime : 2023/11/17 17:29
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "classroom_id")
    private Integer classroom_id;
    private Integer userid;
    private String time;
    private String reason;
    private String starttime;
    private String endtime;
    private Integer status;
}
