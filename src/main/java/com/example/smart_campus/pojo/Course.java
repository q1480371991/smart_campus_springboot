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
 * @className : Course
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 15:15
 * @updateUser : Lin
 * @updateTime : 2023/11/17 15:15
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String teacher;
    @TableField("image_url")
    private String image_url;
    private Integer limitation;
    private String content;
    private String tag;
    private String starttime;
    private String endtime;
}
