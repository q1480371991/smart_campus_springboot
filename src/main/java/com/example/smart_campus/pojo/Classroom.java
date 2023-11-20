package com.example.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : Classroom
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 17:26
 * @updateUser : Lin
 * @updateTime : 2023/11/17 17:26
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private Integer availability;
    private Integer capacity;
    private String equipment;
    private String building;
    private String campus;
    private String starttime;
    private String endtime;
}
