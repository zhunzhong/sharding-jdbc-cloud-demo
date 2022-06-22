package com.zhunzhong.demo.pojo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
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
@Getter
@Setter
@TableName("t_order")
@AllArgsConstructor
public class TOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value="order_id",type = IdType.ASSIGN_ID)
    private Long orderId;

    @TableField("user_id")
    private Long userId;

    @TableField("status")
    private String status;


    @Override
    public String toString() {
        return "TOrder{" +
            "orderId=" + orderId +
            ", userId=" + userId +
            ", status=" + status +
        "}";
    }
}
