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
 * @className : User
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 14:00
 * @updateUser : Lin
 * @updateTime : 2023/11/17 14:00
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String phone;
    private String email;
    private String signature;
    private  Integer role;
    @TableField("avatar_url")
    private String avatar_url;
}
