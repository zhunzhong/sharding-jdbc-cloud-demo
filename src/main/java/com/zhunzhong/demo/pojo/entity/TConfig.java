package com.zhunzhong.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhunzhong
 * @since 2022-06-17
 */
@TableName("t_config")
@Getter
@Setter
public class TConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="id",type = IdType.AUTO)
    private Long id;

    @TableField("status")
    private String status;


    @Override
    public String toString() {
        return "TConfig{" +
            "id=" + id +
            ", status=" + status +
        "}";
    }
}
