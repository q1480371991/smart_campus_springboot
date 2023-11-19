package com.example.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : Feedback
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 15:52
 * @updateUser : Lin
 * @updateTime : 2023/11/17 15:52
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userid;
    private String content;
    private String contact;
    private String timestamp;
}
