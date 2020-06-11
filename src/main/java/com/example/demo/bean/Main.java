package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author ggl
 * @Description
 * @Date 2020/6/10 18:11
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName
public class Main implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String kind;
    private Integer mId;
}
