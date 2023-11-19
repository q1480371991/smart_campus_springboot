package com.example.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : Announcement
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 15:45
 * @updateUser : Lin
 * @updateTime : 2023/11/17 15:45
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcement {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String title;
    private String content;
}
