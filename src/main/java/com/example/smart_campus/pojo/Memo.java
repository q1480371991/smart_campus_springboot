package com.example.smart_campus.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : Lin
 * @version : [v1.0]
 * @className : Memo
 * @description : 描述说明该类的功能
 * @createTime : 2023/11/17 15:07
 * @updateUser : Lin
 * @updateTime : 2023/11/17 15:07
 * @updateRemark : 描述说明本次修改内容
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Memo {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer userid;
    private String title;
    private String content;
    private String tag;
    private String timestamp;
}
